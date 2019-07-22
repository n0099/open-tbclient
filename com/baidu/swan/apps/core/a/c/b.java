package com.baidu.swan.apps.core.a.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b aqf;
    private boolean aqg = false;
    private boolean aqh = false;
    private boolean mIsCanceled = false;
    private boolean aqi = false;
    private boolean aqj = false;
    private int aqk = 3000;
    private HashMap<String, Long> aql = new HashMap<>();
    private boolean aqm = false;

    public static b zm() {
        if (aqf == null) {
            synchronized (b.class) {
                if (aqf == null) {
                    aqf = new b();
                }
            }
        }
        return aqf;
    }

    private b() {
    }

    public boolean dD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aql == null || !this.aql.containsKey(str) || currentTimeMillis - this.aql.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.aql == null || !this.aql.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.aql.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean zn() {
        return this.aqh;
    }
}
