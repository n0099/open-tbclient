package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cij;
    private boolean cik = false;
    private boolean cil = false;
    private boolean mIsCanceled = false;
    private boolean cim = false;
    private boolean cin = false;
    private int cio = 3000;
    private HashMap<String, Long> cip = new HashMap<>();
    private boolean ciq = false;

    public static a agr() {
        if (cij == null) {
            synchronized (a.class) {
                if (cij == null) {
                    cij = new a();
                }
            }
        }
        return cij;
    }

    private a() {
    }

    public boolean lt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cip == null || !this.cip.containsKey(str) || currentTimeMillis - this.cip.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cip == null || !this.cip.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cip.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean ags() {
        return this.cil;
    }
}
