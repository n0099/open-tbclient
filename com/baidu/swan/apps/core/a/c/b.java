package com.baidu.swan.apps.core.a.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b apq;
    private boolean apr = false;
    private boolean aps = false;
    private boolean mIsCanceled = false;
    private boolean apt = false;
    private boolean apu = false;
    private int apv = 3000;
    private HashMap<String, Long> apw = new HashMap<>();
    private boolean apx = false;

    public static b xO() {
        if (apq == null) {
            synchronized (b.class) {
                if (apq == null) {
                    apq = new b();
                }
            }
        }
        return apq;
    }

    private b() {
    }

    public boolean dM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.apw == null || !this.apw.containsKey(str) || currentTimeMillis - this.apw.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.apw == null || !this.apw.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.apw.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean isInProgress() {
        return this.aps;
    }
}
