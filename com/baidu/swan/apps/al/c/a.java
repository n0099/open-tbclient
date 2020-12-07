package com.baidu.swan.apps.al.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes25.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.al.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0386a {
        public boolean dGU;
        public int level;
    }

    @Nullable
    public static C0386a dg(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0386a c0386a = new C0386a();
        c0386a.level = registerReceiver.getIntExtra("level", -1);
        c0386a.dGU = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0386a;
    }
}
