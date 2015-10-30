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
    final /* synthetic */ as dvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.dvU = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.dvU.a = asInterface.getPackageName();
            this.dvU.b = asInterface.getActivityName();
            if (!this.dvU.startSingleSignOn()) {
                this.dvU.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.dvU.startAuthDialog();
        } finally {
            Context applicationContext = this.dvU.mActivity.getApplicationContext();
            serviceConnection = this.dvU.dvT;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.dvU.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.dvU.startAuthDialog();
        }
    }
}
