package com.baidu.poly.util;

import android.text.TextUtils;
import d.b.c0.k.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpSigner {
    static {
        System.loadLibrary("hs");
    }

    public static String a(b bVar, String str, int i) {
        if (bVar == null) {
            return "";
        }
        Map<String, String> c2 = bVar.c();
        ArrayList<String> arrayList = new ArrayList(c2.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            String str3 = c2.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
                sb.append("&");
            }
        }
        sb.append(str);
        sb.append("=");
        sb.append(nativeGetStatisticsKey(i));
        return d.b.c0.k.g.b.c(sb.toString());
    }

    public static void b(b bVar) {
        if (bVar == null) {
            return;
        }
        Map<String, String> c2 = bVar.c();
        if (c2.containsKey("timestamp")) {
            c2.remove("timestamp");
        }
        if (c2.containsKey("sign")) {
            c2.remove("sign");
        }
        ArrayList<String> arrayList = new ArrayList(c2.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            String str2 = c2.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                sb.append("&");
            }
        }
        bVar.e("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        sb.append(nativeGetCommissionSk());
        sb.append("&");
        sb.append(bVar.b("timestamp"));
        bVar.e("sign", d.b.c0.k.g.b.c(sb.toString()));
    }

    public static native String nativeGetCommissionSk();

    public static native String nativeGetStatisticsKey(int i);
}
