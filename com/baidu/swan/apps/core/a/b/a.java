package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a bmI;
    private boolean bmJ = false;
    private boolean bmK = false;
    private boolean mIsCanceled = false;
    private boolean bmL = false;
    private boolean bmM = false;
    private int bmN = 3000;
    private HashMap<String, Long> bmO = new HashMap<>();
    private boolean bmP = false;

    public static a Nf() {
        if (bmI == null) {
            synchronized (a.class) {
                if (bmI == null) {
                    bmI = new a();
                }
            }
        }
        return bmI;
    }

    private a() {
    }

    public boolean gP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bmO == null || !this.bmO.containsKey(str) || currentTimeMillis - this.bmO.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.bmO == null || !this.bmO.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.bmO.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean Ng() {
        return this.bmK;
    }
}
