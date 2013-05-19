package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ServiceConnection {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.a = eVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Messenger messenger;
        Messenger messenger2;
        Bundle i;
        Messenger messenger3;
        j jVar;
        h hVar;
        this.a.h = new Messenger(iBinder);
        messenger = this.a.h;
        if (messenger == null) {
            ap.a("baidu_location_Client", "server not connected");
            return;
        }
        this.a.f = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            messenger2 = this.a.j;
            obtain.replyTo = messenger2;
            i = this.a.i();
            obtain.setData(i);
            messenger3 = this.a.h;
            messenger3.send(obtain);
            this.a.f = true;
            this.a.r = true;
            ap.a("baidu_location_Client", "bindService ...");
            jVar = this.a.e;
            if (jVar != null) {
                hVar = this.a.i;
                hVar.obtainMessage(4).sendToTarget();
            }
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.h = null;
        this.a.f = false;
        ap.a("baidu_location_Client", "unbindservice...");
    }
}
