package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes14.dex */
public class e {
    public static String aTz() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String bW = com.baidu.swan.apps.t.a.azf().bW(com.baidu.swan.apps.t.a.aza());
        if (TextUtils.isEmpty(bW)) {
            bW = ak.aPx();
        }
        return "38" + substring + bW.substring(0, 4);
    }

    public static String aTA() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
