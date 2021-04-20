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
    public final /* synthetic */ LocationClient f6643a;

    public b(LocationClient locationClient) {
        this.f6643a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c2;
        Boolean bool;
        this.f6643a.f6478g = new Messenger(iBinder);
        if (this.f6643a.f6478g == null) {
            return;
        }
        this.f6643a.f6476e = true;
        Log.d("baidu_location_client", "baidu location connected ...");
        z = this.f6643a.x;
        if (z) {
            this.f6643a.f6479h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.f6643a.i;
            c2 = this.f6643a.c();
            obtain.setData(c2);
            this.f6643a.f6478g.send(obtain);
            this.f6643a.f6476e = true;
            if (this.f6643a.f6474c != null) {
                bool = this.f6643a.A;
                bool.booleanValue();
                this.f6643a.f6479h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f6643a.f6478g = null;
        this.f6643a.f6476e = false;
    }
}
