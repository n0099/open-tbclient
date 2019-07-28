package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.crabsdk.b.r;
import com.baidu.crabsdk.b.s;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public final class k {
    private static SharedPreferences aaM = null;
    private static ScheduledThreadPoolExecutor aaN = new ScheduledThreadPoolExecutor(1);

    private static long J(Context context, String str) {
        try {
            if (aaM == null && context != null) {
                aaM = context.getSharedPreferences("last_init_crab", 4);
            }
            if (aaM != null) {
                return aaM.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void a(Context context, Throwable th) {
        aaN.execute(new m(th, context));
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (k.class) {
            o oVar = new o(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis() - J(context, "time_upload_crash");
                com.baidu.crabsdk.c.a.v("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
                if (currentTimeMillis < 10000) {
                    aaN.schedule(oVar, 10L, TimeUnit.SECONDS);
                } else {
                    aaN.execute(oVar);
                }
                e(context, "time_upload_crash");
            } else {
                aaN.execute(oVar);
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        com.baidu.crabsdk.c.a.ch("HttpSender.uploadBlock.result: " + j.b(bArr, "Block", str));
    }

    public static void aw(Context context) {
        aaN.execute(new p(context));
    }

    public static void c(Context context, Throwable th) {
        aaN.execute(new n(context, th));
    }

    private static String cw(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private static void e(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (aaM == null && context != null) {
                aaM = context.getSharedPreferences("last_init_crab", 4);
            }
            if (aaM != null) {
                aaM.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.c.a.v("setLastInitTime cost time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static void k(Context context) {
        l lVar = new l(context);
        long currentTimeMillis = System.currentTimeMillis() - J(context, "time_upload_native");
        com.baidu.crabsdk.c.a.v("uploadNativeCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
        if (currentTimeMillis < 10000) {
            aaN.schedule(lVar, 10L, TimeUnit.SECONDS);
        } else {
            aaN.execute(lVar);
        }
        e(context, "time_upload_native");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context) {
        synchronized (k.class) {
            if (i.av(context).size() == 0) {
                com.baidu.crabsdk.c.a.cj("No Native Crash files!!");
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
        com.baidu.crabsdk.c.a.a("Create doUploadNative error!", r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x031b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x031d, code lost:
        com.baidu.crabsdk.c.a.a("Create doUploadNative error!", r0);
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void m(Context context) {
        String str;
        String str2;
        long j;
        byte[] cu;
        String str3;
        JSONObject c;
        String co;
        synchronized (k.class) {
            List<String> av = i.av(context);
            if (av.size() == 0) {
                com.baidu.crabsdk.c.a.w("Native crash files dir is empty!");
            } else {
                List<String> I = i.I(context, ".crab");
                List<String> I2 = i.I(context, ".logcat");
                for (String str4 : av) {
                    com.baidu.crabsdk.c.a.ch("absolute native file path@lastModifiedTime: " + str4);
                    if (str4.contains("@")) {
                        String[] split = str4.split("@");
                        String str5 = split[0];
                        str = split[1];
                        str2 = str5;
                    } else {
                        str = null;
                        str2 = str4;
                    }
                    String cw = cw(str2);
                    com.baidu.crabsdk.c.a.ch("native fileNameOnly: " + cw);
                    long j2 = 0;
                    if (str != null && str.length() > 1) {
                        try {
                            j2 = Long.parseLong(str);
                        } catch (Exception e) {
                            j2 = 0;
                            com.baidu.crabsdk.c.a.a("Native crash occr time(java) in filename para error!", e);
                        }
                    }
                    if (j2 == 0 && cw.contains("_")) {
                        try {
                            j = Long.parseLong(cw.split("_")[1]);
                        } catch (Exception e2) {
                            j2 = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.a("Native crash occr time(c) in filename para error!", e2);
                        }
                        cu = i.cu(str2);
                        if (cu != null || cu.length == 0) {
                            com.baidu.crabsdk.c.a.w("read dump file error!");
                        } else {
                            String encodeToString = Base64.encodeToString(cu, 0);
                            String str6 = null;
                            if (I2.contains(str2 + ".logcat")) {
                                com.baidu.crabsdk.c.a.v("Find .logcat file relative with dump file.");
                                byte[] cu2 = i.cu(str2 + ".logcat");
                                if (cu2 != null && cu2.length > 0) {
                                    str6 = new String(cu2);
                                }
                                str3 = str6;
                            } else {
                                com.baidu.crabsdk.c.a.v("Not find .logcat files.");
                                str3 = null;
                            }
                            String str7 = null;
                            if (I.contains(str2 + ".crab")) {
                                com.baidu.crabsdk.c.a.v("Find .crab file relative with dump file.");
                                byte[] cu3 = i.cu(str2 + ".crab");
                                if (cu3 != null && cu3.length > 0) {
                                    str7 = new String(cu3);
                                }
                                if (str7 != null && (co = com.baidu.crabsdk.c.d.co(str7)) != null) {
                                    c = new JSONObject(co);
                                    com.baidu.crabsdk.c.a.v(".Crab file content is:\n" + c.toString());
                                    c.put("dump", encodeToString);
                                    c.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
                                    c.put("appKey", com.baidu.crabsdk.a.d);
                                    c.put(IXAdRequestInfo.OS, "Android");
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
                                    c.put("uname", s.getUserName());
                                    c.put("uid", s.M());
                                    if (!TextUtils.isEmpty(s.O())) {
                                        c.put("usersCustom", s.O());
                                    }
                                    c.put("batteryRate", com.baidu.crabsdk.b.g.v());
                                    c.put("javaLine", "N/A");
                                    c.put("errorTrace", "N/A");
                                    c.put("CUID", com.baidu.crabsdk.b.h.g(context));
                                    c.put(LogBuilder.KEY_CHANNEL, com.baidu.crabsdk.a.b);
                                    c.put("myAppCPUStat", com.baidu.crabsdk.b.e.u());
                                    c.put("curPage", com.baidu.crabsdk.b.a.q());
                                    c.put("startupTime", com.baidu.crabsdk.b.a.rh());
                                    c.put("pageHistory", com.baidu.crabsdk.b.a.p());
                                    c.put("sysMemInfo", com.baidu.crabsdk.b.l.z());
                                    c.put("allThreadStacks", r.L());
                                    c.put("internalStorageInfo", com.baidu.crabsdk.b.q.rl());
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
                                byte[] cl = com.baidu.crabsdk.c.c.cl(str8);
                                if (cl != null) {
                                    String c2 = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                                    try {
                                        byte[] b = com.baidu.crabsdk.c.d.b(cl, c2);
                                        try {
                                            String cp = com.baidu.crabsdk.c.e.cp(c2);
                                            String d = com.baidu.crabsdk.a.d();
                                            com.baidu.crabsdk.c.a.ch("sendNativeRecord postUrl:" + d);
                                            String a = q.a(d, b, "NDK", cp);
                                            com.baidu.crabsdk.c.a.ch("HttpSender.doUpload.result: " + a);
                                            if (TextUtils.isEmpty(a)) {
                                                com.baidu.crabsdk.c.a.cj("result is empty!");
                                            } else if (a == null || !a.equals("500")) {
                                                int i = -100;
                                                try {
                                                    JSONObject jSONObject = new JSONObject(a);
                                                    if (jSONObject.has("errno")) {
                                                        i = ((Integer) jSONObject.get("errno")).intValue();
                                                    } else if (jSONObject.has("errNo")) {
                                                        i = ((Integer) jSONObject.get("errNo")).intValue();
                                                    }
                                                    com.baidu.crabsdk.c.a.ch("###--> native errno = " + i);
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
                                                com.baidu.crabsdk.c.a.cj("not connected to server!");
                                            }
                                        } catch (Exception e4) {
                                            com.baidu.crabsdk.c.a.a("RSAUtils.encryptIntoBase64 Error!", e4);
                                        }
                                    } catch (Exception e5) {
                                        com.baidu.crabsdk.c.a.a("UploadLog Encrypt Error!!", e5);
                                    }
                                }
                            }
                        }
                    }
                    j = j2;
                    cu = i.cu(str2);
                    if (cu != null) {
                    }
                    com.baidu.crabsdk.c.a.w("read dump file error!");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void o(Context context) {
        synchronized (k.class) {
            if (i.au(context).size() != 0) {
                String E = com.baidu.crabsdk.b.n.E();
                if ("NONE".equals(E) || "UNKNOWN".equals(E)) {
                    com.baidu.crabsdk.c.a.v("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.v("upload immediately!");
                    h.a(0L);
                    p(context);
                } else if ("WIFI".equals(E)) {
                    h.a(0L);
                    p(context);
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.v("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                } else if ("MOBILE".equals(E) && h.rv()) {
                    com.baidu.crabsdk.c.a.v("upload without wifi!");
                    h.a(0L);
                    p(context);
                } else {
                    com.baidu.crabsdk.c.a.v("network is not wifi!");
                }
            }
        }
    }

    private static synchronized void p(Context context) {
        String str;
        synchronized (k.class) {
            List<String> au = i.au(context);
            if (au.size() != 0) {
                for (String str2 : au) {
                    com.baidu.crabsdk.c.a.v("(--#)  fileName when send  (--#)" + cw(str2));
                    if (h.h(str2)) {
                        byte[] cu = i.cu(str2);
                        com.baidu.crabsdk.c.a.ch("HttpSender.sendRecord: " + str2);
                        if (str2.contains("crab_crash_")) {
                            String cw = cw(str2);
                            String a = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.ch("sendCrashRecord postUrl:" + a);
                            String a2 = q.a(a, cu, "Crash", cw);
                            com.baidu.crabsdk.c.a.ch("HttpSender.sendCrashRecord--->Crash");
                            str = a2;
                        } else if (str2.contains("crab_anr_")) {
                            String cw2 = cw(str2);
                            String b = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.ch("sendSdkRecord postUrl:" + b);
                            String a3 = q.a(b, cu, "Anr", cw2);
                            com.baidu.crabsdk.c.a.ch("HttpSender.sendAnrRecord--->Anr");
                            str = a3;
                        } else if (str2.contains("crab_catched_")) {
                            String cw3 = cw(str2);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.ch("sendSdkRecord postUrl:" + b2);
                            String a4 = q.a(b2, cu, "Exception", cw3);
                            com.baidu.crabsdk.c.a.ch("HttpSender.sendExceptionRecord--->Exception");
                            str = a4;
                        } else if (str2.contains("crab_block_")) {
                            String b3 = j.b(cu, "Block", cw(str2));
                            com.baidu.crabsdk.c.a.ch("HttpSender.sendExceptionRecord--->Block");
                            str = b3;
                        } else {
                            str = null;
                        }
                        com.baidu.crabsdk.c.a.ch("HttpSender.doUpload.result: " + str);
                        if (TextUtils.isEmpty(str)) {
                            h.i(str2);
                            com.baidu.crabsdk.c.a.cj("result is empty!");
                        } else if (str == null || !str.equals("500")) {
                            int i = -100;
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("errno")) {
                                    i = ((Integer) jSONObject.get("errno")).intValue();
                                } else if (jSONObject.has("errNo")) {
                                    i = ((Integer) jSONObject.get("errNo")).intValue();
                                }
                                com.baidu.crabsdk.c.a.ch("###--> errno = " + i);
                                switch (i) {
                                    case -1:
                                        h.i(str2);
                                        h.V();
                                        break;
                                    case 0:
                                        i.deleteFile(str2);
                                        h.n(cw(str2));
                                        h.p("key_" + cw(str2));
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
                                            h.n(cw(str2));
                                            h.p("key_" + cw(str2));
                                            break;
                                        } catch (Exception e) {
                                            com.baidu.crabsdk.c.a.w("handle crash result days json error, exception is " + e);
                                            h.a(1);
                                            i.deleteFile(str2);
                                            h.n(cw(str2));
                                            h.p("key_" + cw(str2));
                                            e.printStackTrace();
                                            break;
                                        }
                                    case 10:
                                    case 15:
                                        i.deleteFile(str2);
                                        h.n(cw(str2));
                                        h.p("key_" + cw(str2));
                                        h.j(str2);
                                        h.V();
                                        break;
                                    default:
                                        i.deleteFile(str2);
                                        h.n(cw(str2));
                                        h.p("key_" + cw(str2));
                                        h.j(str2);
                                        break;
                                }
                            } catch (Exception e2) {
                                h.i(str2);
                                com.baidu.crabsdk.c.a.w("handle crash result json error, exception is " + e2);
                                e2.printStackTrace();
                            }
                        } else {
                            com.baidu.crabsdk.c.a.cj("not connected to server!");
                        }
                        f.aaH = true;
                    } else {
                        i.deleteFile(str2);
                        h.j(str2);
                    }
                }
            }
        }
    }
}
