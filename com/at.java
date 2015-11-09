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
    final /* synthetic */ as dxM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.dxM = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.dxM.a = asInterface.getPackageName();
            this.dxM.b = asInterface.getActivityName();
            if (!this.dxM.startSingleSignOn()) {
                this.dxM.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.dxM.startAuthDialog();
        } finally {
            Context applicationContext = this.dxM.mActivity.getApplicationContext();
            serviceConnection = this.dxM.dxL;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.dxM.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.dxM.startAuthDialog();
        }
    }
}
