package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.b.p;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public final class h {
    private static SharedPreferences acv = null;
    private static ScheduledThreadPoolExecutor acx = new ScheduledThreadPoolExecutor(1);

    private static long X(Context context, String str) {
        try {
            if (acv == null && context != null) {
                acv = context.getSharedPreferences("last_init_crab", 4);
            }
            if (acv != null) {
                return acv.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void a(Context context, Throwable th) {
        acx.execute(new j(th, context));
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (h.class) {
            l lVar = new l(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis() - X(context, "time_upload_crash");
                com.baidu.crabsdk.c.a.cx("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
                if (currentTimeMillis < 10000) {
                    acx.schedule(lVar, 10L, TimeUnit.SECONDS);
                } else {
                    acx.execute(lVar);
                }
                e(context, "time_upload_crash");
            } else {
                acx.execute(lVar);
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        com.baidu.crabsdk.c.a.cv("HttpSender.uploadBlock.result: " + g.b(bArr, "Block", str));
    }

    public static void d(Context context, Throwable th) {
        acx.execute(new k(context, th));
    }

    private static void e(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (acv == null && context != null) {
                acv = context.getSharedPreferences("last_init_crab", 4);
            }
            if (acv != null) {
                acv.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.c.a.cx("setLastInitTime cost time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static void k(Context context) {
        i iVar = new i(context);
        long currentTimeMillis = System.currentTimeMillis() - X(context, "time_upload_native");
        com.baidu.crabsdk.c.a.cx("uploadNativeCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
        if (currentTimeMillis < 10000) {
            acx.schedule(iVar, 10L, TimeUnit.SECONDS);
        } else {
            acx.execute(iVar);
        }
        e(context, "time_upload_native");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context) {
        synchronized (h.class) {
            if (f.bd(context).size() == 0) {
                com.baidu.crabsdk.c.a.v("No Native Crash files!!");
            } else {
                String F = com.baidu.crabsdk.b.n.F();
                if ("NONE".equals(F) || "UNKNOWN".equals(F)) {
                    com.baidu.crabsdk.c.a.cx("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.cx("upload native immediately!");
                    m(context);
                } else if ("WIFI".equals(F)) {
                    m(context);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:13|(1:15)(1:169)|16|(2:21|22)|27|(8:31|32|33|34|35|36|(2:41|42)(9:44|45|46|(3:48|(1:52)|53)(1:155)|54|(3:56|(1:60)|(5:62|63|(1:65)(1:151)|66|(1:68)(1:150))(1:152))(2:153|154)|(1:70)|71|(2:76|77)(11:78|(4:80|81|83|(9:144|86|87|88|90|91|93|94|(3:135|136|137)(2:96|(8:101|102|103|105|106|108|109|110)(3:131|132|133))))(1:148)|85|86|87|88|90|91|93|94|(0)(0)))|43)|168|35|36|(2:38|40)(1:156)|41|42|43|11) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
        com.baidu.crabsdk.c.a.f("JSONObject->生成native信息错误", r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02a5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02a7, code lost:
        com.baidu.crabsdk.c.a.f("JSONObject->生成native信息错误", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02ad, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0377 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0326 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0412 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void m(Context context) {
        String str;
        String str2;
        long j;
        byte[] bArr;
        String a;
        Exception exc;
        JSONObject jSONObject;
        int intValue;
        JSONObject jSONObject2;
        byte[] cH;
        String str3;
        JSONObject f;
        synchronized (h.class) {
            List<String> bd = f.bd(context);
            if (bd.size() == 0) {
                com.baidu.crabsdk.c.a.cy("获取 native crash file 错误！！");
            } else {
                List<String> W = f.W(context, ".crab");
                List<String> W2 = f.W(context, ".logcat");
                for (String str4 : bd) {
                    com.baidu.crabsdk.c.a.cv("absolute native file path@lastModifiedTime: " + str4);
                    if (str4.contains("@")) {
                        String[] split = str4.split("@");
                        String str5 = split[0];
                        str = split[1];
                        str2 = str5;
                    } else {
                        str = null;
                        str2 = str4;
                    }
                    String p = p(str2);
                    com.baidu.crabsdk.c.a.cv("native fileNameOnly: " + p);
                    long j2 = 0;
                    if (str != null && str.length() > 1) {
                        try {
                            j2 = Long.parseLong(str);
                        } catch (Exception e) {
                            j2 = 0;
                            com.baidu.crabsdk.c.a.f("Java:文件名转时间异常!!", e);
                        }
                    }
                    if (j2 == 0 && p.contains("_")) {
                        try {
                            j = Long.parseLong(p.split("_")[1]);
                        } catch (Exception e2) {
                            j2 = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.f("文件名转时间异常!!", e2);
                        }
                        cH = f.cH(str2);
                        if (cH != null || cH.length == 0) {
                            com.baidu.crabsdk.c.a.cy("read dump file error!");
                        } else {
                            String encodeToString = Base64.encodeToString(cH, 0);
                            String str6 = null;
                            if (W2.contains(str2 + ".logcat")) {
                                com.baidu.crabsdk.c.a.cx("存在dump对应的.logcat文件！");
                                byte[] cH2 = f.cH(str2 + ".logcat");
                                if (cH2 != null && cH2.length > 0) {
                                    str6 = new String(cH2);
                                }
                                str3 = str6;
                            } else {
                                com.baidu.crabsdk.c.a.cx("无dump对应的.logcat文件！");
                                str3 = null;
                            }
                            String str7 = null;
                            if (W.contains(str2 + ".crab")) {
                                com.baidu.crabsdk.c.a.cx("存在dump对应的.crab文件！");
                                byte[] cH3 = f.cH(str2 + ".crab");
                                if (cH3 != null && cH3.length > 0) {
                                    str7 = new String(cH3);
                                }
                                if (str7 != null) {
                                    f = new JSONObject(com.baidu.crabsdk.c.d.cC(str7));
                                    f.put("dump", encodeToString);
                                    f.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
                                    f.put(WBConstants.SSO_APP_KEY, com.baidu.crabsdk.a.d);
                                    f.put("os", "Android");
                                    f.put("osVN", Build.VERSION.RELEASE);
                                    f.put("osVC", com.baidu.crabsdk.c.c.rW());
                                    f.put("appVC", o.J());
                                    f.put("batVN", "7.3.4");
                                    f.put("nativeVN", CrabSDK.NDK_VERSION);
                                    f.put("isRoot", p.rT());
                                    f.put("pkgName", o.G());
                                    f.put("appLabel", o.H());
                                    if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                                        f.put("appVN", o.I());
                                    } else {
                                        f.put("appVN", com.baidu.crabsdk.a.o);
                                    }
                                    f.put("model", Build.MODEL);
                                    f.put("brand", Build.BRAND);
                                    f.put("cpuabi", Build.CPU_ABI);
                                    f.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
                                    f.put("country", com.baidu.crabsdk.b.i.getCountry());
                                    f.put("batteryRate", com.baidu.crabsdk.b.g.w());
                                    f.put("appCurConfig", com.baidu.crabsdk.b.f.e(context));
                                    f.put("locale", com.baidu.crabsdk.b.i.y());
                                    f.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
                                    f.put("soLibs", f.cI(context.getApplicationInfo().nativeLibraryDir));
                                    if (com.baidu.crabsdk.a.L) {
                                        f.put("filter", 2);
                                    } else {
                                        f.put("filter", 1);
                                    }
                                }
                            } else {
                                com.baidu.crabsdk.c.a.cx("无dump对应的.crab文件！");
                                f = d.f(context, encodeToString, j);
                            }
                            if (str3 != null) {
                                f.put("logcat", str3);
                            }
                            String str8 = f.toString();
                            if (str8 == null || str8.length() == 0) {
                                com.baidu.crabsdk.c.a.cy("上传信息错误，uploadDumpData无效！！");
                            } else {
                                try {
                                    try {
                                        if (str8 != null) {
                                            try {
                                                if (str8.length() != 0) {
                                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                    DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                                                    deflaterOutputStream.write(str8.getBytes(HTTP.UTF_8));
                                                    deflaterOutputStream.close();
                                                    bArr = byteArrayOutputStream.toByteArray();
                                                    String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                                                    byte[] b = com.baidu.crabsdk.c.d.b(bArr, c);
                                                    String cD = com.baidu.crabsdk.c.e.cD(c);
                                                    String d = com.baidu.crabsdk.a.d();
                                                    com.baidu.crabsdk.c.a.cv("sendNativeRecord postUrl:" + d);
                                                    a = n.a(d, b, "NDK", cD);
                                                    com.baidu.crabsdk.c.a.cv("HttpSender.doUpload.result: " + a);
                                                    if (!TextUtils.isEmpty(a)) {
                                                        com.baidu.crabsdk.c.a.v("result is empty!");
                                                    } else if (a == null || !a.equals("500")) {
                                                        try {
                                                            jSONObject2 = new JSONObject(a);
                                                        } catch (Exception e3) {
                                                            exc = e3;
                                                            jSONObject = null;
                                                        }
                                                        try {
                                                            intValue = ((Integer) jSONObject2.get("errno")).intValue();
                                                        } catch (Exception e4) {
                                                            jSONObject = jSONObject2;
                                                            exc = e4;
                                                            try {
                                                                intValue = ((Integer) jSONObject.get("errNo")).intValue();
                                                                com.baidu.crabsdk.c.a.cv("###--> native errno = " + intValue);
                                                                switch (intValue) {
                                                                    case 0:
                                                                        break;
                                                                    case 10:
                                                                    case 14:
                                                                    case 15:
                                                                        break;
                                                                }
                                                            } catch (JSONException e5) {
                                                                com.baidu.crabsdk.c.a.cy("handle crash result json error, exception is " + exc);
                                                                exc.printStackTrace();
                                                            }
                                                        }
                                                        com.baidu.crabsdk.c.a.cv("###--> native errno = " + intValue);
                                                        switch (intValue) {
                                                            case 0:
                                                                f.deleteFile(str2);
                                                                f.deleteFile(str2 + ".crab");
                                                                f.deleteFile(str2 + ".logcat");
                                                                continue;
                                                                continue;
                                                            case 10:
                                                            case 14:
                                                            case 15:
                                                                f.deleteFile(str2);
                                                                f.deleteFile(str2 + ".crab");
                                                                f.deleteFile(str2 + ".logcat");
                                                                continue;
                                                                continue;
                                                            default:
                                                                continue;
                                                                continue;
                                                        }
                                                    } else {
                                                        com.baidu.crabsdk.c.a.v("not connected to server!");
                                                    }
                                                }
                                            } catch (Exception e6) {
                                                com.baidu.crabsdk.c.a.f("UploadLog Compress Error!", e6);
                                                e6.printStackTrace();
                                            }
                                        }
                                        String cD2 = com.baidu.crabsdk.c.e.cD(c);
                                        String d2 = com.baidu.crabsdk.a.d();
                                        com.baidu.crabsdk.c.a.cv("sendNativeRecord postUrl:" + d2);
                                        a = n.a(d2, b, "NDK", cD2);
                                        com.baidu.crabsdk.c.a.cv("HttpSender.doUpload.result: " + a);
                                        if (!TextUtils.isEmpty(a)) {
                                        }
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                        com.baidu.crabsdk.c.a.f("RSAUtils.encryptIntoBase64 Error!!", e7);
                                    }
                                    byte[] b2 = com.baidu.crabsdk.c.d.b(bArr, c);
                                } catch (Exception e8) {
                                    com.baidu.crabsdk.c.a.f("UploadLog Encrypt Error!!", e8);
                                    e8.printStackTrace();
                                }
                                bArr = null;
                                String c2 = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                            }
                        }
                    }
                    j = j2;
                    cH = f.cH(str2);
                    if (cH != null) {
                    }
                    com.baidu.crabsdk.c.a.cy("read dump file error!");
                }
            }
        }
    }

    public static void n(Context context) {
        acx.execute(new m(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void o(Context context) {
        synchronized (h.class) {
            if (f.bc(context).size() != 0) {
                String F = com.baidu.crabsdk.b.n.F();
                if ("NONE".equals(F) || "UNKNOWN".equals(F)) {
                    com.baidu.crabsdk.c.a.cx("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.cx("upload immediately!");
                    e.a(0L);
                    p(context);
                } else if ("WIFI".equals(F)) {
                    e.a(0L);
                    p(context);
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.cx("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                } else if ("MOBILE".equals(F) && e.sd()) {
                    com.baidu.crabsdk.c.a.cx("upload without wifi!");
                    e.a(0L);
                    p(context);
                } else {
                    com.baidu.crabsdk.c.a.cx("network is not wifi!");
                }
            }
        }
    }

    private static String p(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0171 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003c, B:16:0x0046, B:18:0x0066, B:19:0x008e, B:21:0x00a7, B:22:0x00b0, B:33:0x0138, B:35:0x0141, B:37:0x0149, B:38:0x014e, B:39:0x015b, B:40:0x016e, B:41:0x0171, B:49:0x01c5, B:51:0x01ee, B:54:0x01fe, B:58:0x0262, B:59:0x026a, B:57:0x0225, B:45:0x019a, B:48:0x01aa, B:23:0x00b5, B:25:0x00be, B:26:0x00e7, B:28:0x00f0, B:29:0x011a, B:31:0x0123), top: B:66:0x0005, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c5 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003c, B:16:0x0046, B:18:0x0066, B:19:0x008e, B:21:0x00a7, B:22:0x00b0, B:33:0x0138, B:35:0x0141, B:37:0x0149, B:38:0x014e, B:39:0x015b, B:40:0x016e, B:41:0x0171, B:49:0x01c5, B:51:0x01ee, B:54:0x01fe, B:58:0x0262, B:59:0x026a, B:57:0x0225, B:45:0x019a, B:48:0x01aa, B:23:0x00b5, B:25:0x00be, B:26:0x00e7, B:28:0x00f0, B:29:0x011a, B:31:0x0123), top: B:66:0x0005, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0262 A[Catch: all -> 0x0043, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003c, B:16:0x0046, B:18:0x0066, B:19:0x008e, B:21:0x00a7, B:22:0x00b0, B:33:0x0138, B:35:0x0141, B:37:0x0149, B:38:0x014e, B:39:0x015b, B:40:0x016e, B:41:0x0171, B:49:0x01c5, B:51:0x01ee, B:54:0x01fe, B:58:0x0262, B:59:0x026a, B:57:0x0225, B:45:0x019a, B:48:0x01aa, B:23:0x00b5, B:25:0x00be, B:26:0x00e7, B:28:0x00f0, B:29:0x011a, B:31:0x0123), top: B:66:0x0005, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x026a A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003c, B:16:0x0046, B:18:0x0066, B:19:0x008e, B:21:0x00a7, B:22:0x00b0, B:33:0x0138, B:35:0x0141, B:37:0x0149, B:38:0x014e, B:39:0x015b, B:40:0x016e, B:41:0x0171, B:49:0x01c5, B:51:0x01ee, B:54:0x01fe, B:58:0x0262, B:59:0x026a, B:57:0x0225, B:45:0x019a, B:48:0x01aa, B:23:0x00b5, B:25:0x00be, B:26:0x00e7, B:28:0x00f0, B:29:0x011a, B:31:0x0123), top: B:66:0x0005, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void p(Context context) {
        String str;
        Exception exc;
        JSONObject jSONObject;
        int intValue;
        JSONObject jSONObject2;
        synchronized (h.class) {
            List<String> bc = f.bc(context);
            if (bc.size() != 0) {
                for (String str2 : bc) {
                    com.baidu.crabsdk.c.a.cx("(--#)  fileName when send  (--#)" + p(str2));
                    if (e.e(str2)) {
                        byte[] cH = f.cH(str2);
                        com.baidu.crabsdk.c.a.cv("HttpSender.sendRecord: " + str2);
                        if (str2.contains("crab_crash_")) {
                            String p = p(str2);
                            String a = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.cv("sendCrashRecord postUrl:" + a);
                            str = n.a(a, cH, "Crash", p);
                            com.baidu.crabsdk.c.a.cv("HttpSender.sendCrashRecord--->Crash");
                        } else if (str2.contains("crab_anr_")) {
                            String p2 = p(str2);
                            String b = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.cv("sendSdkRecord postUrl:" + b);
                            str = n.a(b, cH, "Anr", p2);
                            com.baidu.crabsdk.c.a.cv("HttpSender.sendAnrRecord--->Anr");
                        } else if (str2.contains("crab_catched_")) {
                            String p3 = p(str2);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.cv("sendSdkRecord postUrl:" + b2);
                            str = n.a(b2, cH, "Exception", p3);
                            com.baidu.crabsdk.c.a.cv("HttpSender.sendExceptionRecord--->Exception");
                        } else if (str2.contains("crab_block_")) {
                            str = g.b(cH, "Block", p(str2));
                            com.baidu.crabsdk.c.a.cv("HttpSender.sendExceptionRecord--->Block");
                        } else {
                            str = null;
                        }
                        com.baidu.crabsdk.c.a.cv("HttpSender.doUpload.result: " + str);
                        if (TextUtils.isEmpty(str)) {
                            e.f(str2);
                            com.baidu.crabsdk.c.a.v("result is empty!");
                        } else if (str == null || !str.equals("500")) {
                            try {
                                jSONObject2 = new JSONObject(str);
                            } catch (Exception e) {
                                exc = e;
                                jSONObject = null;
                            }
                            try {
                                intValue = ((Integer) jSONObject2.get("errno")).intValue();
                            } catch (Exception e2) {
                                jSONObject = jSONObject2;
                                exc = e2;
                                try {
                                    intValue = ((Integer) jSONObject.get("errNo")).intValue();
                                    jSONObject2 = jSONObject;
                                    com.baidu.crabsdk.c.a.cv("###--> errno = " + intValue);
                                    switch (intValue) {
                                        case -1:
                                            break;
                                        case 0:
                                            break;
                                        case 1:
                                            break;
                                        case 10:
                                        case 15:
                                            break;
                                    }
                                } catch (JSONException e3) {
                                    e.f(str2);
                                    com.baidu.crabsdk.c.a.cy("handle crash result json error, exception is " + exc);
                                    exc.printStackTrace();
                                }
                                c.acq = true;
                            }
                            com.baidu.crabsdk.c.a.cv("###--> errno = " + intValue);
                            switch (intValue) {
                                case -1:
                                    e.f(str2);
                                    e.W();
                                    break;
                                case 0:
                                    f.deleteFile(str2);
                                    e.k(p(str2));
                                    e.m("key_" + p(str2));
                                    e.g(str2);
                                    e.W();
                                    break;
                                case 1:
                                    try {
                                        int intValue2 = ((Integer) jSONObject2.get("days")).intValue();
                                        if (intValue2 <= 0) {
                                            intValue2 = 1;
                                        }
                                        e.a(intValue2);
                                        f.deleteFile(str2);
                                        e.k(p(str2));
                                        e.m("key_" + p(str2));
                                        break;
                                    } catch (Exception e4) {
                                        com.baidu.crabsdk.c.a.cy("handle crash result days json error, exception is " + e4);
                                        e.a(1);
                                        f.deleteFile(str2);
                                        e.k(p(str2));
                                        e.m("key_" + p(str2));
                                        e4.printStackTrace();
                                        break;
                                    }
                                case 10:
                                case 15:
                                    f.deleteFile(str2);
                                    e.k(p(str2));
                                    e.m("key_" + p(str2));
                                    e.g(str2);
                                    e.W();
                                    break;
                                default:
                                    f.deleteFile(str2);
                                    e.k(p(str2));
                                    e.m("key_" + p(str2));
                                    e.g(str2);
                                    break;
                            }
                        } else {
                            com.baidu.crabsdk.c.a.v("not connected to server!");
                        }
                        c.acq = true;
                    } else {
                        f.deleteFile(str2);
                        e.g(str2);
                    }
                }
            }
        }
    }
}
