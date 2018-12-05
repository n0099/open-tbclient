package com.baidu.poly.util;

import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpSigner {
    private static native String nativeGetAppId(int i);

    private static native String nativeSignNop(String str, int i);

    static {
        System.loadLibrary("hs");
    }

    public static void a(Map<String, String> map, int i) {
        if (!map.containsKey("nop_appid")) {
            map.put("nop_appid", nativeGetAppId(i));
        }
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            String str2 = map.get(str);
            if (str2 != null) {
                sb.append(str).append(ETAG.EQUAL).append(str2);
            }
        }
        map.put("nop_sign", nativeSignNop(sb.toString(), i));
    }
}
