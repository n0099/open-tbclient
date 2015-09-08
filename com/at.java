package com;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.sina.sso.RemoteSSO;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements ServiceConnection {
    final /* synthetic */ as djy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.djy = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.djy.a = asInterface.getPackageName();
            this.djy.b = asInterface.getActivityName();
            if (!this.djy.startSingleSignOn()) {
                this.djy.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.djy.startAuthDialog();
        } finally {
            Context applicationContext = this.djy.mActivity.getApplicationContext();
            serviceConnection = this.djy.djx;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.djy.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.djy.startAuthDialog();
        }
    }
}
