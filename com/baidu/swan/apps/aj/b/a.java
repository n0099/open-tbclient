package com.baidu.swan.apps.aj.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.aj.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0151a {
        public boolean bqu;
        public int level;
    }

    @Nullable
    public static C0151a bF(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0151a c0151a = new C0151a();
        c0151a.level = registerReceiver.getIntExtra("level", -1);
        c0151a.bqu = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0151a;
    }
}
