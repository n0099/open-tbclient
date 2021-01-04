package com.baidu.android.pushservice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class b {
    @SuppressLint({"InlinedApi"})
    public static void a(Context context, HashMap<String, String> hashMap) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("timestamp", currentTimeMillis + "");
        hashMap.put("expires", (86400 + currentTimeMillis) + "");
        hashMap.put("v", "1");
        try {
            hashMap.put("vcode", com.baidu.android.pushservice.i.f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
        } catch (UnsupportedEncodingException e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
    }
}
