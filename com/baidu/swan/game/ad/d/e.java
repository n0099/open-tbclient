package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes10.dex */
public class e {
    public static String aJZ() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String bk = com.baidu.swan.apps.t.a.apz().bk(com.baidu.swan.apps.t.a.apu());
        if (TextUtils.isEmpty(bk)) {
            bk = ak.aFW();
        }
        return "38" + substring + bk.substring(0, 4);
    }

    public static String aKa() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
