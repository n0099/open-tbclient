package com.baidu.adp.lib.debug.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f385a = null;
    Context b;

    public b(Context context) {
        this.b = null;
        this.b = context;
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void b() {
        super.b();
        this.f385a = new c(this);
        this.b.registerReceiver(this.f385a, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void c() {
        super.c();
        this.b.unregisterReceiver(this.f385a);
    }
}
