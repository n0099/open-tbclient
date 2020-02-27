package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements ServiceConnection {
    final /* synthetic */ LocationClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LocationClient locationClient) {
        this.a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c;
        Boolean bool;
        this.a.g = new Messenger(iBinder);
        if (this.a.g == null) {
            return;
        }
        this.a.e = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        z = this.a.x;
        if (z) {
            this.a.h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.a.i;
            c = this.a.c();
            obtain.setData(c);
            this.a.g.send(obtain);
            this.a.e = true;
            if (this.a.c != null) {
                bool = this.a.A;
                if (bool.booleanValue()) {
                }
                this.a.h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception e) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.g = null;
        this.a.e = false;
    }
}
