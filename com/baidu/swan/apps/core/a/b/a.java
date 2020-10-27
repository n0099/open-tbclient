package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a cCY;
    private boolean cCZ = false;
    private boolean cDa = false;
    private boolean mIsCanceled = false;
    private boolean cDb = false;
    private boolean cDc = false;
    private int cDd = 3000;
    private HashMap<String, Long> cDe = new HashMap<>();
    private boolean cDf = false;

    public static a akW() {
        if (cCY == null) {
            synchronized (a.class) {
                if (cCY == null) {
                    cCY = new a();
                }
            }
        }
        return cCY;
    }

    private a() {
    }

    public boolean my(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cDe == null || !this.cDe.containsKey(str) || currentTimeMillis - this.cDe.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.cDe == null || !this.cDe.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.cDe.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean akX() {
        return this.cDa;
    }
}
