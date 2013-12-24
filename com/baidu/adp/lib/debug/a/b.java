package com.baidu.adp.lib.debug.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public class b extends a {
    BroadcastReceiver a = null;
    Context b;

    public b(Context context) {
        this.b = null;
        this.b = context;
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void b() {
        super.b();
        this.a = new c(this);
        this.b.registerReceiver(this.a, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void c() {
        super.c();
    }
}
