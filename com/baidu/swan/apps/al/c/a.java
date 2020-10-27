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
    public static class C0364a {
        public boolean dvL;
        public int level;
    }

    @Nullable
    public static C0364a cA(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0364a c0364a = new C0364a();
        c0364a.level = registerReceiver.getIntExtra("level", -1);
        c0364a.dvL = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0364a;
    }
}
