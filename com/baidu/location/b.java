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
/* loaded from: classes15.dex */
public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocationClient f2579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LocationClient locationClient) {
        this.f2579a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c;
        Boolean bool;
        this.f2579a.g = new Messenger(iBinder);
        if (this.f2579a.g == null) {
            return;
        }
        this.f2579a.e = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        z = this.f2579a.x;
        if (z) {
            this.f2579a.h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.f2579a.i;
            c = this.f2579a.c();
            obtain.setData(c);
            this.f2579a.g.send(obtain);
            this.f2579a.e = true;
            if (this.f2579a.c != null) {
                bool = this.f2579a.A;
                if (bool.booleanValue()) {
                }
                this.f2579a.h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception e) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2579a.g = null;
        this.f2579a.e = false;
    }
}
