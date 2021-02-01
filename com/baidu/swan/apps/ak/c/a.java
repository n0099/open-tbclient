package com.baidu.swan.apps.ak.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.ak.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0358a {
        public boolean dMQ;
        public int level;
    }

    @Nullable
    public static C0358a du(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0358a c0358a = new C0358a();
        c0358a.level = registerReceiver.getIntExtra("level", -1);
        c0358a.dMQ = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0358a;
    }
}
