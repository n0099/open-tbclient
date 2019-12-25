package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a bhF;
    private boolean bhG = false;
    private boolean bhH = false;
    private boolean mIsCanceled = false;
    private boolean bhI = false;
    private boolean bhJ = false;
    private int bhK = 3000;
    private HashMap<String, Long> bhL = new HashMap<>();
    private boolean bhM = false;

    public static a Ks() {
        if (bhF == null) {
            synchronized (a.class) {
                if (bhF == null) {
                    bhF = new a();
                }
            }
        }
        return bhF;
    }

    private a() {
    }

    public boolean gx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bhL == null || !this.bhL.containsKey(str) || currentTimeMillis - this.bhL.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.bhL == null || !this.bhL.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.bhL.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean Kt() {
        return this.bhH;
    }
}
