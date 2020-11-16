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
/* loaded from: classes7.dex */
public final class k {
    private static SharedPreferences aqo = null;
    private static final ScheduledThreadPoolExecutor aqp = new ScheduledThreadPoolExecutor(1);
    private static final ScheduledThreadPoolExecutor aqq = new ScheduledThreadPoolExecutor(1);

    private static long B(Context context, String str) {
        try {
            if (aqo == null && context != null) {
                aqo = context.getSharedPreferences("last_init_crab", 4);
            }
            if (aqo != null) {
                return aqo.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void a(Context context, Throwable th) {
        aqp.execute(new m(th, context));
    }

    public static synchronized void a(boolean z, Context context) {
        synchronized (k.class) {
            p pVar = new p(context);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis() - B(context, "time_upload_crash");
                com.baidu.crabsdk.c.a.v("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
                if (currentTimeMillis < 10000) {
                    aqp.schedule(pVar, 10L, TimeUnit.SECONDS);
                } else {
                    aqp.execute(pVar);
                }
                e(context, "time_upload_crash");
            } else {
                aqp.execute(pVar);
            }
        }
    }

    public static void a(byte[] bArr, String str) {
        com.baidu.crabsdk.c.a.dC("HttpSender.uploadBlock.result: " + j.b(bArr, "Block", str));
    }

    public static void ag(Context context) {
        aqp.execute(new q(context));
    }

    public static Future b(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3, String str4) {
        return aqq.submit(new o(onUploadFilesCallback, str, str2, str3, str4));
    }

    public static void b(Context context, Throwable th) {
        aqp.execute(new n(context, th));
    }

    private static String dY(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private static void e(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (aqo == null && context != null) {
                aqo = context.getSharedPreferences("last_init_crab", 4);
            }
            if (aqo != null) {
                aqo.edit().putLong(str, System.currentTimeMillis()).commit();
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
            aqp.schedule(lVar, 10L, TimeUnit.SECONDS);
        } else {
            aqp.execute(lVar);
        }
        e(context, "time_upload_native");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context) {
        synchronized (k.class) {
            if (i.d(context, "dmp", true).size() == 0) {
                com.baidu.crabsdk.c.a.dD("No Native Crash files!!");
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
        byte[] ei;
        String str3;
        String dI;
        String dI2;
        synchronized (k.class) {
            List<String> A = i.A(context, "pid_");
            if (A.size() > 0) {
                for (String str4 : A) {
                    if (str4.endsWith(".ydg")) {
                        com.baidu.crabsdk.c.a.dC("Deleting " + str4 + " " + i.deleteFile(str4));
                    }
                }
            } else {
                com.baidu.crabsdk.c.a.dC("There is no .ydg files.");
            }
            List<String> d = i.d(context, ".dmp", true);
            if (d.size() == 0) {
                com.baidu.crabsdk.c.a.w("Native file is empty!");
            } else {
                List<String> d2 = i.d(context, ".crab", false);
                List<String> d3 = i.d(context, ".logcat", false);
                List<String> d4 = i.d(context, ".ldg", false);
                for (String str5 : d) {
                    com.baidu.crabsdk.c.a.dC("Absolute native file path@lastModifiedTime: " + str5);
                    if (str5.contains(UgcConstant.AT_RULE_TAG)) {
                        String[] split = str5.split(UgcConstant.AT_RULE_TAG);
                        String str6 = split[0];
                        str = split[1];
                        str2 = str6;
                    } else {
                        str = null;
                        str2 = str5;
                    }
                    String dY = dY(str2);
                    com.baidu.crabsdk.c.a.dC("Native fileNameOnly: " + dY);
                    long j2 = 0;
                    if (str != null) {
                        try {
                            j2 = Long.parseLong(str);
                        } catch (Exception e) {
                            j2 = 0;
                            com.baidu.crabsdk.c.a.a("Java:lastModifiedTime parse error!", e);
                        }
                    }
                    if (j2 == 0 && dY.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                        try {
                            j = Long.parseLong(dY.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[1]);
                        } catch (Exception e2) {
                            j2 = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.a("C:dump time parse error!", e2);
                        }
                        ei = i.ei(str2);
                        if (ei != null || ei.length == 0) {
                            com.baidu.crabsdk.c.a.w("Read dump file error!");
                        } else {
                            String encodeToString = Base64.encodeToString(ei, 0);
                            String str7 = null;
                            if (d3.contains(str2 + ".logcat")) {
                                com.baidu.crabsdk.c.a.v("Found .logcat files relative with dump files.");
                                byte[] ei2 = i.ei(str2 + ".logcat");
                                if (ei2 != null && ei2.length > 0) {
                                    str7 = new String(ei2);
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
                                byte[] ei3 = i.ei(str2 + ".ldg");
                                if (ei3 != null && ei3.length > 0 && (dI2 = com.baidu.crabsdk.c.d.dI(new String(ei3))) != null) {
                                    jSONObject2 = new JSONObject(dI2);
                                }
                            }
                            if (d2.contains(str2 + ".crab")) {
                                com.baidu.crabsdk.c.a.v("Found .crab files relative with dump files.");
                                byte[] ei4 = i.ei(str2 + ".crab");
                                if (ei4 != null && ei4.length > 0 && (dI = com.baidu.crabsdk.c.d.dI(new String(ei4))) != null) {
                                    jSONObject = new JSONObject(dI);
                                    jSONObject.put("phoneTime", j);
                                }
                            }
                            if (jSONObject == null) {
                                jSONObject = g.af(context);
                                com.baidu.crabsdk.c.c.a(jSONObject, g.a(j, false));
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
                                    byte[] dF = com.baidu.crabsdk.c.c.dF(str8);
                                    String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
                                    try {
                                        byte[] b = com.baidu.crabsdk.c.d.b(dF, c);
                                        try {
                                            String dJ = com.baidu.crabsdk.c.e.dJ(c);
                                            String d5 = com.baidu.crabsdk.a.d();
                                            com.baidu.crabsdk.c.a.dC("sendNativeRecord postUrl:" + d5);
                                            String a2 = r.a(d5, b, "NDK", dJ);
                                            if (TextUtils.isEmpty(a2)) {
                                                com.baidu.crabsdk.c.a.dD("result is empty!");
                                            } else if (a2 == null || !a2.equals("N/A")) {
                                                int i = -100;
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject(a2);
                                                    if (jSONObject3.has(BaseJsonData.TAG_ERRNO)) {
                                                        i = ((Integer) jSONObject3.get(BaseJsonData.TAG_ERRNO)).intValue();
                                                    } else if (jSONObject3.has("errNo")) {
                                                        i = ((Integer) jSONObject3.get("errNo")).intValue();
                                                    }
                                                    com.baidu.crabsdk.c.a.dC("###--> native errno = " + i);
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
                                                com.baidu.crabsdk.c.a.dD("not connected to server!");
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
                    ei = i.ei(str2);
                    if (ei != null) {
                    }
                    com.baidu.crabsdk.c.a.w("Read dump file error!");
                }
            }
        }
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
                    o(context);
                } else if ("WIFI".equals(I)) {
                    h.a(0L);
                    o(context);
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.v("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                } else if ("MOBILE".equals(I) && h.ab()) {
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
            List<String> i = i.i(context);
            if (i.size() != 0) {
                for (String str2 : i) {
                    com.baidu.crabsdk.c.a.v("(--#)  fileName when send  (--#)" + dY(str2));
                    if (h.eg(str2)) {
                        byte[] ei = i.ei(str2);
                        com.baidu.crabsdk.c.a.dC("HttpSender.sendRecord: " + str2);
                        if (str2.contains("crab_crash_")) {
                            String dY = dY(str2);
                            String a2 = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.dC("sendCrashRecord postUrl:" + a2);
                            String a3 = r.a(a2, ei, "Crash", dY);
                            com.baidu.crabsdk.c.a.dC("HttpSender.sendCrashRecord--->Crash");
                            str = a3;
                        } else if (str2.contains("crab_anr_")) {
                            String dY2 = dY(str2);
                            String b = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.dC("sendAnrRecord postUrl:" + b);
                            String a4 = r.a(b, ei, "Anr", dY2);
                            com.baidu.crabsdk.c.a.dC("HttpSender.sendAnrRecord--->Anr");
                            str = a4;
                        } else if (str2.contains("crab_catched_")) {
                            String dY3 = dY(str2);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.dC("sendExceptionRecord postUrl:" + b2);
                            String a5 = r.a(b2, ei, "Exception", dY3);
                            com.baidu.crabsdk.c.a.dC("HttpSender.sendExceptionRecord--->Exception");
                            str = a5;
                        } else if (str2.contains("crab_block_")) {
                            String b3 = j.b(ei, "Block", dY(str2));
                            com.baidu.crabsdk.c.a.dC("HttpSender.sendExceptionRecord--->Block");
                            str = b3;
                        } else {
                            str = null;
                        }
                        com.baidu.crabsdk.c.a.dC("HttpSender.doUpload.result: " + str);
                        if (TextUtils.isEmpty(str)) {
                            h.j(str2);
                            com.baidu.crabsdk.c.a.dD("result is empty!");
                        } else if (str == null || !str.equals("N/A")) {
                            int i2 = -100;
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has(BaseJsonData.TAG_ERRNO)) {
                                    i2 = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                                } else if (jSONObject.has("errNo")) {
                                    i2 = ((Integer) jSONObject.get("errNo")).intValue();
                                }
                                com.baidu.crabsdk.c.a.dC("###--> errno = " + i2);
                                switch (i2) {
                                    case -1:
                                        h.j(str2);
                                        h.aa();
                                        break;
                                    case 0:
                                        i.deleteFile(str2);
                                        h.o(dY(str2));
                                        h.q("key_" + dY(str2));
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
                                            h.o(dY(str2));
                                            h.q("key_" + dY(str2));
                                            break;
                                        } catch (Exception e) {
                                            com.baidu.crabsdk.c.a.w("handle crash result days json error, exception is " + e);
                                            h.a(1);
                                            i.deleteFile(str2);
                                            h.o(dY(str2));
                                            h.q("key_" + dY(str2));
                                            e.printStackTrace();
                                            break;
                                        }
                                    case 10:
                                    case 15:
                                        i.deleteFile(str2);
                                        h.o(dY(str2));
                                        h.q("key_" + dY(str2));
                                        h.k(str2);
                                        h.aa();
                                        break;
                                    default:
                                        i.deleteFile(str2);
                                        h.o(dY(str2));
                                        h.q("key_" + dY(str2));
                                        h.k(str2);
                                        break;
                                }
                            } catch (Exception e2) {
                                h.j(str2);
                                com.baidu.crabsdk.c.a.w("handle crash result json error, exception is " + e2);
                                e2.printStackTrace();
                            }
                        } else {
                            com.baidu.crabsdk.c.a.dD("not connected to server!");
                        }
                        f.aqj = true;
                    } else {
                        i.deleteFile(str2);
                        h.k(str2);
                    }
                }
            }
        }
    }
}
