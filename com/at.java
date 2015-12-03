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
    final /* synthetic */ as dWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.dWe = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.dWe.a = asInterface.getPackageName();
            this.dWe.b = asInterface.getActivityName();
            if (!this.dWe.startSingleSignOn()) {
                this.dWe.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.dWe.startAuthDialog();
        } finally {
            Context applicationContext = this.dWe.mActivity.getApplicationContext();
            serviceConnection = this.dWe.dWd;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.dWe.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.dWe.startAuthDialog();
        }
    }
}
