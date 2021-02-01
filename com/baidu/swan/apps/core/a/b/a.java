package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cQy;
    private boolean cQz = false;
    private boolean cQA = false;
    private boolean mIsCanceled = false;
    private boolean mIsEnabled = false;
    private boolean cQB = false;
    private int cQC = 3000;
    private HashMap<String, Long> cQD = new HashMap<>();
    private boolean cQE = false;

    public static a anM() {
        if (cQy == null) {
            synchronized (a.class) {
                if (cQy == null) {
                    cQy = new a();
                }
            }
        }
        return cQy;
    }

    private a() {
    }

    public boolean mo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cQD == null || !this.cQD.containsKey(str) || currentTimeMillis - this.cQD.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cQD == null || !this.cQD.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cQD.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean anN() {
        return this.cQA;
    }
}
