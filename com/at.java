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
    final /* synthetic */ as fIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.fIG = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.fIG.a = asInterface.getPackageName();
            this.fIG.b = asInterface.getActivityName();
            if (!this.fIG.startSingleSignOn()) {
                this.fIG.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.fIG.startAuthDialog();
        } finally {
            Context applicationContext = this.fIG.mActivity.getApplicationContext();
            serviceConnection = this.fIG.fIF;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.fIG.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.fIG.startAuthDialog();
        }
    }
}
