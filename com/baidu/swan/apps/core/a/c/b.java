package com.baidu.swan.apps.core.a.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aqD;
    private boolean aqE = false;
    private boolean aqF = false;
    private boolean mIsCanceled = false;
    private boolean aqG = false;
    private boolean aqH = false;
    private int aqI = 3000;
    private HashMap<String, Long> aqJ = new HashMap<>();
    private boolean aqK = false;

    public static b zq() {
        if (aqD == null) {
            synchronized (b.class) {
                if (aqD == null) {
                    aqD = new b();
                }
            }
        }
        return aqD;
    }

    private b() {
    }

    public boolean dF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aqJ == null || !this.aqJ.containsKey(str) || currentTimeMillis - this.aqJ.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.aqJ == null || !this.aqJ.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.aqJ.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean zr() {
        return this.aqF;
    }
}
