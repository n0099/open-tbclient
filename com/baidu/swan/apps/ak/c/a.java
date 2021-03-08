package com.baidu.swan.apps.ak.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.ak.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0364a {
        public boolean dOr;
        public int level;
    }

    @Nullable
    public static C0364a dt(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0364a c0364a = new C0364a();
        c0364a.level = registerReceiver.getIntExtra("level", -1);
        c0364a.dOr = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0364a;
    }
}
