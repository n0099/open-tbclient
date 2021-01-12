package com.baidu.mobads.openad.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes14.dex */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f3393a;
    private b d;
    private IntentFilter e;

    public c(Context context) {
        super(context);
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        this.d = (b) broadcastReceiver;
    }

    public void a() {
        if (this.f3393a == 0) {
            if (this.d == null) {
                a(new b(this));
            }
            this.e = new IntentFilter();
            this.e.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        this.f3393a++;
        this.f3391b.registerReceiver(this.d, this.e);
    }

    public void b() {
        dispatchEvent(new com.baidu.mobads.openad.c.b("network_changed"));
    }
}
