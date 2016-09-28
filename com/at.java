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
    final /* synthetic */ as gnZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.gnZ = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.gnZ.a = asInterface.getPackageName();
            this.gnZ.b = asInterface.getActivityName();
            if (!this.gnZ.startSingleSignOn()) {
                this.gnZ.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.gnZ.startAuthDialog();
        } finally {
            Context applicationContext = this.gnZ.mActivity.getApplicationContext();
            serviceConnection = this.gnZ.gnY;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.gnZ.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.gnZ.startAuthDialog();
        }
    }
}
