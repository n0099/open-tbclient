package com.baidu.poly.util;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes14.dex */
public class HttpSigner {
    static {
        System.loadLibrary("hs");
    }

    private static native String nativeGetCommissionSk();

    private static native String nativeGetStatisticsKey(int i);

    public static void a(com.baidu.poly.a.a.b bVar) {
        if (bVar != null) {
            Map<String, String> map = bVar.getMap();
            if (map.containsKey("timestamp")) {
                map.remove("timestamp");
            }
            if (map.containsKey("sign")) {
                map.remove("sign");
            }
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str).append("=").append(str2).append(ETAG.ITEM_SEPARATOR);
                }
            }
            bVar.g("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            sb.append(nativeGetCommissionSk()).append(ETAG.ITEM_SEPARATOR).append(bVar.get("timestamp"));
            bVar.g("sign", com.baidu.poly.a.g.b.h(sb.toString()));
        }
    }

    public static String a(com.baidu.poly.a.a.b bVar, String str, int i) {
        if (bVar == null) {
            return "";
        }
        Map<String, String> map = bVar.getMap();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            String str3 = map.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str2).append("=").append(str3).append(ETAG.ITEM_SEPARATOR);
            }
        }
        sb.append(str).append("=").append(nativeGetStatisticsKey(i));
        return com.baidu.poly.a.g.b.h(sb.toString());
    }
}
