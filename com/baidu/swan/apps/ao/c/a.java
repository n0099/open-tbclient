package com.baidu.swan.apps.ao.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.ao.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0256a {
        public boolean cvN;
        public int level;
    }

    @Nullable
    public static C0256a bZ(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0256a c0256a = new C0256a();
        c0256a.level = registerReceiver.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, -1);
        c0256a.cvN = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0256a;
    }
}
