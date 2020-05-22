package com.baidu.swan.apps.am.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.am.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0290a {
        public boolean cHO;
        public int level;
    }

    @Nullable
    public static C0290a cl(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0290a c0290a = new C0290a();
        c0290a.level = registerReceiver.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, -1);
        c0290a.cHO = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0290a;
    }
}
