package com.baidu.swan.apps.ak.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: com.baidu.swan.apps.ak.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0378a {
        public boolean dPy;
        public int level;
    }

    @Nullable
    public static C0378a dw(@NonNull Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        C0378a c0378a = new C0378a();
        c0378a.level = registerReceiver.getIntExtra(MapBundleKey.MapObjKey.OBJ_LEVEL, -1);
        c0378a.dPy = registerReceiver.getIntExtra("plugged", 0) != 0;
        return c0378a;
    }
}
