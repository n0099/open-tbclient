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
    final /* synthetic */ as edC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.edC = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.edC.a = asInterface.getPackageName();
            this.edC.b = asInterface.getActivityName();
            if (!this.edC.startSingleSignOn()) {
                this.edC.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.edC.startAuthDialog();
        } finally {
            Context applicationContext = this.edC.mActivity.getApplicationContext();
            serviceConnection = this.edC.edB;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.edC.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.edC.startAuthDialog();
        }
    }
}
