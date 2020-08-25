package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes19.dex */
public class e {
    public static String aJo() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String bl = com.baidu.swan.apps.t.a.aoO().bl(com.baidu.swan.apps.t.a.aoJ());
        if (TextUtils.isEmpty(bl)) {
            bl = ak.aFm();
        }
        return "38" + substring + bl.substring(0, 4);
    }

    public static String aJp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
