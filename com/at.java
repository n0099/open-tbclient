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
    final /* synthetic */ as eDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.eDX = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.eDX.a = asInterface.getPackageName();
            this.eDX.b = asInterface.getActivityName();
            if (!this.eDX.startSingleSignOn()) {
                this.eDX.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.eDX.startAuthDialog();
        } finally {
            Context applicationContext = this.eDX.mActivity.getApplicationContext();
            serviceConnection = this.eDX.eDW;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.eDX.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.eDX.startAuthDialog();
        }
    }
}
