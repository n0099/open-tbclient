package com.baidu.swan.apps.al.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.al.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0338a {
        public boolean cYZ;
        public int level;
    }

    @Nullable
    public static C0338a cv(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0338a c0338a = new C0338a();
        c0338a.level = registerReceiver.getIntExtra("level", -1);
        c0338a.cYZ = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0338a;
    }
}
