package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a bLd;
    private boolean bLe = false;
    private boolean bLf = false;
    private boolean mIsCanceled = false;
    private boolean bLg = false;
    private boolean bLh = false;
    private int bLi = 3000;
    private HashMap<String, Long> bLj = new HashMap<>();
    private boolean bLk = false;

    public static a UV() {
        if (bLd == null) {
            synchronized (a.class) {
                if (bLd == null) {
                    bLd = new a();
                }
            }
        }
        return bLd;
    }

    private a() {
    }

    public boolean ic(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bLj == null || !this.bLj.containsKey(str) || currentTimeMillis - this.bLj.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.bLj == null || !this.bLj.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.bLj.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean UW() {
        return this.bLf;
    }
}
