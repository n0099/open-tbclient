package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.crabsdk.b.r;
import com.baidu.crabsdk.b.s;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public final class k {
    private static SharedPreferences KS = null;
    private static ScheduledThreadPoolExecutor KT = new ScheduledThreadPoolExecutor(1);

    private static long H(Context context, String str) {
        try {
            if (KS == null && context != null) {
                KS = context.getSharedPreferences("last_init_crab", 4);
            }
            if (KS != null) {
                return KS.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void a(Context context, Throwable th) {
        KT.execute(new m(th, context));
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (k.class) {
            o oVar = new o(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis() - H(context, "time_upload_crash");
                com.baidu.crabsdk.c.a.v("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
                if (currentTimeMillis < 10000) {
                    KT.schedule(oVar, 10L, TimeUnit.SECONDS);
                } else {
                    KT.execute(oVar);
                }
                e(context, "time_upload_crash");
            } else {
                KT.execute(oVar);
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        com.baidu.crabsdk.c.a.bu("HttpSender.uploadBlock.result: " + j.b(bArr, "Block", str));
    }

    private static synchronized void an(Context context) {
        String str;
        synchronized (k.class) {
            List<String> al = i.al(context);
            if (al.size() != 0) {
                for (String str2 : al) {
                    com.baidu.crabsdk.c.a.v("(--#)  fileName when send  (--#)" + bJ(str2));
                    if (h.h(str2)) {
                        byte[] bH = i.bH(str2);
                        com.baidu.crabsdk.c.a.bu("HttpSender.sendRecord: " + str2);
                        if (str2.contains("crab_crash_")) {
                            String bJ = bJ(str2);
                            String a = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.bu("sendCrashRecord postUrl:" + a);
                            String a2 = q.a(a, bH, "Crash", bJ);
                            com.baidu.crabsdk.c.a.bu("HttpSender.sendCrashRecord--->Crash");
                            str = a2;
                        } else if (str2.contains("crab_anr_")) {
                            String bJ2 = bJ(str2);
                            String b = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.bu("sendSdkRecord postUrl:" + b);
                            String a3 = q.a(b, bH, "Anr", bJ2);
                            com.baidu.crabsdk.c.a.bu("HttpSender.sendAnrRecord--->Anr");
                            str = a3;
                        } else if (str2.contains("crab_catched_")) {
                            String bJ3 = bJ(str2);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.bu("sendSdkRecord postUrl:" + b2);
                            String a4 = q.a(b2, bH, "Exception", bJ3);
                            com.baidu.crabsdk.c.a.bu("HttpSender.sendExceptionRecord--->Exception");
                            str = a4;
                        } else if (str2.contains("crab_block_")) {
                            String b3 = j.b(bH, "Block", bJ(str2));
                            com.baidu.crabsdk.c.a.bu("HttpSender.sendExceptionRecord--->Block");
                            str = b3;
                        } else {
                            str = null;
                        }
                        com.baidu.crabsdk.c.a.bu("HttpSender.doUpload.result: " + str);
                        if (TextUtils.isEmpty(str)) {
                            h.i(str2);
                            com.baidu.crabsdk.c.a.bw("result is empty!");
                        } else if (str == null || !str.equals("500")) {
                            int i = -100;
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("errno")) {
                                    i = ((Integer) jSONObject.get("errno")).intValue();
                                } else if (jSONObject.has("errNo")) {
                                    i = ((Integer) jSONObject.get("errNo")).intValue();
                                }
                                com.baidu.crabsdk.c.a.bu("###--> errno = " + i);
                                switch (i) {
                                    case -1:
                                        h.i(str2);
                                        h.V();
                                        break;
                                    case 0:
                                        i.deleteFile(str2);
                                        h.n(bJ(str2));
                                        h.p("key_" + bJ(str2));
                                        h.j(str2);
                                        h.V();
                                        break;
                                    case 1:
                                        try {
                                            int intValue = ((Integer) jSONObject.get("days")).intValue();
                                            if (intValue <= 0) {
                                                intValue = 1;
                                            }
                                            h.a(intValue);
                                            i.deleteFile(str2);
                                            h.n(bJ(str2));
                                            h.p("key_" + bJ(str2));
                                            break;
                                        } catch (Exception e) {
                                            com.baidu.crabsdk.c.a.w("handle crash result days json error, exception is " + e);
                                            h.a(1);
                                            i.deleteFile(str2);
                                            h.n(bJ(str2));
                                            h.p("key_" + bJ(str2));
                                            e.printStackTrace();
                                            break;
                                        }
                                    case 10:
                                    case 15:
                                        i.deleteFile(str2);
                                        h.n(bJ(str2));
                                        h.p("key_" + bJ(str2));
                                        h.j(str2);
                                        h.V();
                                        break;
                                    default:
                                        i.deleteFile(str2);
                                        h.n(bJ(str2));
                                        h.p("key_" + bJ(str2));
                                        h.j(str2);
                                        break;
                                }
                            } catch (Exception e2) {
                                h.i(str2);
                                com.baidu.crabsdk.c.a.w("handle crash result json error, exception is " + e2);
                                e2.printStackTrace();
                            }
                        } else {
                            com.baidu.crabsdk.c.a.bw("not connected to server!");
                        }
                        f.KN = true;
                    } else {
                        i.deleteFile(str2);
                        h.j(str2);
                    }
                }
            }
        }
    }

    private static String bJ(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static void c(Context context, Throwable th) {
        KT.execute(new n(context, th));
    }

    private static void e(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (KS == null && context != null) {
                KS = context.getSharedPreferences("last_init_crab", 4);
            }
            if (KS != null) {
                KS.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.c.a.v("setLastInitTime cost time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static void k(Context context) {
        l lVar = new l(context);
        long currentTimeMillis = System.currentTimeMillis() - H(context, "time_upload_native");
        com.baidu.crabsdk.c.a.v("uploadNativeCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
        if (currentTimeMillis < 10000) {
            KT.schedule(lVar, 10L, TimeUnit.SECONDS);
        } else {
            KT.execute(lVar);
        }
        e(context, "time_upload_native");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context) {
        synchronized (k.class) {
            if (i.am(context).size() == 0) {
                com.baidu.crabsdk.c.a.bw("No Native Crash files!!");
            } else {
                String E = com.baidu.crabsdk.b.n.E();
                if ("NONE".equals(E) || "UNKNOWN".equals(E)) {
                    com.baidu.crabsdk.c.a.v("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.v("upload native immediately!");
                    m(context);
                } else if ("WIFI".equals(E)) {
                    m(context);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:13|(1:15)(1:154)|16|(2:21|22)|27|(8:31|32|33|34|35|36|(2:41|42)(9:44|45|46|(3:48|(1:52)|53)(1:141)|54|(3:56|(1:60)|(4:65|66|(1:68)|69))(2:139|140)|(1:71)|72|(2:77|78)(3:79|80|(9:82|83|84|85|87|88|90|91|(3:126|127|128)(2:93|(7:98|99|100|102|(1:104)(2:116|(1:118))|105|106)(3:122|123|124)))(1:135)))|43)|153|35|36|(2:38|40)(1:142)|41|42|43|11) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
        com.baidu.crabsdk.c.a.f("Create doUploadNative error!", r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x031b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x031d, code lost:
        com.baidu.crabsdk.c.a.f("Create doUploadNative error!", r0);
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void m(Context context) {
        String str;
        String str2;
        long j;
        byte[] bH;
        String str3;
        JSONObject c;
        String bB;
        synchronized (k.class) {
            List<String> am = i.am(context);
            if (am.size() == 0) {
                com.baidu.crabsdk.c.a.w("Native crash files dir is empty!");
            } else {
                List<String> G = i.G(context, ".crab");
                List<String> G2 = i.G(context, ".logcat");
                for (String str4 : am) {
                    com.baidu.crabsdk.c.a.bu("absolute native file path@lastModifiedTime: " + str4);
                    if (str4.contains("@")) {
                        String[] split = str4.split("@");
                        String str5 = split[0];
                        str = split[1];
                        str2 = str5;
                    } else {
                        str = null;
                        str2 = str4;
                    }
                    String bJ = bJ(str2);
                    com.baidu.crabsdk.c.a.bu("native fileNameOnly: " + bJ);
                    long j2 = 0;
                    if (str != null && str.length() > 1) {
                        try {
                            j2 = Long.parseLong(str);
                        } catch (Exception e) {
                            j2 = 0;
                            com.baidu.crabsdk.c.a.f("Native crash occr time(java) in filename para error!", e);
                        }
                    }
                    if (j2 == 0 && bJ.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                        try {
                            j = Long.parseLong(bJ.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[1]);
                        } catch (Exception e2) {
                            j2 = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.f("Native crash occr time(c) in filename para error!", e2);
                        }
                        bH = i.bH(str2);
                        if (bH != null || bH.length == 0) {
                            com.baidu.crabsdk.c.a.w("read dump file error!");
                        } else {
                            String encodeToString = Base64.encodeToString(bH, 0);
                            String str6 = null;
                            if (G2.contains(str2 + ".logcat")) {
                                com.baidu.crabsdk.c.a.v("Find .logcat file relative with dump file.");
                                byte[] bH2 = i.bH(str2 + ".logcat");
                                if (bH2 != null && bH2.length > 0) {
                                    str6 = new String(bH2);
                                }
                                str3 = str6;
                            } else {
                                com.baidu.crabsdk.c.a.v("Not find .logcat files.");
                                str3 = null;
                            }
                            String str7 = null;
                            if (G.contains(str2 + ".crab")) {
                                com.baidu.crabsdk.c.a.v("Find .crab file relative with dump file.");
                                byte[] bH3 = i.bH(str2 + ".crab");
                                if (bH3 != null && bH3.length > 0) {
                                    str7 = new String(bH3);
                                }
                                if (str7 != null && (bB = com.baidu.crabsdk.c.d.bB(str7)) != null) {
                                    c = new JSONObject(bB);
                                    com.baidu.crabsdk.c.a.v(".Crab file content is:\n" + c.toString());
                                    c.put("dump", encodeToString);
                                    c.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
                                    c.put("appKey", com.baidu.crabsdk.a.d);
                                    c.put("os", "Android");
                                    c.put("osVN", Build.VERSION.RELEASE);
                                    c.put("osVC", Build.VERSION.SDK_INT);
                                    c.put("isRoot", com.baidu.crabsdk.b.p.J());
                                    c.put("model", Build.MODEL);
                                    c.put(Constants.PHONE_BRAND, Build.BRAND);
                                    c.put("cpuabi", Build.CPU_ABI);
                                    c.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
                                    c.put("country", com.baidu.crabsdk.b.i.getCountry());
                                    c.put("batteryRate", com.baidu.crabsdk.b.g.v());
                                    c.put("appCurConfig", com.baidu.crabsdk.b.f.d(context));
                                    c.put("locale", com.baidu.crabsdk.b.i.x());
                                    c.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
                                    c.put("memInfo", com.baidu.crabsdk.b.l.A());
                                    c.put("networkInfo", com.baidu.crabsdk.b.n.D().trim());
                                    c.put(BdStatsConstant.StatsKey.UNAME, s.getUserName());
                                    c.put("uid", s.M());
                                    if (!TextUtils.isEmpty(s.O())) {
                                        c.put("usersCustom", s.O());
                                    }
                                    c.put("batteryRate", com.baidu.crabsdk.b.g.v());
                                    c.put("javaLine", "N/A");
                                    c.put("errorTrace", "N/A");
                                    c.put("CUID", com.baidu.crabsdk.b.h.g(context));
                                    c.put("channel", com.baidu.crabsdk.a.b);
                                    c.put("myAppCPUStat", com.baidu.crabsdk.b.e.u());
                                    c.put("curPage", com.baidu.crabsdk.b.a.q());
                                    c.put("startupTime", com.baidu.crabsdk.b.a.o());
                                    c.put("pageHistory", com.baidu.crabsdk.b.a.p());
                                    c.put("sysMemInfo", com.baidu.crabsdk.b.l.z());
                                    c.put("allThreadStacks", r.L());
                                    c.put("internalStorageInfo", com.baidu.crabsdk.b.q.mq());
                                    c.put("phoneTime", j);
                                }
                            } else {
                                com.baidu.crabsdk.c.a.v("Not find .crab file relative with dump file.");
                                c = g.c(context, encodeToString, j);
                            }
                            if (str3 != null) {
                                c.put("logcat", str3);
                            }
                            String str8 = c.toString();
                            if (str8 == null || str8.length() == 0) {
                                com.baidu.crabsdk.c.a.w("Error, uploadDumpData is invalid!");
                            } else {
                                byte[] by = com.baidu.crabsdk.c.c.by(str8);
                                if (by != null) {
                                    String c2 = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                                    try {
                                        byte[] b = com.baidu.crabsdk.c.d.b(by, c2);
                                        try {
                                            String bC = com.baidu.crabsdk.c.e.bC(c2);
                                            String d = com.baidu.crabsdk.a.d();
                                            com.baidu.crabsdk.c.a.bu("sendNativeRecord postUrl:" + d);
                                            String a = q.a(d, b, "NDK", bC);
                                            com.baidu.crabsdk.c.a.bu("HttpSender.doUpload.result: " + a);
                                            if (TextUtils.isEmpty(a)) {
                                                com.baidu.crabsdk.c.a.bw("result is empty!");
                                            } else if (a == null || !a.equals("500")) {
                                                int i = -100;
                                                try {
                                                    JSONObject jSONObject = new JSONObject(a);
                                                    if (jSONObject.has("errno")) {
                                                        i = ((Integer) jSONObject.get("errno")).intValue();
                                                    } else if (jSONObject.has("errNo")) {
                                                        i = ((Integer) jSONObject.get("errNo")).intValue();
                                                    }
                                                    com.baidu.crabsdk.c.a.bu("###--> native errno = " + i);
                                                    switch (i) {
                                                        case 0:
                                                            i.deleteFile(str2);
                                                            i.deleteFile(str2 + ".crab");
                                                            i.deleteFile(str2 + ".logcat");
                                                            continue;
                                                        case 10:
                                                        case 14:
                                                        case 15:
                                                            i.deleteFile(str2);
                                                            i.deleteFile(str2 + ".crab");
                                                            i.deleteFile(str2 + ".logcat");
                                                            continue;
                                                        default:
                                                            i.deleteFile(str2);
                                                            i.deleteFile(str2 + ".crab");
                                                            i.deleteFile(str2 + ".logcat");
                                                            continue;
                                                    }
                                                } catch (Exception e3) {
                                                    com.baidu.crabsdk.c.a.w("handle crash result json error, exception is " + e3);
                                                }
                                            } else {
                                                com.baidu.crabsdk.c.a.bw("not connected to server!");
                                            }
                                        } catch (Exception e4) {
                                            com.baidu.crabsdk.c.a.f("RSAUtils.encryptIntoBase64 Error!", e4);
                                        }
                                    } catch (Exception e5) {
                                        com.baidu.crabsdk.c.a.f("UploadLog Encrypt Error!!", e5);
                                    }
                                }
                            }
                        }
                    }
                    j = j2;
                    bH = i.bH(str2);
                    if (bH != null) {
                    }
                    com.baidu.crabsdk.c.a.w("read dump file error!");
                }
            }
        }
    }

    public static void n(Context context) {
        KT.execute(new p(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void o(Context context) {
        synchronized (k.class) {
            if (i.al(context).size() != 0) {
                String E = com.baidu.crabsdk.b.n.E();
                if ("NONE".equals(E) || "UNKNOWN".equals(E)) {
                    com.baidu.crabsdk.c.a.v("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.v("upload immediately!");
                    h.a(0L);
                    an(context);
                } else if ("WIFI".equals(E)) {
                    h.a(0L);
                    an(context);
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.v("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                } else if ("MOBILE".equals(E) && h.mA()) {
                    com.baidu.crabsdk.c.a.v("upload without wifi!");
                    h.a(0L);
                    an(context);
                } else {
                    com.baidu.crabsdk.c.a.v("network is not wifi!");
                }
            }
        }
    }
}
