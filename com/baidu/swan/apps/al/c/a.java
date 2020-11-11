package com.baidu.swan.apps.al.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.al.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0376a {
        public boolean dBD;
        public int level;
    }

    @Nullable
    public static C0376a cA(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0376a c0376a = new C0376a();
        c0376a.level = registerReceiver.getIntExtra("level", -1);
        c0376a.dBD = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0376a;
    }
}
