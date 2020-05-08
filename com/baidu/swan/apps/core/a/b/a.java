package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a bLi;
    private boolean bLj = false;
    private boolean bLk = false;
    private boolean mIsCanceled = false;
    private boolean bLl = false;
    private boolean bLm = false;
    private int bLn = 3000;
    private HashMap<String, Long> bLo = new HashMap<>();
    private boolean bLp = false;

    public static a UU() {
        if (bLi == null) {
            synchronized (a.class) {
                if (bLi == null) {
                    bLi = new a();
                }
            }
        }
        return bLi;
    }

    private a() {
    }

    public boolean ic(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bLo == null || !this.bLo.containsKey(str) || currentTimeMillis - this.bLo.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.bLo == null || !this.bLo.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.bLo.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean UV() {
        return this.bLk;
    }
}
