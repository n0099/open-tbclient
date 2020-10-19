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
/* loaded from: classes7.dex */
public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocationClient f1860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LocationClient locationClient) {
        this.f1860a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c;
        Boolean bool;
        this.f1860a.g = new Messenger(iBinder);
        if (this.f1860a.g == null) {
            return;
        }
        this.f1860a.e = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        z = this.f1860a.x;
        if (z) {
            this.f1860a.h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.f1860a.i;
            c = this.f1860a.c();
            obtain.setData(c);
            this.f1860a.g.send(obtain);
            this.f1860a.e = true;
            if (this.f1860a.c != null) {
                bool = this.f1860a.A;
                if (bool.booleanValue()) {
                }
                this.f1860a.h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception e) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f1860a.g = null;
        this.f1860a.e = false;
    }
}
