package com.baidu.swan.apps.core.a.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = c.DEBUG;
    private static b apj;
    private boolean apk = false;
    private boolean apl = false;
    private boolean mIsCanceled = false;
    private boolean apm = false;
    private boolean apn = false;
    private int apo = 3000;
    private HashMap<String, Long> apq = new HashMap<>();
    private boolean apr = false;

    public static b xP() {
        if (apj == null) {
            synchronized (b.class) {
                if (apj == null) {
                    apj = new b();
                }
            }
        }
        return apj;
    }

    private b() {
    }

    public boolean dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.apq == null || !this.apq.containsKey(str) || currentTimeMillis - this.apq.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.apq == null || !this.apq.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.apq.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean isInProgress() {
        return this.apl;
    }
}
