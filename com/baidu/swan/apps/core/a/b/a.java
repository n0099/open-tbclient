package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cak;
    private boolean cal = false;
    private boolean cam = false;
    private boolean mIsCanceled = false;
    private boolean can = false;
    private boolean cao = false;
    private int cap = 3000;
    private HashMap<String, Long> caq = new HashMap<>();
    private boolean car = false;

    public static a Zy() {
        if (cak == null) {
            synchronized (a.class) {
                if (cak == null) {
                    cak = new a();
                }
            }
        }
        return cak;
    }

    private a() {
    }

    public boolean jA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.caq == null || !this.caq.containsKey(str) || currentTimeMillis - this.caq.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.caq == null || !this.caq.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.caq.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean Zz() {
        return this.cam;
    }
}
