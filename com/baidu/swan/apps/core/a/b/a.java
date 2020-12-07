package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cOb;
    private boolean cOc = false;
    private boolean cOd = false;
    private boolean mIsCanceled = false;
    private boolean mIsEnabled = false;
    private boolean cOe = false;
    private int cOf = 3000;
    private HashMap<String, Long> cOg = new HashMap<>();
    private boolean cOh = false;

    public static a apW() {
        if (cOb == null) {
            synchronized (a.class) {
                if (cOb == null) {
                    cOb = new a();
                }
            }
        }
        return cOb;
    }

    private a() {
    }

    public boolean no(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cOg == null || !this.cOg.containsKey(str) || currentTimeMillis - this.cOg.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cOg == null || !this.cOg.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cOg.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean apX() {
        return this.cOd;
    }
}
