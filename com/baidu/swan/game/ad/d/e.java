package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes14.dex */
public class e {
    public static String aOC() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String bq = com.baidu.swan.apps.t.a.auf().bq(com.baidu.swan.apps.t.a.aua());
        if (TextUtils.isEmpty(bq)) {
            bq = ak.aKz();
        }
        return "38" + substring + bq.substring(0, 4);
    }

    public static String aOD() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
