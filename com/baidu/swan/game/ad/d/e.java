package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class e {
    public static String aVT() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String cd = com.baidu.swan.apps.t.a.aAw().cd(com.baidu.swan.apps.t.a.aAr());
        if (TextUtils.isEmpty(cd)) {
            cd = ak.aRO();
        }
        return "38" + substring + cd.substring(0, 4);
    }

    public static String aVU() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
