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
    final /* synthetic */ as gvL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.gvL = asVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.gvL.a = asInterface.getPackageName();
            this.gvL.b = asInterface.getActivityName();
            if (!this.gvL.startSingleSignOn()) {
                this.gvL.startAuthDialog();
            }
        } catch (RemoteException e) {
            this.gvL.startAuthDialog();
        } finally {
            Context applicationContext = this.gvL.mActivity.getApplicationContext();
            serviceConnection = this.gvL.gvK;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.gvL.mActivity).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.gvL.startAuthDialog();
        }
    }
}
