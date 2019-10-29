package com.baidu.swan.apps.core.a.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aJT;
    private boolean aJU = false;
    private boolean aJV = false;
    private boolean mIsCanceled = false;
    private boolean aJW = false;
    private boolean aJX = false;
    private int aJY = 3000;
    private HashMap<String, Long> aJZ = new HashMap<>();
    private boolean aKa = false;

    public static b El() {
        if (aJT == null) {
            synchronized (b.class) {
                if (aJT == null) {
                    aJT = new b();
                }
            }
        }
        return aJT;
    }

    private b() {
    }

    public boolean en(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aJZ == null || !this.aJZ.containsKey(str) || currentTimeMillis - this.aJZ.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.aJZ == null || !this.aJZ.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.aJZ.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean Em() {
        return this.aJV;
    }
}
