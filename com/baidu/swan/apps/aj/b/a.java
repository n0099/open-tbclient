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
    public static class C0110a {
        public boolean aXl;
        public int level;
    }

    @Nullable
    public static C0110a bE(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0110a c0110a = new C0110a();
        c0110a.level = registerReceiver.getIntExtra("level", -1);
        c0110a.aXl = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0110a;
    }
}
