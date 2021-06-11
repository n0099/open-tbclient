package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
/* loaded from: classes2.dex */
public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationClient f6474a;

    public b(LocationClient locationClient) {
        this.f6474a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c2;
        Boolean bool;
        this.f6474a.f6461g = new Messenger(iBinder);
        if (this.f6474a.f6461g == null) {
            return;
        }
        this.f6474a.f6459e = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        z = this.f6474a.x;
        if (z) {
            this.f6474a.f6462h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.f6474a.f6463i;
            c2 = this.f6474a.c();
            obtain.setData(c2);
            this.f6474a.f6461g.send(obtain);
            this.f6474a.f6459e = true;
            if (this.f6474a.f6457c != null) {
                bool = this.f6474a.A;
                bool.booleanValue();
                this.f6474a.f6462h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f6474a.f6461g = null;
        this.f6474a.f6459e = false;
    }
}
