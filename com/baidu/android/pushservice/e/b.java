package com.baidu.android.pushservice.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b {
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
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public static void a(HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put(HttpConstants.TIMESTAMP, currentTimeMillis + "");
        hashMap.put("expires", (86400 + currentTimeMillis) + "");
        hashMap.put(NotifyType.VIBRATE, "1");
        try {
            hashMap.put("vcode", com.baidu.android.pushservice.k.f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
        } catch (UnsupportedEncodingException e) {
        }
    }
}
