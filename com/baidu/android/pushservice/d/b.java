package com.baidu.android.pushservice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class b {
    public static void a(Context context) {
        a(context, (ArrayList) com.baidu.android.pushservice.a.b.a(context).a.clone());
    }

    private static void a(Context context, ArrayList<com.baidu.android.pushservice.a.f> arrayList) {
        if (arrayList == null) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        synchronized (arrayList) {
            Iterator<com.baidu.android.pushservice.a.f> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.android.pushservice.a.f next = it.next();
                if (next != null) {
                    String c = next.c();
                    try {
                        packageManager.getPackageInfo(c, 0);
                    } catch (Exception e) {
                        if (!TextUtils.isEmpty(c)) {
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public static void a(HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("timestamp", currentTimeMillis + "");
        hashMap.put("expires", (86400 + currentTimeMillis) + "");
        hashMap.put("v", "1");
        try {
            hashMap.put("vcode", com.baidu.android.pushservice.j.d.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
        } catch (UnsupportedEncodingException e) {
        }
    }
}
