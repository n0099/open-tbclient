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
    public static class C0113a {
        public boolean aWB;
        public int level;
    }

    @Nullable
    public static C0113a bE(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0113a c0113a = new C0113a();
        c0113a.level = registerReceiver.getIntExtra("level", -1);
        c0113a.aWB = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0113a;
    }
}
