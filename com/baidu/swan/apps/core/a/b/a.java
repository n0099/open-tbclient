package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cgh;
    private boolean cgi = false;
    private boolean cgj = false;
    private boolean mIsCanceled = false;
    private boolean cgk = false;
    private boolean cgl = false;
    private int cgm = 3000;
    private HashMap<String, Long> cgn = new HashMap<>();
    private boolean cgo = false;

    public static a afH() {
        if (cgh == null) {
            synchronized (a.class) {
                if (cgh == null) {
                    cgh = new a();
                }
            }
        }
        return cgh;
    }

    private a() {
    }

    public boolean la(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cgn == null || !this.cgn.containsKey(str) || currentTimeMillis - this.cgn.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cgn == null || !this.cgn.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cgn.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean afI() {
        return this.cgj;
    }
}
