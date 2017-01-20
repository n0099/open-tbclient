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
    final /* synthetic */ as fQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.fQZ = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.fQZ.a = asInterface.getPackageName();
            this.fQZ.b = asInterface.getActivityName();
            if (!this.fQZ.startSingleSignOn()) {
                this.fQZ.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.fQZ.startAuthDialog();
        } finally {
            Context applicationContext = this.fQZ.mActivity.getApplicationContext();
            serviceConnection = this.fQZ.fQY;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.fQZ.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.fQZ.startAuthDialog();
        }
    }
}
