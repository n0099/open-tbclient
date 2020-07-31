package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.al;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public class e {
    public static String aAF() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String bf = com.baidu.swan.apps.t.a.aho().bf(com.baidu.swan.apps.t.a.ahj());
        if (TextUtils.isEmpty(bf)) {
            bf = al.axd();
        }
        return "38" + substring + bf.substring(0, 4);
    }

    public static String aAG() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
