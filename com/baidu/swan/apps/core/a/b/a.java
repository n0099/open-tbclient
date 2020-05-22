package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a bUf;
    private boolean bUg = false;
    private boolean bUh = false;
    private boolean mIsCanceled = false;
    private boolean bUi = false;
    private boolean bUj = false;
    private int bUk = 3000;
    private HashMap<String, Long> bUl = new HashMap<>();
    private boolean bUm = false;

    public static a XA() {
        if (bUf == null) {
            synchronized (a.class) {
                if (bUf == null) {
                    bUf = new a();
                }
            }
        }
        return bUf;
    }

    private a() {
    }

    public boolean jd(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bUl == null || !this.bUl.containsKey(str) || currentTimeMillis - this.bUl.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.bUl == null || !this.bUl.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.bUl.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean XB() {
        return this.bUh;
    }
}
