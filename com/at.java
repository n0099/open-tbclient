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
    final /* synthetic */ as fjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.fjW = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.fjW.a = asInterface.getPackageName();
            this.fjW.b = asInterface.getActivityName();
            if (!this.fjW.startSingleSignOn()) {
                this.fjW.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.fjW.startAuthDialog();
        } finally {
            Context applicationContext = this.fjW.mActivity.getApplicationContext();
            serviceConnection = this.fjW.fjV;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.fjW.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.fjW.startAuthDialog();
        }
    }
}
