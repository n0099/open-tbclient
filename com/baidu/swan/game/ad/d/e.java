package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes14.dex */
public class e {
    public static String aRc() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String bq = com.baidu.swan.apps.t.a.awF().bq(com.baidu.swan.apps.t.a.awA());
        if (TextUtils.isEmpty(bq)) {
            bq = ak.aMZ();
        }
        return "38" + substring + bq.substring(0, 4);
    }

    public static String aRd() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
