package com.baidu.swan.apps.ao.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.ao.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0195a {
        public boolean bSz;
        public int level;
    }

    @Nullable
    public static C0195a cu(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0195a c0195a = new C0195a();
        c0195a.level = registerReceiver.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, -1);
        c0195a.bSz = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0195a;
    }
}
