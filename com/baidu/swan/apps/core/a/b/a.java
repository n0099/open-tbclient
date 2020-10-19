package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cuC;
    private boolean cuD = false;
    private boolean cuE = false;
    private boolean mIsCanceled = false;
    private boolean cuF = false;
    private boolean cuG = false;
    private int cuH = 3000;
    private HashMap<String, Long> cuI = new HashMap<>();
    private boolean cuJ = false;

    public static a ajc() {
        if (cuC == null) {
            synchronized (a.class) {
                if (cuC == null) {
                    cuC = new a();
                }
            }
        }
        return cuC;
    }

    private a() {
    }

    public boolean mf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cuI == null || !this.cuI.containsKey(str) || currentTimeMillis - this.cuI.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cuI == null || !this.cuI.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cuI.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean ajd() {
        return this.cuE;
    }
}
