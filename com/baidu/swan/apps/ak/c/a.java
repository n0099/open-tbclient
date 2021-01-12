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
    public static class C0361a {
        public boolean dKM;
        public int level;
    }

    @Nullable
    public static C0361a dv(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0361a c0361a = new C0361a();
        c0361a.level = registerReceiver.getIntExtra("level", -1);
        c0361a.dKM = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0361a;
    }
}
