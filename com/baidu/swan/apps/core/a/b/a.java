package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cSW;
    private boolean cSX = false;
    private boolean cSY = false;
    private boolean mIsCanceled = false;
    private boolean mIsEnabled = false;
    private boolean cSZ = false;
    private int cTa = 3000;
    private HashMap<String, Long> cTb = new HashMap<>();
    private boolean cTc = false;

    public static a arj() {
        if (cSW == null) {
            synchronized (a.class) {
                if (cSW == null) {
                    cSW = new a();
                }
            }
        }
        return cSW;
    }

    private a() {
    }

    public boolean nh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cTb == null || !this.cTb.containsKey(str) || currentTimeMillis - this.cTb.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cTb == null || !this.cTb.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cTb.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean ark() {
        return this.cSY;
    }
}
