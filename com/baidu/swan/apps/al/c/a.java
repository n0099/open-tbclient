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
    public static class C0350a {
        public boolean dnj;
        public int level;
    }

    @Nullable
    public static C0350a cA(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0350a c0350a = new C0350a();
        c0350a.level = registerReceiver.getIntExtra("level", -1);
        c0350a.dnj = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0350a;
    }
}
