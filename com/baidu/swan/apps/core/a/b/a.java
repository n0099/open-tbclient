package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a bmW;
    private boolean bmX = false;
    private boolean bmY = false;
    private boolean mIsCanceled = false;
    private boolean bmZ = false;
    private boolean bna = false;
    private int bnb = 3000;
    private HashMap<String, Long> bnc = new HashMap<>();
    private boolean bnd = false;

    public static a Ni() {
        if (bmW == null) {
            synchronized (a.class) {
                if (bmW == null) {
                    bmW = new a();
                }
            }
        }
        return bmW;
    }

    private a() {
    }

    public boolean gO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bnc == null || !this.bnc.containsKey(str) || currentTimeMillis - this.bnc.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.bnc == null || !this.bnc.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.bnc.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean Nj() {
        return this.bmY;
    }
}
