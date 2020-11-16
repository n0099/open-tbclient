package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cHh;
    private boolean cHi = false;
    private boolean cHj = false;
    private boolean mIsCanceled = false;
    private boolean cHk = false;
    private boolean cHl = false;
    private int cHm = 3000;
    private HashMap<String, Long> cHn = new HashMap<>();
    private boolean cHo = false;

    public static a amO() {
        if (cHh == null) {
            synchronized (a.class) {
                if (cHh == null) {
                    cHh = new a();
                }
            }
        }
        return cHh;
    }

    private a() {
    }

    public boolean mH(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cHn == null || !this.cHn.containsKey(str) || currentTimeMillis - this.cHn.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cHn == null || !this.cHn.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cHn.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean amP() {
        return this.cHj;
    }
}
