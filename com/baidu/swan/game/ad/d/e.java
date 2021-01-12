package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes14.dex */
public class e {
    public static String aSa() {
        String substring = new a().encode(String.valueOf(System.currentTimeMillis())).substring(4, 14);
        String cc = com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy());
        if (TextUtils.isEmpty(cc)) {
            cc = ak.aNV();
        }
        return "38" + substring + cc.substring(0, 4);
    }

    public static String aSb() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
