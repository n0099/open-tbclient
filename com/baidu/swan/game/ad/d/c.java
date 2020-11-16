package com.baidu.swan.game.ad.d;

import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class c {
    public static String getRequestAdUrl(String str, HashMap<String, String> hashMap) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (hashMap != null) {
            int i = 0;
            for (String str2 : hashMap.keySet()) {
                int i2 = i + 1;
                String str3 = hashMap.get(str2);
                if (i2 == 1) {
                    sb2.append(str2).append(ETAG.EQUAL).append(str3);
                } else {
                    sb2.append(ETAG.ITEM_SEPARATOR).append(str2).append(ETAG.EQUAL).append(str3);
                }
                i = i2;
            }
        }
        String str4 = str + "?code2=" + new a().encode(sb2.toString() + "&b" + System.currentTimeMillis() + "=1");
        new StringBuilder().append("&b" + System.currentTimeMillis()).append(ETAG.EQUAL).append("1");
        return str4 + sb.toString();
    }
}
