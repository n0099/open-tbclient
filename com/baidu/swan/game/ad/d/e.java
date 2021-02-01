package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class e {
    public static String aSm() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String cb = com.baidu.swan.apps.t.a.axb().cb(com.baidu.swan.apps.t.a.awW());
        if (TextUtils.isEmpty(cb)) {
            cb = ak.aOo();
        }
        return "38" + substring + cb.substring(0, 4);
    }

    public static String aSn() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
