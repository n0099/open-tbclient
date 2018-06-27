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
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class h {
    private static HashMap<String, String> Tv = new HashMap<>();
    private static SharedPreferences Tw = null;
    private static ScheduledThreadPoolExecutor Tx = new ScheduledThreadPoolExecutor(1);

    private static long I(Context context, String str) {
        try {
            if (Tw == null && context != null) {
                Tw = context.getSharedPreferences("last_init_crab", 4);
            }
            if (Tw != null) {
                return Tw.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void a(Context context, Throwable th) {
        Tx.execute(new j(th, context));
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (h.class) {
            l lVar = new l(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis() - I(context, "time_upload_crash");
                com.baidu.crabsdk.c.a.cf("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
                if (currentTimeMillis < 10000) {
                    Tx.schedule(lVar, 10L, TimeUnit.SECONDS);
                } else {
                    Tx.execute(lVar);
                }
                e(context, "time_upload_crash");
            } else {
                Tx.execute(lVar);
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        com.baidu.crabsdk.c.a.cd("HttpSender.uploadBlock.result: " + g.b(bArr, "Block", str));
    }

    public static void c(Context context, Throwable th) {
        Tx.execute(new k(context, th));
    }

    private static String cq(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private static void e(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (Tw == null && context != null) {
                Tw = context.getSharedPreferences("last_init_crab", 4);
            }
            if (Tw != null) {
                Tw.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.c.a.cf("setLastInitTime cost time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static void k(Context context) {
        i iVar = new i(context);
        long currentTimeMillis = System.currentTimeMillis() - I(context, "time_upload_native");
        com.baidu.crabsdk.c.a.cf("uploadNativeCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
        if (currentTimeMillis < 10000) {
            Tx.schedule(iVar, 10L, TimeUnit.SECONDS);
        } else {
            Tx.execute(iVar);
        }
        e(context, "time_upload_native");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context) {
        synchronized (h.class) {
            if (f.aw(context).size() == 0) {
                com.baidu.crabsdk.c.a.ch("No Native Crash files!!");
            } else {
                String E = com.baidu.crabsdk.b.n.E();
                if ("NONE".equals(E) || "UNKNOWN".equals(E)) {
                    com.baidu.crabsdk.c.a.cf("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.cf("upload native immediately!");
                    m(context);
                } else if ("WIFI".equals(E)) {
                    m(context);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x039a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0028 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void m(Context context) {
        String str;
        byte[] bArr;
        String a;
        Exception exc;
        JSONObject jSONObject;
        int intValue;
        JSONObject jSONObject2;
        byte[] co;
        String str2;
        JSONObject c;
        synchronized (h.class) {
            List<String> aw = f.aw(context);
            if (aw.size() == 0) {
                com.baidu.crabsdk.c.a.cg("获取 native crash file 错误！！");
            } else {
                List<String> H = f.H(context, ".crab");
                List<String> H2 = f.H(context, ".logcat");
                for (String str3 : aw) {
                    String cq = cq(str3);
                    com.baidu.crabsdk.c.a.cf("(--#)  native fileName (--#)" + cq);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (cq.contains("_")) {
                        try {
                            currentTimeMillis = Long.parseLong(cq.split("_")[1]);
                        } catch (Exception e) {
                            currentTimeMillis = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.b("文件名转时间异常!!", e);
                        }
                    }
                    try {
                        co = f.co(str3);
                    } catch (JSONException e2) {
                        com.baidu.crabsdk.c.a.b("JSONObject->生成native信息错误", e2);
                        str = null;
                    } catch (Exception e3) {
                        com.baidu.crabsdk.c.a.b("JSONObject->生成native信息错误", e3);
                        str = null;
                    }
                    if (co == null || co.length == 0) {
                        com.baidu.crabsdk.c.a.cg("read dump file error!");
                    } else {
                        String encodeToString = Base64.encodeToString(co, 0);
                        if (H2.contains(str3 + ".logcat")) {
                            com.baidu.crabsdk.c.a.cf("存在dump对应的.logcat文件！");
                            byte[] co2 = f.co(str3 + ".logcat");
                            str2 = (co2 == null || co2.length <= 0) ? null : new String(co2);
                        } else {
                            com.baidu.crabsdk.c.a.cf("无dump对应的.logcat文件！");
                            str2 = null;
                        }
                        if (H.contains(str3 + ".crab")) {
                            com.baidu.crabsdk.c.a.cf("存在dump对应的.crab文件！");
                            byte[] co3 = f.co(str3 + ".crab");
                            String str4 = (co3 == null || co3.length <= 0) ? null : new String(co3);
                            if (str4 != null) {
                                c = new JSONObject(com.baidu.crabsdk.c.d.cl(str4));
                                c.put("dump", encodeToString);
                                c.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
                                c.put(WBConstants.SSO_APP_KEY, com.baidu.crabsdk.a.d);
                                c.put("os", "Android");
                                c.put("osVN", Build.VERSION.RELEASE);
                                c.put("osVC", com.baidu.crabsdk.c.c.pf());
                                c.put("appVC", o.pb());
                                c.put("batVN", "7.3.0");
                                c.put("nativeVN", CrabSDK.NDK_VERSION);
                                c.put("isRoot", p.J());
                                c.put("pkgName", o.F());
                                c.put("appLabel", o.G());
                                if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                                    c.put("appVN", o.H());
                                } else {
                                    c.put("appVN", com.baidu.crabsdk.a.o);
                                }
                                c.put("model", Build.MODEL);
                                c.put("brand", Build.BRAND);
                                c.put("cpuabi", Build.CPU_ABI);
                                c.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
                                c.put("country", com.baidu.crabsdk.b.i.getCountry());
                                c.put("batteryRate", com.baidu.crabsdk.b.g.w());
                                c.put("appCurConfig", com.baidu.crabsdk.b.f.e(context));
                                c.put("locale", com.baidu.crabsdk.b.i.y());
                                c.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
                                if (!com.baidu.crabsdk.a.L) {
                                    c.put("soLibs", f.cp(context.getApplicationInfo().nativeLibraryDir));
                                }
                            }
                        } else {
                            com.baidu.crabsdk.c.a.cf("无dump对应的.crab文件！");
                            c = d.c(context, encodeToString, currentTimeMillis);
                        }
                        if (str2 != null) {
                            c.put("logcat", str2);
                        }
                        str = c.toString();
                        if (str == null || str.length() == 0) {
                            com.baidu.crabsdk.c.a.cg("上传信息错误，uploadDumpData无效！！");
                        } else {
                            try {
                                try {
                                    if (str != null) {
                                        try {
                                            if (str.length() != 0) {
                                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                                                deflaterOutputStream.write(str.getBytes("UTF-8"));
                                                deflaterOutputStream.close();
                                                bArr = byteArrayOutputStream.toByteArray();
                                                String c2 = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                                                byte[] b = com.baidu.crabsdk.c.d.b(bArr, c2);
                                                String cm = com.baidu.crabsdk.c.e.cm(c2);
                                                String d = com.baidu.crabsdk.a.d();
                                                com.baidu.crabsdk.c.a.cd("sendNativeRecord postUrl:" + d);
                                                a = n.a(d, b, "NDK", cm);
                                                com.baidu.crabsdk.c.a.cd("HttpSender.doUpload.result: " + a);
                                                if (TextUtils.isEmpty(a)) {
                                                    try {
                                                        jSONObject2 = new JSONObject(a);
                                                    } catch (Exception e4) {
                                                        exc = e4;
                                                        jSONObject = null;
                                                    }
                                                    try {
                                                        intValue = ((Integer) jSONObject2.get("errno")).intValue();
                                                    } catch (Exception e5) {
                                                        jSONObject = jSONObject2;
                                                        exc = e5;
                                                        try {
                                                            intValue = ((Integer) jSONObject.get("errNo")).intValue();
                                                            com.baidu.crabsdk.c.a.cd("###--> native errno = " + intValue);
                                                            switch (intValue) {
                                                                case 0:
                                                                    break;
                                                                case 10:
                                                                case 14:
                                                                case 15:
                                                                    break;
                                                            }
                                                        } catch (JSONException e6) {
                                                            com.baidu.crabsdk.c.a.cg("handle crash result json error, exception is " + exc);
                                                            exc.printStackTrace();
                                                        }
                                                    }
                                                    com.baidu.crabsdk.c.a.cd("###--> native errno = " + intValue);
                                                    switch (intValue) {
                                                        case 0:
                                                            f.deleteFile(str3);
                                                            f.deleteFile(str3 + ".crab");
                                                            f.deleteFile(str3 + ".logcat");
                                                            continue;
                                                            continue;
                                                        case 10:
                                                        case 14:
                                                        case 15:
                                                            f.deleteFile(str3);
                                                            f.deleteFile(str3 + ".crab");
                                                            f.deleteFile(str3 + ".logcat");
                                                            continue;
                                                            continue;
                                                        default:
                                                            continue;
                                                            continue;
                                                    }
                                                }
                                            }
                                        } catch (Exception e7) {
                                            com.baidu.crabsdk.c.a.b("UploadLog Compress Error!", e7);
                                            e7.printStackTrace();
                                        }
                                    }
                                    String cm2 = com.baidu.crabsdk.c.e.cm(c2);
                                    String d2 = com.baidu.crabsdk.a.d();
                                    com.baidu.crabsdk.c.a.cd("sendNativeRecord postUrl:" + d2);
                                    a = n.a(d2, b, "NDK", cm2);
                                    com.baidu.crabsdk.c.a.cd("HttpSender.doUpload.result: " + a);
                                    if (TextUtils.isEmpty(a)) {
                                    }
                                } catch (Exception e8) {
                                    e8.printStackTrace();
                                    com.baidu.crabsdk.c.a.b("RSAUtils.encryptIntoBase64 Error!!", e8);
                                }
                                byte[] b2 = com.baidu.crabsdk.c.d.b(bArr, c2);
                            } catch (Exception e9) {
                                com.baidu.crabsdk.c.a.b("UploadLog Encrypt Error!!", e9);
                                e9.printStackTrace();
                            }
                            bArr = null;
                            String c22 = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                        }
                    }
                }
            }
        }
    }

    public static void n(Context context) {
        Tx.execute(new m(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void o(Context context) {
        synchronized (h.class) {
            if (f.av(context).size() != 0) {
                String E = com.baidu.crabsdk.b.n.E();
                if ("NONE".equals(E) || "UNKNOWN".equals(E)) {
                    com.baidu.crabsdk.c.a.cf("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.cf("upload immediately!");
                    e.a(0L);
                    p(context);
                } else if ("WIFI".equals(E)) {
                    e.a(0L);
                    p(context);
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.cf("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                } else if ("MOBILE".equals(E) && e.pn()) {
                    com.baidu.crabsdk.c.a.cf("upload without wifi!");
                    e.a(0L);
                    p(context);
                } else {
                    com.baidu.crabsdk.c.a.cf("network is not wifi!");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0169 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003e, B:16:0x0045, B:18:0x004b, B:19:0x0052, B:21:0x0077, B:22:0x009f, B:24:0x00b8, B:25:0x00bb, B:36:0x0141, B:37:0x0146, B:38:0x0153, B:39:0x0166, B:40:0x0169, B:48:0x01bd, B:50:0x01e6, B:53:0x01f6, B:57:0x025a, B:58:0x0262, B:56:0x021d, B:44:0x0192, B:47:0x01a2, B:26:0x00c0, B:28:0x00c9, B:29:0x00f2, B:31:0x00fb, B:32:0x0125, B:34:0x012e), top: B:69:0x0005, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bd A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003e, B:16:0x0045, B:18:0x004b, B:19:0x0052, B:21:0x0077, B:22:0x009f, B:24:0x00b8, B:25:0x00bb, B:36:0x0141, B:37:0x0146, B:38:0x0153, B:39:0x0166, B:40:0x0169, B:48:0x01bd, B:50:0x01e6, B:53:0x01f6, B:57:0x025a, B:58:0x0262, B:56:0x021d, B:44:0x0192, B:47:0x01a2, B:26:0x00c0, B:28:0x00c9, B:29:0x00f2, B:31:0x00fb, B:32:0x0125, B:34:0x012e), top: B:69:0x0005, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025a A[Catch: all -> 0x0042, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003e, B:16:0x0045, B:18:0x004b, B:19:0x0052, B:21:0x0077, B:22:0x009f, B:24:0x00b8, B:25:0x00bb, B:36:0x0141, B:37:0x0146, B:38:0x0153, B:39:0x0166, B:40:0x0169, B:48:0x01bd, B:50:0x01e6, B:53:0x01f6, B:57:0x025a, B:58:0x0262, B:56:0x021d, B:44:0x0192, B:47:0x01a2, B:26:0x00c0, B:28:0x00c9, B:29:0x00f2, B:31:0x00fb, B:32:0x0125, B:34:0x012e), top: B:69:0x0005, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0262 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0013, B:9:0x0019, B:11:0x003e, B:16:0x0045, B:18:0x004b, B:19:0x0052, B:21:0x0077, B:22:0x009f, B:24:0x00b8, B:25:0x00bb, B:36:0x0141, B:37:0x0146, B:38:0x0153, B:39:0x0166, B:40:0x0169, B:48:0x01bd, B:50:0x01e6, B:53:0x01f6, B:57:0x025a, B:58:0x0262, B:56:0x021d, B:44:0x0192, B:47:0x01a2, B:26:0x00c0, B:28:0x00c9, B:29:0x00f2, B:31:0x00fb, B:32:0x0125, B:34:0x012e), top: B:69:0x0005, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            List<String> av = f.av(context);
            if (av.size() != 0) {
                for (String str2 : av) {
                    com.baidu.crabsdk.c.a.cf("(--#)  fileName when send  (--#)" + cq(str2));
                    if (Tv.containsKey(str2)) {
                        f.deleteFile(str2);
                    } else if (e.d(str2)) {
                        Tv.put(str2, str2);
                        byte[] co = f.co(str2);
                        com.baidu.crabsdk.c.a.cd("HttpSender.sendRecord: " + str2);
                        if (str2.contains("crab_crash_")) {
                            String cq = cq(str2);
                            String a = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.cd("sendCrashRecord postUrl:" + a);
                            str = n.a(a, co, "Crash", cq);
                            com.baidu.crabsdk.c.a.cd("HttpSender.sendCrashRecord--->Crash");
                        } else if (str2.contains("crab_anr_")) {
                            String cq2 = cq(str2);
                            String b = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.cd("sendSdkRecord postUrl:" + b);
                            str = n.a(b, co, "Anr", cq2);
                            com.baidu.crabsdk.c.a.cd("HttpSender.sendAnrRecord--->Anr");
                        } else if (str2.contains("crab_catched_")) {
                            String cq3 = cq(str2);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.cd("sendSdkRecord postUrl:" + b2);
                            str = n.a(b2, co, "Exception", cq3);
                            com.baidu.crabsdk.c.a.cd("HttpSender.sendExceptionRecord--->Exception");
                        } else if (str2.contains("crab_block_")) {
                            str = g.b(co, "Block", cq(str2));
                            com.baidu.crabsdk.c.a.cd("HttpSender.sendExceptionRecord--->Block");
                        } else {
                            str = null;
                        }
                        com.baidu.crabsdk.c.a.cd("HttpSender.doUpload.result: " + str);
                        if (!TextUtils.isEmpty(str)) {
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
                                    com.baidu.crabsdk.c.a.cd("###--> errno = " + intValue);
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
                                    e.e(str2);
                                    com.baidu.crabsdk.c.a.cg("handle crash result json error, exception is " + exc);
                                    exc.printStackTrace();
                                }
                                c.Tq = true;
                            }
                            com.baidu.crabsdk.c.a.cd("###--> errno = " + intValue);
                            switch (intValue) {
                                case -1:
                                    e.e(str2);
                                    e.V();
                                    break;
                                case 0:
                                    f.deleteFile(str2);
                                    e.j(cq(str2));
                                    e.l("key_" + cq(str2));
                                    e.f(str2);
                                    e.V();
                                    break;
                                case 1:
                                    try {
                                        int intValue2 = ((Integer) jSONObject2.get("days")).intValue();
                                        if (intValue2 <= 0) {
                                            intValue2 = 1;
                                        }
                                        e.a(intValue2);
                                        f.deleteFile(str2);
                                        e.j(cq(str2));
                                        e.l("key_" + cq(str2));
                                        break;
                                    } catch (Exception e4) {
                                        com.baidu.crabsdk.c.a.cg("handle crash result days json error, exception is " + e4);
                                        e.a(1);
                                        f.deleteFile(str2);
                                        e.j(cq(str2));
                                        e.l("key_" + cq(str2));
                                        e4.printStackTrace();
                                        break;
                                    }
                                case 10:
                                case 15:
                                    f.deleteFile(str2);
                                    e.j(cq(str2));
                                    e.l("key_" + cq(str2));
                                    e.f(str2);
                                    e.V();
                                    break;
                                default:
                                    f.deleteFile(str2);
                                    e.j(cq(str2));
                                    e.l("key_" + cq(str2));
                                    e.f(str2);
                                    break;
                            }
                        } else {
                            e.e(str2);
                        }
                        c.Tq = true;
                    } else {
                        f.deleteFile(str2);
                        e.f(str2);
                    }
                }
            }
        }
    }
}
