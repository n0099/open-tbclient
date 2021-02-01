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
/* loaded from: classes4.dex */
public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocationClient f2592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LocationClient locationClient) {
        this.f2592a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c;
        Boolean bool;
        this.f2592a.g = new Messenger(iBinder);
        if (this.f2592a.g == null) {
            return;
        }
        this.f2592a.e = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        z = this.f2592a.x;
        if (z) {
            this.f2592a.h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.f2592a.i;
            c = this.f2592a.c();
            obtain.setData(c);
            this.f2592a.g.send(obtain);
            this.f2592a.e = true;
            if (this.f2592a.c != null) {
                bool = this.f2592a.A;
                if (bool.booleanValue()) {
                }
                this.f2592a.h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception e) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2592a.g = null;
        this.f2592a.e = false;
    }
}
