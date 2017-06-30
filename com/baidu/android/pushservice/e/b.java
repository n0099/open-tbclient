package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public final class b {
    public static String a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "params is null or empty";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return stringBuffer.toString();
            }
            if (i2 != 0) {
                stringBuffer.append(", ");
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            stringBuffer.append((Object) key).append("=").append((Object) next.getValue());
            i = i2 + 1;
        }
    }

    public static void a(Context context) {
        a(context, (ArrayList) com.baidu.android.pushservice.b.b.a(context).a.clone());
    }

    private static void a(Context context, ArrayList<com.baidu.android.pushservice.b.f> arrayList) {
        if (arrayList == null) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        synchronized (arrayList) {
            Iterator<com.baidu.android.pushservice.b.f> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.android.pushservice.b.f next = it.next();
                if (next != null) {
                    String c = next.c();
                    try {
                        packageManager.getPackageInfo(c, 0);
                    } catch (Exception e) {
                        if (!TextUtils.isEmpty(c)) {
                            com.baidu.android.pushservice.g.a.d("ApiUtils", c + " not found at packageManager");
                        }
                    }
                }
            }
        }
    }

    public static void b(HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("timestamp", currentTimeMillis + "");
        hashMap.put("expires", (86400 + currentTimeMillis) + "");
        hashMap.put("v", "1");
        try {
            hashMap.put("vcode", com.baidu.android.pushservice.k.f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
        } catch (UnsupportedEncodingException e) {
            com.baidu.android.pushservice.g.a.a("ApiUtils", e);
        }
    }
}
