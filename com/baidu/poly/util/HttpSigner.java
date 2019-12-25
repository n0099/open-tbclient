package com.baidu.poly.util;

import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes9.dex */
public class HttpSigner {
    static {
        System.loadLibrary("hs");
    }

    public static void a(com.baidu.poly.a.a.b bVar, int i) {
        if (!bVar.getMap().containsKey("nop_appid")) {
            bVar.f("nop_appid", nativeGetAppId(i));
        }
        Map<String, String> map = bVar.getMap();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            String str2 = map.get(str);
            if (str2 != null) {
                sb.append(str).append(ETAG.EQUAL).append(str2);
            }
        }
        bVar.f("nop_sign", nativeSignNop(sb.toString(), i));
    }

    private static native String nativeGetAppId(int i);

    private static native String nativeSignNop(String str, int i);
}
