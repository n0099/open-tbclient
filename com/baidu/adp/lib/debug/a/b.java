package com.baidu.adp.lib.debug.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes.dex */
public class b extends a {
    BroadcastReceiver gm = null;
    Context mContext;

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void start() {
        super.start();
        this.gm = new c(this);
        this.mContext.registerReceiver(this.gm, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void stop() {
        super.stop();
    }
}
