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
    final /* synthetic */ as gdD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.gdD = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.gdD.a = asInterface.getPackageName();
            this.gdD.b = asInterface.getActivityName();
            if (!this.gdD.startSingleSignOn()) {
                this.gdD.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.gdD.startAuthDialog();
        } finally {
            Context applicationContext = this.gdD.mActivity.getApplicationContext();
            serviceConnection = this.gdD.gdC;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.gdD.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.gdD.startAuthDialog();
        }
    }
}
