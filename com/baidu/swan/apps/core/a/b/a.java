package com.baidu.swan.apps.core.a.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static a bix;
    private boolean biy = false;
    private boolean biz = false;
    private boolean mIsCanceled = false;
    private boolean biA = false;
    private boolean biB = false;
    private int biC = 3000;
    private HashMap<String, Long> biD = new HashMap<>();
    private boolean biE = false;

    public static a KO() {
        if (bix == null) {
            synchronized (a.class) {
                if (bix == null) {
                    bix = new a();
                }
            }
        }
        return bix;
    }

    private a() {
    }

    public boolean gA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.biD == null || !this.biD.containsKey(str) || currentTimeMillis - this.biD.get(str).longValue() > 18000000) {
            if (DEBUG) {
                if (this.biD == null || !this.biD.containsKey(str)) {
                    Log.d("SilentUpdateManager", "小程序未被标记未无更新， id = " + str);
                } else {
                    Log.d("SilentUpdateManager", "上次检查更新距现在超过5小时，状态失效。 当前时间戳：" + currentTimeMillis + "， 上次检查时间戳： " + this.biD.get(str) + " ，id = " + str);
                }
            }
            return false;
        }
        if (DEBUG) {
            Log.d("SilentUpdateManager", "id = " + str + " 的小程序已在5小时内被标记为无需更新，不走MaxAge逻辑");
        }
        return true;
    }

    public boolean KP() {
        return this.biz;
    }
}
