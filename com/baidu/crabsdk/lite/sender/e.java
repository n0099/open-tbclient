package com.baidu.crabsdk.lite.sender;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.lite.a.m;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f4701a = new ScheduledThreadPoolExecutor(1);

    public static String a(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static void b(String str) {
        f4701a.execute(new d.a.m.a.b.b(str));
    }

    public static void c(String str, Context context) {
        f4701a.execute(new d.a.m.a.b.a(str, context));
    }

    public static synchronized void d(String str, Context context) {
        Object obj;
        Object obj2;
        synchronized (e.class) {
            if (d.g(str, context).size() == 0) {
                return;
            }
            String b2 = m.b();
            if (!"NONE".equals(b2) && !RomUtils.UNKNOWN.equals(b2)) {
                HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4658a.get(str);
                boolean z = false;
                if ((hashMap == null || (obj2 = hashMap.get("sdk_upload_immediate")) == null) ? false : ((Boolean) obj2).booleanValue()) {
                    com.baidu.crabsdk.lite.b.a.c(str, "upload java immediately!");
                    e(str, context);
                    return;
                } else if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(b2)) {
                    c.e(str, 0L);
                    e(str, context);
                    return;
                } else {
                    HashMap<String, Object> hashMap2 = com.baidu.crabsdk.lite.a.f4658a.get(str);
                    if (hashMap2 != null && (obj = hashMap2.get("sdk_wifi")) != null) {
                        z = ((Boolean) obj).booleanValue();
                    }
                    if (z) {
                        com.baidu.crabsdk.lite.b.a.c(str, "network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                        return;
                    } else if (!"MOBILE".equals(b2) || !c.a(str)) {
                        com.baidu.crabsdk.lite.b.a.c(str, "network is not wifi!");
                        return;
                    } else {
                        com.baidu.crabsdk.lite.b.a.c(str, "upload without wifi!");
                        c.e(str, 0L);
                        e(str, context);
                        return;
                    }
                }
            }
            com.baidu.crabsdk.lite.b.a.c(str, "network is not available!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7 A[Catch: all -> 0x0213, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:7:0x0011, B:9:0x0017, B:11:0x0038, B:12:0x003f, B:14:0x005d, B:15:0x007f, B:20:0x00af, B:22:0x00c7, B:23:0x00cc, B:56:0x020d, B:25:0x00d3, B:29:0x00de, B:30:0x00e3, B:35:0x00fe, B:41:0x011a, B:42:0x013e, B:43:0x0160, B:45:0x0165, B:48:0x0174, B:51:0x0198, B:52:0x01cf, B:53:0x01f3, B:33:0x00f1, B:55:0x01f9, B:16:0x0083, B:18:0x008b), top: B:66:0x0003, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01f3 A[Catch: all -> 0x0213, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000d, B:7:0x0011, B:9:0x0017, B:11:0x0038, B:12:0x003f, B:14:0x005d, B:15:0x007f, B:20:0x00af, B:22:0x00c7, B:23:0x00cc, B:56:0x020d, B:25:0x00d3, B:29:0x00de, B:30:0x00e3, B:35:0x00fe, B:41:0x011a, B:42:0x013e, B:43:0x0160, B:45:0x0165, B:48:0x0174, B:51:0x0198, B:52:0x01cf, B:53:0x01f3, B:33:0x00f1, B:55:0x01f9, B:16:0x0083, B:18:0x008b), top: B:66:0x0003, inners: #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void e(String str, Context context) {
        String str2;
        String str3;
        int intValue;
        JSONObject jSONObject;
        String str4;
        synchronized (e.class) {
            List<String> g2 = d.g(str, context);
            if (g2.size() != 0) {
                for (String str5 : g2) {
                    com.baidu.crabsdk.lite.b.a.c(str, "(--#)  fileName when send  (--#)" + a(str5));
                    if (c.r(str5)) {
                        byte[] a2 = d.a(str5);
                        com.baidu.crabsdk.lite.b.a.f(str, "HttpSender.sendRecord: " + str5);
                        JSONObject jSONObject2 = null;
                        if (str5.contains("lite_crash_")) {
                            String a3 = a(str5);
                            String a4 = com.baidu.crabsdk.lite.a.a(str);
                            com.baidu.crabsdk.lite.b.a.f(str, "sendCrashRecord postUrl:" + a4);
                            str2 = i.a(str, a4, a2, "Crash", a3);
                            str3 = "HttpSender.sendCrashRecord--->Crash";
                        } else if (str5.contains("lite_catched_")) {
                            String a5 = a(str5);
                            String b2 = com.baidu.crabsdk.lite.a.b(str);
                            com.baidu.crabsdk.lite.b.a.f(str, "sendSdkRecord postUrl:" + b2);
                            str2 = i.a(str, b2, a2, "Exception", a5);
                            str3 = "HttpSender.sendExceptionRecord--->Exception";
                        } else {
                            str2 = null;
                            com.baidu.crabsdk.lite.b.a.f(str, "HttpSender.doUpload.result: " + str2);
                            if (!TextUtils.isEmpty(str2)) {
                                c.s(str5);
                                str4 = "result is empty!";
                            } else if (str2 == null || !str2.equals("500")) {
                                try {
                                    jSONObject = new JSONObject(str2);
                                    try {
                                        intValue = ((Integer) jSONObject.get("errno")).intValue();
                                    } catch (Exception unused) {
                                        jSONObject2 = jSONObject;
                                        try {
                                            intValue = ((Integer) jSONObject2.get("errNo")).intValue();
                                            jSONObject = jSONObject2;
                                            com.baidu.crabsdk.lite.b.a.f(str, "###--> errno = " + intValue);
                                            if (intValue != -1) {
                                            }
                                            c.q(str);
                                        } catch (Exception e2) {
                                            c.s(str5);
                                            com.baidu.crabsdk.lite.b.a.d(str, "handle crash result json error, exception is " + e2);
                                        }
                                        a.f4694g = true;
                                    }
                                } catch (Exception unused2) {
                                }
                                com.baidu.crabsdk.lite.b.a.f(str, "###--> errno = " + intValue);
                                if (intValue != -1) {
                                    c.s(str5);
                                } else if (intValue != 0) {
                                    if (intValue == 1) {
                                        try {
                                            int intValue2 = ((Integer) jSONObject.get("days")).intValue();
                                            if (intValue2 <= 0) {
                                                intValue2 = 1;
                                            }
                                            c.d(str, intValue2);
                                            d.f(str5);
                                            c.m(str, a(str5));
                                            c.o(str, "key_" + a(str5));
                                        } catch (Exception e3) {
                                            com.baidu.crabsdk.lite.b.a.d(str, "handle crash result days json error, exception is " + e3);
                                            c.d(str, 1);
                                            d.f(str5);
                                            c.m(str, a(str5));
                                            c.o(str, "key_" + a(str5));
                                            e3.printStackTrace();
                                        }
                                    } else if (intValue != 10) {
                                        d.f(str5);
                                        c.m(str, a(str5));
                                        c.o(str, "key_" + a(str5));
                                        c.t(str5);
                                    } else {
                                        d.f(str5);
                                        c.m(str, a(str5));
                                        c.o(str, "key_" + a(str5));
                                        c.t(str5);
                                    }
                                    a.f4694g = true;
                                } else {
                                    d.f(str5);
                                    c.m(str, a(str5));
                                    c.o(str, "key_" + a(str5));
                                    c.t(str5);
                                }
                                c.q(str);
                                a.f4694g = true;
                            } else {
                                str4 = "not connected to server!";
                            }
                            com.baidu.crabsdk.lite.b.a.g(str, str4);
                            a.f4694g = true;
                        }
                        com.baidu.crabsdk.lite.b.a.f(str, str3);
                        com.baidu.crabsdk.lite.b.a.f(str, "HttpSender.doUpload.result: " + str2);
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        com.baidu.crabsdk.lite.b.a.g(str, str4);
                        a.f4694g = true;
                    } else {
                        d.f(str5);
                        c.t(str5);
                    }
                }
            }
        }
    }
}
