package com.baidu.swan.apps.al.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.al.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0374a {
        public boolean dzW;
        public int level;
    }

    @Nullable
    public static C0374a cA(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0374a c0374a = new C0374a();
        c0374a.level = registerReceiver.getIntExtra("level", -1);
        c0374a.dzW = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0374a;
    }
}
