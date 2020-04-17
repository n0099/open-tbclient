package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.crabsdk.OnUploadFilesCallback;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class k {
    private static SharedPreferences akY = null;
    private static final ScheduledThreadPoolExecutor akZ = new ScheduledThreadPoolExecutor(1);
    private static final ScheduledThreadPoolExecutor ala = new ScheduledThreadPoolExecutor(1);

    private static long L(Context context, String str) {
        try {
            if (akY == null && context != null) {
                akY = context.getSharedPreferences("last_init_crab", 4);
            }
            if (akY != null) {
                return akY.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void a(Context context, Throwable th) {
        akZ.execute(new m(th, context));
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (k.class) {
            p pVar = new p(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis() - L(context, "time_upload_crash");
                com.baidu.crabsdk.c.a.v("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
                if (currentTimeMillis < 10000) {
                    akZ.schedule(pVar, 10L, TimeUnit.SECONDS);
                } else {
                    akZ.execute(pVar);
                }
                e(context, "time_upload_crash");
            } else {
                akZ.execute(pVar);
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        com.baidu.crabsdk.c.a.de("HttpSender.uploadBlock.result: " + j.b(bArr, "Block", str));
    }

    public static Future b(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3, String str4) {
        return ala.submit(new o(onUploadFilesCallback, str, str2, str3, str4));
    }

    public static void c(Context context, Throwable th) {
        akZ.execute(new n(context, th));
    }

    private static String ds(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private static void e(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (akY == null && context != null) {
                akY = context.getSharedPreferences("last_init_crab", 4);
            }
            if (akY != null) {
                akY.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.c.a.v("setLastInitTime cost time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static void j(Context context) {
        l lVar = new l(context);
        long currentTimeMillis = System.currentTimeMillis() - L(context, "time_upload_native");
        com.baidu.crabsdk.c.a.v("uploadNativeCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
        if (currentTimeMillis < 10000) {
            akZ.schedule(lVar, 10L, TimeUnit.SECONDS);
        } else {
            akZ.execute(lVar);
        }
        e(context, "time_upload_native");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context) {
        synchronized (k.class) {
            if (i.d(context, "dmp", true).size() == 0) {
                com.baidu.crabsdk.c.a.df("No Native Crash files!!");
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
        com.baidu.crabsdk.c.a.f("Create uploadDumpData error!", r0);
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void l(Context context) {
        String str;
        String str2;
        long j;
        byte[] dq;
        String str3;
        String dk;
        String dk2;
        synchronized (k.class) {
            List<String> K = i.K(context, "pid_");
            if (K.size() > 0) {
                for (String str4 : K) {
                    if (str4.endsWith(".ydg")) {
                        com.baidu.crabsdk.c.a.de("Deleting " + str4 + " " + i.deleteFile(str4));
                    }
                }
            } else {
                com.baidu.crabsdk.c.a.de("There is no .ydg files.");
            }
            List<String> d = i.d(context, ".dmp", true);
            if (d.size() == 0) {
                com.baidu.crabsdk.c.a.w("Native file is empty!");
            } else {
                List<String> d2 = i.d(context, ".crab", false);
                List<String> d3 = i.d(context, ".logcat", false);
                List<String> d4 = i.d(context, ".ldg", false);
                for (String str5 : d) {
                    com.baidu.crabsdk.c.a.de("Absolute native file path@lastModifiedTime: " + str5);
                    if (str5.contains(UgcConstant.AT_RULE_TAG)) {
                        String[] split = str5.split(UgcConstant.AT_RULE_TAG);
                        String str6 = split[0];
                        str = split[1];
                        str2 = str6;
                    } else {
                        str = null;
                        str2 = str5;
                    }
                    String ds = ds(str2);
                    com.baidu.crabsdk.c.a.de("Native fileNameOnly: " + ds);
                    long j2 = 0;
                    if (str != null) {
                        try {
                            j2 = Long.parseLong(str);
                        } catch (Exception e) {
                            j2 = 0;
                            com.baidu.crabsdk.c.a.f("Java:lastModifiedTime parse error!", e);
                        }
                    }
                    if (j2 == 0 && ds.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                        try {
                            j = Long.parseLong(ds.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[1]);
                        } catch (Exception e2) {
                            j2 = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.f("C:dump time parse error!", e2);
                        }
                        dq = i.dq(str2);
                        if (dq != null || dq.length == 0) {
                            com.baidu.crabsdk.c.a.w("Read dump file error!");
                        } else {
                            String encodeToString = Base64.encodeToString(dq, 0);
                            String str7 = null;
                            if (d3.contains(str2 + ".logcat")) {
                                com.baidu.crabsdk.c.a.v("Found .logcat files relative with dump files.");
                                byte[] dq2 = i.dq(str2 + ".logcat");
                                if (dq2 != null && dq2.length > 0) {
                                    str7 = new String(dq2);
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
                                byte[] dq3 = i.dq(str2 + ".ldg");
                                if (dq3 != null && dq3.length > 0 && (dk2 = com.baidu.crabsdk.c.d.dk(new String(dq3))) != null) {
                                    jSONObject2 = new JSONObject(dk2);
                                }
                            }
                            if (d2.contains(str2 + ".crab")) {
                                com.baidu.crabsdk.c.a.v("Found .crab files relative with dump files.");
                                byte[] dq4 = i.dq(str2 + ".crab");
                                if (dq4 != null && dq4.length > 0 && (dk = com.baidu.crabsdk.c.d.dk(new String(dq4))) != null) {
                                    jSONObject = new JSONObject(dk);
                                    jSONObject.put("phoneTime", j);
                                }
                            }
                            if (jSONObject == null) {
                                jSONObject = g.h(context);
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
                                    byte[] dh = com.baidu.crabsdk.c.c.dh(str8);
                                    String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                                    try {
                                        byte[] b = com.baidu.crabsdk.c.d.b(dh, c);
                                        try {
                                            String dl = com.baidu.crabsdk.c.e.dl(c);
                                            String d5 = com.baidu.crabsdk.a.d();
                                            com.baidu.crabsdk.c.a.de("sendNativeRecord postUrl:" + d5);
                                            String a = r.a(d5, b, "NDK", dl);
                                            if (TextUtils.isEmpty(a)) {
                                                com.baidu.crabsdk.c.a.df("result is empty!");
                                            } else if (a == null || !a.equals("N/A")) {
                                                int i = -100;
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject(a);
                                                    if (jSONObject3.has(BaseJsonData.TAG_ERRNO)) {
                                                        i = ((Integer) jSONObject3.get(BaseJsonData.TAG_ERRNO)).intValue();
                                                    } else if (jSONObject3.has("errNo")) {
                                                        i = ((Integer) jSONObject3.get("errNo")).intValue();
                                                    }
                                                    com.baidu.crabsdk.c.a.de("###--> native errno = " + i);
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
                                                com.baidu.crabsdk.c.a.df("not connected to server!");
                                            }
                                        } catch (Exception e4) {
                                            com.baidu.crabsdk.c.a.f("RSAUtils.encryptIntoBase64 Error!!", e4);
                                        }
                                    } catch (Exception e5) {
                                        com.baidu.crabsdk.c.a.f("UploadLog Encrypt Error!!", e5);
                                    }
                                } catch (Exception e6) {
                                    com.baidu.crabsdk.c.a.f("UploadLog Compress Error!", e6);
                                }
                            }
                        }
                    }
                    j = j2;
                    dq = i.dq(str2);
                    if (dq != null) {
                    }
                    com.baidu.crabsdk.c.a.w("Read dump file error!");
                }
            }
        }
    }

    public static void m(Context context) {
        akZ.execute(new q(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void n(Context context) {
        synchronized (k.class) {
            if (i.aj(context).size() != 0) {
                String I = com.baidu.crabsdk.b.o.I();
                if ("NONE".equals(I) || RomUtils.UNKNOWN.equals(I)) {
                    com.baidu.crabsdk.c.a.v("network is not available!");
                } else if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.v("upload immediately!");
                    h.a(0L);
                    o(context);
                } else if ("WIFI".equals(I)) {
                    h.a(0L);
                    o(context);
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.v("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                } else if ("MOBILE".equals(I) && h.sT()) {
                    com.baidu.crabsdk.c.a.v("upload without wifi!");
                    h.a(0L);
                    o(context);
                } else {
                    com.baidu.crabsdk.c.a.v("network is not wifi!");
                }
            }
        }
    }

    private static synchronized void o(Context context) {
        String str;
        synchronized (k.class) {
            List<String> aj = i.aj(context);
            if (aj.size() != 0) {
                for (String str2 : aj) {
                    com.baidu.crabsdk.c.a.v("(--#)  fileName when send  (--#)" + ds(str2));
                    if (h.dn(str2)) {
                        byte[] dq = i.dq(str2);
                        com.baidu.crabsdk.c.a.de("HttpSender.sendRecord: " + str2);
                        if (str2.contains("crab_crash_")) {
                            String ds = ds(str2);
                            String a = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.de("sendCrashRecord postUrl:" + a);
                            String a2 = r.a(a, dq, "Crash", ds);
                            com.baidu.crabsdk.c.a.de("HttpSender.sendCrashRecord--->Crash");
                            str = a2;
                        } else if (str2.contains("crab_anr_")) {
                            String ds2 = ds(str2);
                            String b = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.de("sendAnrRecord postUrl:" + b);
                            String a3 = r.a(b, dq, "Anr", ds2);
                            com.baidu.crabsdk.c.a.de("HttpSender.sendAnrRecord--->Anr");
                            str = a3;
                        } else if (str2.contains("crab_catched_")) {
                            String ds3 = ds(str2);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.de("sendExceptionRecord postUrl:" + b2);
                            String a4 = r.a(b2, dq, "Exception", ds3);
                            com.baidu.crabsdk.c.a.de("HttpSender.sendExceptionRecord--->Exception");
                            str = a4;
                        } else if (str2.contains("crab_block_")) {
                            String b3 = j.b(dq, "Block", ds(str2));
                            com.baidu.crabsdk.c.a.de("HttpSender.sendExceptionRecord--->Block");
                            str = b3;
                        } else {
                            str = null;
                        }
                        com.baidu.crabsdk.c.a.de("HttpSender.doUpload.result: " + str);
                        if (TextUtils.isEmpty(str)) {
                            h.j(str2);
                            com.baidu.crabsdk.c.a.df("result is empty!");
                        } else if (str == null || !str.equals("N/A")) {
                            int i = -100;
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has(BaseJsonData.TAG_ERRNO)) {
                                    i = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                                } else if (jSONObject.has("errNo")) {
                                    i = ((Integer) jSONObject.get("errNo")).intValue();
                                }
                                com.baidu.crabsdk.c.a.de("###--> errno = " + i);
                                switch (i) {
                                    case -1:
                                        h.j(str2);
                                        h.aa();
                                        break;
                                    case 0:
                                        i.deleteFile(str2);
                                        h.o(ds(str2));
                                        h.q("key_" + ds(str2));
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
                                            h.o(ds(str2));
                                            h.q("key_" + ds(str2));
                                            break;
                                        } catch (Exception e) {
                                            com.baidu.crabsdk.c.a.w("handle crash result days json error, exception is " + e);
                                            h.a(1);
                                            i.deleteFile(str2);
                                            h.o(ds(str2));
                                            h.q("key_" + ds(str2));
                                            e.printStackTrace();
                                            break;
                                        }
                                    case 10:
                                    case 15:
                                        i.deleteFile(str2);
                                        h.o(ds(str2));
                                        h.q("key_" + ds(str2));
                                        h.k(str2);
                                        h.aa();
                                        break;
                                    default:
                                        i.deleteFile(str2);
                                        h.o(ds(str2));
                                        h.q("key_" + ds(str2));
                                        h.k(str2);
                                        break;
                                }
                            } catch (Exception e2) {
                                h.j(str2);
                                com.baidu.crabsdk.c.a.w("handle crash result json error, exception is " + e2);
                                e2.printStackTrace();
                            }
                        } else {
                            com.baidu.crabsdk.c.a.df("not connected to server!");
                        }
                        f.akT = true;
                    } else {
                        i.deleteFile(str2);
                        h.k(str2);
                    }
                }
            }
        }
    }
}
