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
    final /* synthetic */ as dvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.dvt = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.dvt.a = asInterface.getPackageName();
            this.dvt.b = asInterface.getActivityName();
            if (!this.dvt.startSingleSignOn()) {
                this.dvt.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.dvt.startAuthDialog();
        } finally {
            Context applicationContext = this.dvt.mActivity.getApplicationContext();
            serviceConnection = this.dvt.dvs;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.dvt.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.dvt.startAuthDialog();
        }
    }
}
