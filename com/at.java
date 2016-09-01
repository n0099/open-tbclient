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
    final /* synthetic */ as glO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.glO = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.glO.a = asInterface.getPackageName();
            this.glO.b = asInterface.getActivityName();
            if (!this.glO.startSingleSignOn()) {
                this.glO.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.glO.startAuthDialog();
        } finally {
            Context applicationContext = this.glO.mActivity.getApplicationContext();
            serviceConnection = this.glO.glN;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.glO.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.glO.startAuthDialog();
        }
    }
}
