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
    final /* synthetic */ as dvT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.dvT = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.dvT.a = asInterface.getPackageName();
            this.dvT.b = asInterface.getActivityName();
            if (!this.dvT.startSingleSignOn()) {
                this.dvT.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.dvT.startAuthDialog();
        } finally {
            Context applicationContext = this.dvT.mActivity.getApplicationContext();
            serviceConnection = this.dvT.dvS;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.dvT.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.dvT.startAuthDialog();
        }
    }
}
