package com.baidu.swan.apps.core.a.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b apC;
    private boolean apD = false;
    private boolean apE = false;
    private boolean mIsCanceled = false;
    private boolean apF = false;
    private boolean apG = false;
    private int apH = 3000;
    private HashMap<String, Long> apI = new HashMap<>();
    private boolean apJ = false;

    public static b yG() {
        if (apC == null) {
            synchronized (b.class) {
                if (apC == null) {
                    apC = new b();
                }
            }
        }
        return apC;
    }

    private b() {
    }

    public boolean dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.apI == null || !this.apI.containsKey(str) || currentTimeMillis - this.apI.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.apI == null || !this.apI.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.apI.get(str) + " ，id = " + str);
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
        return this.apE;
    }
}
