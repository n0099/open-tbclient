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
    final /* synthetic */ as fjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.fjX = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.fjX.a = asInterface.getPackageName();
            this.fjX.b = asInterface.getActivityName();
            if (!this.fjX.startSingleSignOn()) {
                this.fjX.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.fjX.startAuthDialog();
        } finally {
            Context applicationContext = this.fjX.mActivity.getApplicationContext();
            serviceConnection = this.fjX.fjW;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.fjX.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.fjX.startAuthDialog();
        }
    }
}
