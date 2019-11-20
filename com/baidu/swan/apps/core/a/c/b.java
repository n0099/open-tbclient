package com.baidu.swan.apps.core.a.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aJB;
    private boolean aJC = false;
    private boolean aJD = false;
    private boolean mIsCanceled = false;
    private boolean aJE = false;
    private boolean aJF = false;
    private int aJG = 3000;
    private HashMap<String, Long> aJH = new HashMap<>();
    private boolean aJI = false;

    public static b Em() {
        if (aJB == null) {
            synchronized (b.class) {
                if (aJB == null) {
                    aJB = new b();
                }
            }
        }
        return aJB;
    }

    private b() {
    }

    public boolean en(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aJH == null || !this.aJH.containsKey(str) || currentTimeMillis - this.aJH.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.aJH == null || !this.aJH.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.aJH.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean En() {
        return this.aJD;
    }
}
