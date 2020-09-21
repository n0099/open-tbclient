package com.baidu.swan.apps.al.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.al.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0333a {
        public boolean dbb;
        public int level;
    }

    @Nullable
    public static C0333a cu(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0333a c0333a = new C0333a();
        c0333a.level = registerReceiver.getIntExtra("level", -1);
        c0333a.dbb = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0333a;
    }
}
