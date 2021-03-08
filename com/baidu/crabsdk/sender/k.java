package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.crabsdk.OnUploadFilesCallback;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k {
    private static SharedPreferences asi = null;
    private static final ScheduledThreadPoolExecutor asj = new ScheduledThreadPoolExecutor(1);
    private static final ScheduledThreadPoolExecutor ask = new ScheduledThreadPoolExecutor(1);

    private static long B(Context context, String str) {
        try {
            if (asi == null && context != null) {
                asi = context.getSharedPreferences("last_init_crab", 4);
            }
            if (asi != null) {
                return asi.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void a(Context context, Throwable th) {
        asj.execute(new m(th, context));
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (k.class) {
            p pVar = new p(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis() - B(context, "time_upload_crash");
                com.baidu.crabsdk.c.a.v("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
                if (currentTimeMillis < 10000) {
                    asj.schedule(pVar, 10L, TimeUnit.SECONDS);
                } else {
                    asj.execute(pVar);
                }
                e(context, "time_upload_crash");
            } else {
                asj.execute(pVar);
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        com.baidu.crabsdk.c.a.dw("HttpSender.uploadBlock.result: " + j.c(bArr, "Block", str));
    }

    private static synchronized void af(Context context) {
        String str;
        synchronized (k.class) {
            List<String> i = i.i(context);
            if (i.size() != 0) {
                for (String str2 : i) {
                    com.baidu.crabsdk.c.a.v("(--#)  fileName when send  (--#)" + dO(str2));
                    if (h.i(str2)) {
                        byte[] dY = i.dY(str2);
                        com.baidu.crabsdk.c.a.dw("HttpSender.sendRecord: " + str2);
                        if (str2.contains("crab_crash_")) {
                            String dO = dO(str2);
                            String a2 = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.dw("sendCrashRecord postUrl:" + a2);
                            String a3 = r.a(a2, dY, "Crash", dO);
                            com.baidu.crabsdk.c.a.dw("HttpSender.sendCrashRecord--->Crash");
                            str = a3;
                        } else if (str2.contains("crab_anr_")) {
                            String dO2 = dO(str2);
                            String b = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.dw("sendAnrRecord postUrl:" + b);
                            String a4 = r.a(b, dY, "Anr", dO2);
                            com.baidu.crabsdk.c.a.dw("HttpSender.sendAnrRecord--->Anr");
                            str = a4;
                        } else if (str2.contains("crab_catched_")) {
                            String dO3 = dO(str2);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.dw("sendExceptionRecord postUrl:" + b2);
                            String a5 = r.a(b2, dY, "Exception", dO3);
                            com.baidu.crabsdk.c.a.dw("HttpSender.sendExceptionRecord--->Exception");
                            str = a5;
                        } else if (str2.contains("crab_block_")) {
                            String c = j.c(dY, "Block", dO(str2));
                            com.baidu.crabsdk.c.a.dw("HttpSender.sendExceptionRecord--->Block");
                            str = c;
                        } else {
                            str = null;
                        }
                        com.baidu.crabsdk.c.a.dw("HttpSender.doUpload.result: " + str);
                        if (TextUtils.isEmpty(str)) {
                            h.j(str2);
                            com.baidu.crabsdk.c.a.dx("result is empty!");
                        } else if (str == null || !str.equals("N/A")) {
                            int i2 = -100;
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has(BaseJsonData.TAG_ERRNO)) {
                                    i2 = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                                } else if (jSONObject.has("errNo")) {
                                    i2 = ((Integer) jSONObject.get("errNo")).intValue();
                                }
                                com.baidu.crabsdk.c.a.dw("###--> errno = " + i2);
                                switch (i2) {
                                    case -1:
                                        h.j(str2);
                                        h.aa();
                                        break;
                                    case 0:
                                        i.deleteFile(str2);
                                        h.o(dO(str2));
                                        h.q("key_" + dO(str2));
                                        h.k(str2);
                                        h.aa();
                                        break;
                                    case 1:
                                        try {
                                            int intValue = ((Integer) jSONObject.get("days")).intValue();
                                            if (intValue <= 0) {
                                                intValue = 1;
                                            }
                                            h.a(intValue);
                                            i.deleteFile(str2);
                                            h.o(dO(str2));
                                            h.q("key_" + dO(str2));
                                            break;
                                        } catch (Exception e) {
                                            com.baidu.crabsdk.c.a.w("handle crash result days json error, exception is " + e);
                                            h.a(1);
                                            i.deleteFile(str2);
                                            h.o(dO(str2));
                                            h.q("key_" + dO(str2));
                                            e.printStackTrace();
                                            break;
                                        }
                                    case 10:
                                    case 15:
                                        i.deleteFile(str2);
                                        h.o(dO(str2));
                                        h.q("key_" + dO(str2));
                                        h.k(str2);
                                        h.aa();
                                        break;
                                    default:
                                        i.deleteFile(str2);
                                        h.o(dO(str2));
                                        h.q("key_" + dO(str2));
                                        h.k(str2);
                                        break;
                                }
                            } catch (Exception e2) {
                                h.j(str2);
                                com.baidu.crabsdk.c.a.w("handle crash result json error, exception is " + e2);
                                e2.printStackTrace();
                            }
                        } else {
                            com.baidu.crabsdk.c.a.dx("not connected to server!");
                        }
                        f.asd = true;
                    } else {
                        i.deleteFile(str2);
                        h.k(str2);
                    }
                }
            }
        }
    }

    public static Future b(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3, String str4) {
        return ask.submit(new o(onUploadFilesCallback, str, str2, str3, str4));
    }

    public static void b(Context context, Throwable th) {
        asj.execute(new n(context, th));
    }

    private static String dO(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private static void e(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (asi == null && context != null) {
                asi = context.getSharedPreferences("last_init_crab", 4);
            }
            if (asi != null) {
                asi.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.c.a.v("setLastInitTime cost time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static void j(Context context) {
        l lVar = new l(context);
        long currentTimeMillis = System.currentTimeMillis() - B(context, "time_upload_native");
        com.baidu.crabsdk.c.a.v("uploadNativeCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
        if (currentTimeMillis < 10000) {
            asj.schedule(lVar, 10L, TimeUnit.SECONDS);
        } else {
            asj.execute(lVar);
        }
        e(context, "time_upload_native");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context) {
        synchronized (k.class) {
            if (i.d(context, "dmp", true).size() == 0) {
                com.baidu.crabsdk.c.a.dx("No Native Crash files!!");
            } else {
                String I = com.baidu.crabsdk.b.o.I();
                if ("NONE".equals(I) || RomUtils.UNKNOWN.equals(I)) {
                    com.baidu.crabsdk.c.a.v("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.v("upload native immediately!");
                    l(context);
                } else if ("WIFI".equals(I)) {
                    l(context);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:26|(1:28)(1:163)|29|30|(2:158|159)|32|(7:36|37|38|39|40|41|(3:46|47|48)(15:49|50|51|(3:53|(1:57)|58)(2:147|148)|59|(2:61|(1:67))|68|(2:70|(1:76))|(1:78)|(1:80)|(1:82)|(1:84)|85|(2:144|145)(11:89|90|92|93|94|95|96|97|99|100|(3:130|131|132)(2:102|(7:107|108|109|111|(1:113)(2:120|(1:122))|114|115)(3:126|127|128)))|48))|157|40|41|(2:43|45)(1:149)|46|47|48|24) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010f, code lost:
        com.baidu.crabsdk.c.a.a("Create uploadDumpData error!", r0);
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void l(Context context) {
        String str;
        String str2;
        long j;
        byte[] dY;
        String str3;
        String dC;
        String dC2;
        synchronized (k.class) {
            List<String> A = i.A(context, "pid_");
            if (A.size() > 0) {
                for (String str4 : A) {
                    if (str4.endsWith(".ydg")) {
                        com.baidu.crabsdk.c.a.dw("Deleting " + str4 + " " + i.deleteFile(str4));
                    }
                }
            } else {
                com.baidu.crabsdk.c.a.dw("There is no .ydg files.");
            }
            List<String> d = i.d(context, ".dmp", true);
            if (d.size() == 0) {
                com.baidu.crabsdk.c.a.w("Native file is empty!");
            } else {
                List<String> d2 = i.d(context, ".crab", false);
                List<String> d3 = i.d(context, ".logcat", false);
                List<String> d4 = i.d(context, ".ldg", false);
                for (String str5 : d) {
                    com.baidu.crabsdk.c.a.dw("Absolute native file path@lastModifiedTime: " + str5);
                    if (str5.contains("@")) {
                        String[] split = str5.split("@");
                        String str6 = split[0];
                        str = split[1];
                        str2 = str6;
                    } else {
                        str = null;
                        str2 = str5;
                    }
                    String dO = dO(str2);
                    com.baidu.crabsdk.c.a.dw("Native fileNameOnly: " + dO);
                    long j2 = 0;
                    if (str != null) {
                        try {
                            j2 = Long.parseLong(str);
                        } catch (Exception e) {
                            j2 = 0;
                            com.baidu.crabsdk.c.a.a("Java:lastModifiedTime parse error!", e);
                        }
                    }
                    if (j2 == 0 && dO.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                        try {
                            j = Long.parseLong(dO.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[1]);
                        } catch (Exception e2) {
                            j2 = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.a("C:dump time parse error!", e2);
                        }
                        dY = i.dY(str2);
                        if (dY != null || dY.length == 0) {
                            com.baidu.crabsdk.c.a.w("Read dump file error!");
                        } else {
                            String encodeToString = Base64.encodeToString(dY, 0);
                            String str7 = null;
                            if (d3.contains(str2 + ".logcat")) {
                                com.baidu.crabsdk.c.a.v("Found .logcat files relative with dump files.");
                                byte[] dY2 = i.dY(str2 + ".logcat");
                                if (dY2 != null && dY2.length > 0) {
                                    str7 = new String(dY2);
                                }
                                str3 = str7;
                            } else {
                                com.baidu.crabsdk.c.a.v("Not found .logcat files.");
                                str3 = null;
                            }
                            JSONObject jSONObject = null;
                            JSONObject jSONObject2 = null;
                            if (d4.contains(str2 + ".ldg")) {
                                com.baidu.crabsdk.c.a.v("Found .ldg files relative with dump files.");
                                byte[] dY3 = i.dY(str2 + ".ldg");
                                if (dY3 != null && dY3.length > 0 && (dC2 = com.baidu.crabsdk.c.d.dC(new String(dY3))) != null) {
                                    jSONObject2 = new JSONObject(dC2);
                                }
                            }
                            if (d2.contains(str2 + ".crab")) {
                                com.baidu.crabsdk.c.a.v("Found .crab files relative with dump files.");
                                byte[] dY4 = i.dY(str2 + ".crab");
                                if (dY4 != null && dY4.length > 0 && (dC = com.baidu.crabsdk.c.d.dC(new String(dY4))) != null) {
                                    jSONObject = new JSONObject(dC);
                                    jSONObject.put("phoneTime", j);
                                }
                            }
                            if (jSONObject == null) {
                                jSONObject = g.ae(context);
                                com.baidu.crabsdk.c.c.a(jSONObject, g.c(j, false));
                            }
                            if (encodeToString != null) {
                                jSONObject.put("dump", encodeToString);
                            }
                            if (str3 != null) {
                                jSONObject.put("logcat", str3);
                            }
                            if (jSONObject2 != null) {
                                com.baidu.crabsdk.c.c.a(jSONObject, jSONObject2);
                            }
                            String str8 = jSONObject.toString();
                            if (str8 == null || str8.length() == 0) {
                                com.baidu.crabsdk.c.a.w("Error, uploadDumpData is invalid!");
                            } else {
                                try {
                                    byte[] dz = com.baidu.crabsdk.c.c.dz(str8);
                                    String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                                    try {
                                        byte[] b = com.baidu.crabsdk.c.d.b(dz, c);
                                        try {
                                            String dD = com.baidu.crabsdk.c.e.dD(c);
                                            String d5 = com.baidu.crabsdk.a.d();
                                            com.baidu.crabsdk.c.a.dw("sendNativeRecord postUrl:" + d5);
                                            String a2 = r.a(d5, b, "NDK", dD);
                                            if (TextUtils.isEmpty(a2)) {
                                                com.baidu.crabsdk.c.a.dx("result is empty!");
                                            } else if (a2 == null || !a2.equals("N/A")) {
                                                int i = -100;
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject(a2);
                                                    if (jSONObject3.has(BaseJsonData.TAG_ERRNO)) {
                                                        i = ((Integer) jSONObject3.get(BaseJsonData.TAG_ERRNO)).intValue();
                                                    } else if (jSONObject3.has("errNo")) {
                                                        i = ((Integer) jSONObject3.get("errNo")).intValue();
                                                    }
                                                    com.baidu.crabsdk.c.a.dw("###--> native errno = " + i);
                                                    switch (i) {
                                                        case -1:
                                                            break;
                                                        default:
                                                            i.deleteFile(str2);
                                                            i.deleteFile(str2 + ".crab");
                                                            i.deleteFile(str2 + ".logcat");
                                                            i.deleteFile(str2 + ".ldg");
                                                            continue;
                                                    }
                                                } catch (Exception e3) {
                                                    com.baidu.crabsdk.c.a.w("handle crash result json error, exception is " + e3);
                                                }
                                            } else {
                                                com.baidu.crabsdk.c.a.dx("not connected to server!");
                                            }
                                        } catch (Exception e4) {
                                            com.baidu.crabsdk.c.a.a("RSAUtils.encryptIntoBase64 Error!!", e4);
                                        }
                                    } catch (Exception e5) {
                                        com.baidu.crabsdk.c.a.a("UploadLog Encrypt Error!!", e5);
                                    }
                                } catch (Exception e6) {
                                    com.baidu.crabsdk.c.a.a("UploadLog Compress Error!", e6);
                                }
                            }
                        }
                    }
                    j = j2;
                    dY = i.dY(str2);
                    if (dY != null) {
                    }
                    com.baidu.crabsdk.c.a.w("Read dump file error!");
                }
            }
        }
    }

    public static void m(Context context) {
        asj.execute(new q(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void n(Context context) {
        synchronized (k.class) {
            if (i.i(context).size() != 0) {
                String I = com.baidu.crabsdk.b.o.I();
                if ("NONE".equals(I) || RomUtils.UNKNOWN.equals(I)) {
                    com.baidu.crabsdk.c.a.v("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.v("upload immediately!");
                    h.a(0L);
                    af(context);
                } else if ("WIFI".equals(I)) {
                    h.a(0L);
                    af(context);
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.v("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                } else if ("MOBILE".equals(I) && h.ab()) {
                    com.baidu.crabsdk.c.a.v("upload without wifi!");
                    h.a(0L);
                    af(context);
                } else {
                    com.baidu.crabsdk.c.a.v("network is not wifi!");
                }
            }
        }
    }
}
