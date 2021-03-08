package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class e {
    public static String aSp() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String ca = com.baidu.swan.apps.t.a.axe().ca(com.baidu.swan.apps.t.a.awZ());
        if (TextUtils.isEmpty(ca)) {
            ca = ak.aOr();
        }
        return "38" + substring + ca.substring(0, 4);
    }

    public static String aSq() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
