package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cOk;
    private boolean cOl = false;
    private boolean cOm = false;
    private boolean mIsCanceled = false;
    private boolean mIsEnabled = false;
    private boolean cOn = false;
    private int cOo = 3000;
    private HashMap<String, Long> cOp = new HashMap<>();
    private boolean cOq = false;

    public static a ano() {
        if (cOk == null) {
            synchronized (a.class) {
                if (cOk == null) {
                    cOk = new a();
                }
            }
        }
        return cOk;
    }

    private a() {
    }

    public boolean lW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cOp == null || !this.cOp.containsKey(str) || currentTimeMillis - this.cOp.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cOp == null || !this.cOp.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cOp.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean anp() {
        return this.cOm;
    }
}
