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
    final /* synthetic */ as gbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.gbI = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.gbI.a = asInterface.getPackageName();
            this.gbI.b = asInterface.getActivityName();
            if (!this.gbI.startSingleSignOn()) {
                this.gbI.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.gbI.startAuthDialog();
        } finally {
            Context applicationContext = this.gbI.mActivity.getApplicationContext();
            serviceConnection = this.gbI.gbH;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.gbI.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.gbI.startAuthDialog();
        }
    }
}
