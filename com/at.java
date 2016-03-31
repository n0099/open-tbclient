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
    final /* synthetic */ as eXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.eXQ = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.eXQ.a = asInterface.getPackageName();
            this.eXQ.b = asInterface.getActivityName();
            if (!this.eXQ.startSingleSignOn()) {
                this.eXQ.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.eXQ.startAuthDialog();
        } finally {
            Context applicationContext = this.eXQ.mActivity.getApplicationContext();
            serviceConnection = this.eXQ.eXP;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.eXQ.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.eXQ.startAuthDialog();
        }
    }
}
