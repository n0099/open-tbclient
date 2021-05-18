package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.OnUploadFilesCallback;
import com.baidu.crabsdk.b.o;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.a.m.d.e;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4777a;

    /* renamed from: b  reason: collision with root package name */
    public static final ScheduledThreadPoolExecutor f4778b = new ScheduledThreadPoolExecutor(1);

    /* renamed from: c  reason: collision with root package name */
    public static final ScheduledThreadPoolExecutor f4779c = new ScheduledThreadPoolExecutor(1);

    public static void a(Context context, Throwable th) {
        f4778b.execute(new d.a.m.d.c(th, context));
    }

    public static synchronized void b(boolean z, Context context) {
        synchronized (k.class) {
            d.a.m.d.f fVar = new d.a.m.d.f(context);
            if (!z) {
                f4778b.execute(fVar);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - g(context, "time_upload_crash");
            com.baidu.crabsdk.c.a.c("uploadCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
            if (currentTimeMillis < 10000) {
                f4778b.schedule(fVar, 10L, TimeUnit.SECONDS);
            } else {
                f4778b.execute(fVar);
            }
            f(context, "time_upload_crash");
        }
    }

    public static void c(byte[] bArr, String str) {
        String a2 = j.a(bArr, "Block", str);
        com.baidu.crabsdk.c.a.b("HttpSender.uploadBlock.result: " + a2);
    }

    public static Future d(String str, OnUploadFilesCallback onUploadFilesCallback, String str2, String str3, String str4) {
        return f4779c.submit(new e(onUploadFilesCallback, str, str2, str3, str4));
    }

    public static void e(Context context, Throwable th) {
        f4778b.execute(new d.a.m.d.d(context, th));
    }

    public static void f(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (f4777a == null && context != null) {
                f4777a = context.getSharedPreferences("last_init_crab", 4);
            }
            if (f4777a != null) {
                f4777a.edit().putLong(str, System.currentTimeMillis()).commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.crabsdk.c.a.c("setLastInitTime cost time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static long g(Context context, String str) {
        try {
            if (f4777a == null && context != null) {
                f4777a = context.getSharedPreferences("last_init_crab", 4);
            }
            if (f4777a != null) {
                return f4777a.getLong(str, 0L);
            }
            return 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static void h(Context context) {
        d.a.m.d.b bVar = new d.a.m.d.b(context);
        long currentTimeMillis = System.currentTimeMillis() - g(context, "time_upload_native");
        com.baidu.crabsdk.c.a.c("uploadNativeCrash 距离初始化上次上传的间隔是：" + currentTimeMillis);
        int i2 = (currentTimeMillis > 10000L ? 1 : (currentTimeMillis == 10000L ? 0 : -1));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = f4778b;
        if (i2 < 0) {
            scheduledThreadPoolExecutor.schedule(bVar, 10L, TimeUnit.SECONDS);
        } else {
            scheduledThreadPoolExecutor.execute(bVar);
        }
        f(context, "time_upload_native");
    }

    public static synchronized void i(Context context) {
        synchronized (k.class) {
            if (i.a(context, "dmp", true).size() == 0) {
                com.baidu.crabsdk.c.a.e("No Native Crash files!!");
                return;
            }
            String b2 = o.b();
            if (!"NONE".equals(b2) && !RomUtils.UNKNOWN.equals(b2)) {
                if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.c("upload native immediately!");
                    j(context);
                    return;
                } else if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(b2)) {
                    j(context);
                    return;
                } else {
                    return;
                }
            }
            com.baidu.crabsdk.c.a.c("network is not available!");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:26|(1:28)(1:150)|29|30|(10:144|145|33|(3:37|38|39)|44|45|(19:50|(2:52|(17:56|57|(2:59|(14:65|66|(2:68|(10:74|(1:76)|(1:78)|(1:80)|(1:82)|83|(1:134)(12:87|88|89|90|91|92|93|94|(1:96)(1:(7:104|105|106|(1:108)(3:114|(1:116)|117)|109|(2:111|112)(1:113)|99)(1:103))|97|98|99)|121|122|99))|135|(0)|(0)|(0)|(0)|83|(1:85)|134|121|122|99))|136|66|(0)|135|(0)|(0)|(0)|(0)|83|(0)|134|121|122|99))(1:138)|137|57|(0)|136|66|(0)|135|(0)|(0)|(0)|(0)|83|(0)|134|121|122|99)|139|140|99)|32|33|(4:35|37|38|39)|44|45|(20:47|50|(0)(0)|137|57|(0)|136|66|(0)|135|(0)|(0)|(0)|(0)|83|(0)|134|121|122|99)|139|140|99|24) */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0207, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0208, code lost:
        com.baidu.crabsdk.c.a.a("Create uploadDumpData error!", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011a A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013f A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015c A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a4 A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01dc A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e9 A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f0 A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f7 A[Catch: Exception -> 0x0207, all -> 0x0323, TryCatch #6 {Exception -> 0x0207, blocks: (B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:56:0x013f, B:87:0x01ff), top: B:147:0x00f4, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020f A[Catch: all -> 0x0323, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0011, B:7:0x0015, B:9:0x001b, B:11:0x0029, B:13:0x004c, B:15:0x0059, B:18:0x0060, B:19:0x0077, B:21:0x007d, B:23:0x009d, B:25:0x00aa, B:28:0x00c3, B:36:0x00d4, B:38:0x00dc, B:39:0x00e4, B:43:0x00eb, B:44:0x00f4, B:46:0x00fa, B:49:0x00ff, B:51:0x011a, B:53:0x0136, B:55:0x0139, B:58:0x0145, B:60:0x015c, B:62:0x0178, B:64:0x017b, B:66:0x0186, B:68:0x018d, B:70:0x01a4, B:72:0x01c0, B:74:0x01c3, B:76:0x01ce, B:79:0x01dc, B:81:0x01e9, B:83:0x01f0, B:85:0x01f7, B:86:0x01fa, B:92:0x020f, B:95:0x0217, B:96:0x021b, B:97:0x0235, B:98:0x0239, B:99:0x023d, B:102:0x0260, B:104:0x0266, B:109:0x0273, B:111:0x0280, B:116:0x02a2, B:118:0x02b6, B:112:0x028d, B:114:0x0295, B:120:0x02f8, B:121:0x0306, B:124:0x030f, B:56:0x013f, B:87:0x01ff, B:90:0x0208, B:32:0x00ca, B:12:0x0047), top: B:136:0x0005, inners: #3, #4, #5, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void j(Context context) {
        String str;
        String str2;
        long parseLong;
        String str3;
        Exception exc;
        String str4;
        String b2;
        String str5;
        byte[] l;
        String encodeToString;
        String str6;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String c2;
        String c3;
        synchronized (k.class) {
            List<String> i2 = i.i(context, "pid_");
            if (i2.size() > 0) {
                for (String str7 : i2) {
                    if (str7.endsWith(".ydg")) {
                        com.baidu.crabsdk.c.a.b("Deleting " + str7 + " " + i.j(str7));
                    }
                }
            } else {
                com.baidu.crabsdk.c.a.b("There is no .ydg files.");
            }
            char c4 = 1;
            List<String> a2 = i.a(context, ".dmp", true);
            if (a2.size() == 0) {
                com.baidu.crabsdk.c.a.d("Native file is empty!");
                return;
            }
            List<String> a3 = i.a(context, ".crab", false);
            List<String> a4 = i.a(context, ".logcat", false);
            List<String> a5 = i.a(context, ".ldg", false);
            for (String str8 : a2) {
                com.baidu.crabsdk.c.a.b("Absolute native file path@lastModifiedTime: " + str8);
                String str9 = null;
                if (str8.contains("@")) {
                    String[] split = str8.split("@");
                    str = split[0];
                    str2 = split[c4];
                } else {
                    str = str8;
                    str2 = null;
                }
                String p = p(str);
                com.baidu.crabsdk.c.a.b("Native fileNameOnly: " + p);
                if (str2 != null) {
                    try {
                        parseLong = Long.parseLong(str2);
                    } catch (Exception e2) {
                        com.baidu.crabsdk.c.a.a("Java:lastModifiedTime parse error!", e2);
                    }
                    if (parseLong == 0 && p.contains("_")) {
                        try {
                            parseLong = Long.parseLong(p.split("_")[c4]);
                        } catch (Exception e3) {
                            parseLong = System.currentTimeMillis();
                            com.baidu.crabsdk.c.a.a("C:dump time parse error!", e3);
                        }
                    }
                    l = i.l(str);
                    if (l != null && l.length != 0) {
                        encodeToString = Base64.encodeToString(l, 0);
                        if (a4.contains(str + ".logcat")) {
                            com.baidu.crabsdk.c.a.c("Not found .logcat files.");
                        } else {
                            com.baidu.crabsdk.c.a.c("Found .logcat files relative with dump files.");
                            byte[] l2 = i.l(str + ".logcat");
                            if (l2 != null && l2.length > 0) {
                                str6 = new String(l2);
                                if (a5.contains(str + ".ldg")) {
                                    com.baidu.crabsdk.c.a.c("Found .ldg files relative with dump files.");
                                    byte[] l3 = i.l(str + ".ldg");
                                    if (l3 != null && l3.length > 0 && (c3 = com.baidu.crabsdk.c.d.c(new String(l3))) != null) {
                                        jSONObject = new JSONObject(c3);
                                        if (a3.contains(str + ".crab")) {
                                            com.baidu.crabsdk.c.a.c("Found .crab files relative with dump files.");
                                            byte[] l4 = i.l(str + ".crab");
                                            if (l4 != null && l4.length > 0 && (c2 = com.baidu.crabsdk.c.d.c(new String(l4))) != null) {
                                                jSONObject2 = new JSONObject(c2);
                                                jSONObject2.put("phoneTime", parseLong);
                                                if (jSONObject2 == null) {
                                                    jSONObject2 = g.j(context);
                                                    com.baidu.crabsdk.c.c.b(jSONObject2, g.g(parseLong, false));
                                                }
                                                if (encodeToString != null) {
                                                    jSONObject2.put("dump", encodeToString);
                                                }
                                                if (str6 != null) {
                                                    jSONObject2.put("logcat", str6);
                                                }
                                                if (jSONObject != null) {
                                                    com.baidu.crabsdk.c.c.b(jSONObject2, jSONObject);
                                                }
                                                str9 = jSONObject2.toString();
                                                if (str9 != null || str9.length() == 0) {
                                                    str3 = "Error, uploadDumpData is invalid!";
                                                } else {
                                                    try {
                                                        byte[] j = com.baidu.crabsdk.c.c.j(str9);
                                                        String h2 = com.baidu.crabsdk.c.d.h(com.baidu.crabsdk.a.f4636d, UUID.randomUUID().toString());
                                                        try {
                                                            byte[] g2 = com.baidu.crabsdk.c.d.g(j, h2);
                                                            try {
                                                                String a6 = com.baidu.crabsdk.c.e.a(h2);
                                                                String d2 = com.baidu.crabsdk.a.d();
                                                                com.baidu.crabsdk.c.a.b("sendNativeRecord postUrl:" + d2);
                                                                b2 = r.b(d2, g2, "NDK", a6);
                                                            } catch (Exception e4) {
                                                                exc = e4;
                                                                str4 = "RSAUtils.encryptIntoBase64 Error!!";
                                                                com.baidu.crabsdk.c.a.a(str4, exc);
                                                                c4 = 1;
                                                            }
                                                        } catch (Exception e5) {
                                                            exc = e5;
                                                            str4 = "UploadLog Encrypt Error!!";
                                                        }
                                                    } catch (Exception e6) {
                                                        exc = e6;
                                                        str4 = "UploadLog Compress Error!";
                                                    }
                                                    if (TextUtils.isEmpty(b2)) {
                                                        str5 = "result is empty!";
                                                    } else if (b2 == null || !b2.equals("N/A")) {
                                                        try {
                                                            JSONObject jSONObject3 = new JSONObject(b2);
                                                            int intValue = jSONObject3.has("errno") ? ((Integer) jSONObject3.get("errno")).intValue() : jSONObject3.has("errNo") ? ((Integer) jSONObject3.get("errNo")).intValue() : -100;
                                                            com.baidu.crabsdk.c.a.b("###--> native errno = " + intValue);
                                                            if (intValue != -1) {
                                                                i.j(str);
                                                                i.j(str + ".crab");
                                                                i.j(str + ".logcat");
                                                                i.j(str + ".ldg");
                                                            }
                                                        } catch (Exception e7) {
                                                            str3 = "handle crash result json error, exception is " + e7;
                                                        }
                                                        c4 = 1;
                                                    } else {
                                                        str5 = "not connected to server!";
                                                    }
                                                    com.baidu.crabsdk.c.a.e(str5);
                                                    c4 = 1;
                                                }
                                                com.baidu.crabsdk.c.a.d(str3);
                                                c4 = 1;
                                            }
                                        }
                                        jSONObject2 = null;
                                        if (jSONObject2 == null) {
                                        }
                                        if (encodeToString != null) {
                                        }
                                        if (str6 != null) {
                                        }
                                        if (jSONObject != null) {
                                        }
                                        str9 = jSONObject2.toString();
                                        if (str9 != null) {
                                        }
                                        str3 = "Error, uploadDumpData is invalid!";
                                        com.baidu.crabsdk.c.a.d(str3);
                                        c4 = 1;
                                    }
                                }
                                jSONObject = null;
                                if (a3.contains(str + ".crab")) {
                                }
                                jSONObject2 = null;
                                if (jSONObject2 == null) {
                                }
                                if (encodeToString != null) {
                                }
                                if (str6 != null) {
                                }
                                if (jSONObject != null) {
                                }
                                str9 = jSONObject2.toString();
                                if (str9 != null) {
                                }
                                str3 = "Error, uploadDumpData is invalid!";
                                com.baidu.crabsdk.c.a.d(str3);
                                c4 = 1;
                            }
                        }
                        str6 = null;
                        if (a5.contains(str + ".ldg")) {
                        }
                        jSONObject = null;
                        if (a3.contains(str + ".crab")) {
                        }
                        jSONObject2 = null;
                        if (jSONObject2 == null) {
                        }
                        if (encodeToString != null) {
                        }
                        if (str6 != null) {
                        }
                        if (jSONObject != null) {
                        }
                        str9 = jSONObject2.toString();
                        if (str9 != null) {
                        }
                        str3 = "Error, uploadDumpData is invalid!";
                        com.baidu.crabsdk.c.a.d(str3);
                        c4 = 1;
                    }
                    com.baidu.crabsdk.c.a.d("Read dump file error!");
                    c4 = 1;
                }
                parseLong = 0;
                if (parseLong == 0) {
                    parseLong = Long.parseLong(p.split("_")[c4]);
                }
                l = i.l(str);
                if (l != null) {
                    encodeToString = Base64.encodeToString(l, 0);
                    if (a4.contains(str + ".logcat")) {
                    }
                    str6 = null;
                    if (a5.contains(str + ".ldg")) {
                    }
                    jSONObject = null;
                    if (a3.contains(str + ".crab")) {
                    }
                    jSONObject2 = null;
                    if (jSONObject2 == null) {
                    }
                    if (encodeToString != null) {
                    }
                    if (str6 != null) {
                    }
                    if (jSONObject != null) {
                    }
                    str9 = jSONObject2.toString();
                    if (str9 != null) {
                    }
                    str3 = "Error, uploadDumpData is invalid!";
                    com.baidu.crabsdk.c.a.d(str3);
                    c4 = 1;
                }
                com.baidu.crabsdk.c.a.d("Read dump file error!");
                c4 = 1;
            }
        }
    }

    public static void k(Context context) {
        f4778b.execute(new d.a.m.d.g(context));
    }

    public static synchronized void l(Context context) {
        synchronized (k.class) {
            if (i.k(context).size() == 0) {
                return;
            }
            String b2 = o.b();
            if (!"NONE".equals(b2) && !RomUtils.UNKNOWN.equals(b2)) {
                if (com.baidu.crabsdk.a.p) {
                    com.baidu.crabsdk.c.a.c("upload immediately!");
                    h.c(0L);
                    m(context);
                    return;
                } else if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(b2)) {
                    h.c(0L);
                    m(context);
                    return;
                } else if (com.baidu.crabsdk.a.r) {
                    com.baidu.crabsdk.c.a.c("network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                    return;
                } else if (!"MOBILE".equals(b2) || !h.f()) {
                    com.baidu.crabsdk.c.a.c("network is not wifi!");
                    return;
                } else {
                    com.baidu.crabsdk.c.a.c("upload without wifi!");
                    h.c(0L);
                    m(context);
                    return;
                }
            }
            com.baidu.crabsdk.c.a.c("network is not available!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0103 A[Catch: all -> 0x0262, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:7:0x0011, B:9:0x0017, B:11:0x0038, B:12:0x003f, B:14:0x005d, B:15:0x007e, B:25:0x00eb, B:27:0x0103, B:28:0x0108, B:67:0x025c, B:30:0x010f, B:35:0x011c, B:37:0x0129, B:38:0x0131, B:43:0x0147, B:51:0x0167, B:52:0x018b, B:53:0x01ad, B:55:0x01b2, B:58:0x01c1, B:61:0x01e6, B:62:0x0219, B:63:0x021d, B:64:0x0241, B:39:0x0136, B:41:0x013e, B:66:0x0247, B:16:0x0082, B:18:0x008a, B:19:0x00ac, B:21:0x00b4, B:22:0x00d6, B:24:0x00de), top: B:74:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0241 A[Catch: all -> 0x0262, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:7:0x0011, B:9:0x0017, B:11:0x0038, B:12:0x003f, B:14:0x005d, B:15:0x007e, B:25:0x00eb, B:27:0x0103, B:28:0x0108, B:67:0x025c, B:30:0x010f, B:35:0x011c, B:37:0x0129, B:38:0x0131, B:43:0x0147, B:51:0x0167, B:52:0x018b, B:53:0x01ad, B:55:0x01b2, B:58:0x01c1, B:61:0x01e6, B:62:0x0219, B:63:0x021d, B:64:0x0241, B:39:0x0136, B:41:0x013e, B:66:0x0247, B:16:0x0082, B:18:0x008a, B:19:0x00ac, B:21:0x00b4, B:22:0x00d6, B:24:0x00de), top: B:74:0x0003, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void m(Context context) {
        String str;
        JSONObject jSONObject;
        Integer num;
        String str2;
        synchronized (k.class) {
            List<String> k = i.k(context);
            if (k.size() != 0) {
                for (String str3 : k) {
                    com.baidu.crabsdk.c.a.c("(--#)  fileName when send  (--#)" + p(str3));
                    if (h.r(str3)) {
                        byte[] l = i.l(str3);
                        com.baidu.crabsdk.c.a.b("HttpSender.sendRecord: " + str3);
                        String str4 = null;
                        if (str3.contains("crab_crash_")) {
                            String p = p(str3);
                            String a2 = com.baidu.crabsdk.a.a();
                            com.baidu.crabsdk.c.a.b("sendCrashRecord postUrl:" + a2);
                            str4 = r.b(a2, l, "Crash", p);
                            str = "HttpSender.sendCrashRecord--->Crash";
                        } else if (str3.contains("crab_anr_")) {
                            String p2 = p(str3);
                            String b2 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.b("sendAnrRecord postUrl:" + b2);
                            str4 = r.b(b2, l, "Anr", p2);
                            str = "HttpSender.sendAnrRecord--->Anr";
                        } else if (str3.contains("crab_catched_")) {
                            String p3 = p(str3);
                            String b3 = com.baidu.crabsdk.a.b();
                            com.baidu.crabsdk.c.a.b("sendExceptionRecord postUrl:" + b3);
                            str4 = r.b(b3, l, "Exception", p3);
                            str = "HttpSender.sendExceptionRecord--->Exception";
                        } else {
                            if (str3.contains("crab_block_")) {
                                str4 = j.a(l, "Block", p(str3));
                                str = "HttpSender.sendExceptionRecord--->Block";
                            }
                            com.baidu.crabsdk.c.a.b("HttpSender.doUpload.result: " + str4);
                            if (!TextUtils.isEmpty(str4)) {
                                h.s(str3);
                                str2 = "result is empty!";
                            } else if (str4 == null || !str4.equals("N/A")) {
                                int i2 = -100;
                                try {
                                    jSONObject = new JSONObject(str4);
                                } catch (Exception e2) {
                                    e = e2;
                                    h.s(str3);
                                    com.baidu.crabsdk.c.a.d("handle crash result json error, exception is " + e);
                                }
                                if (jSONObject.has("errno")) {
                                    num = (Integer) jSONObject.get("errno");
                                } else {
                                    if (jSONObject.has("errNo")) {
                                        num = (Integer) jSONObject.get("errNo");
                                    }
                                    com.baidu.crabsdk.c.a.b("###--> errno = " + i2);
                                    if (i2 != -1) {
                                        h.s(str3);
                                    } else if (i2 != 0) {
                                        if (i2 == 1) {
                                            try {
                                                int intValue = ((Integer) jSONObject.get("days")).intValue();
                                                if (intValue <= 0) {
                                                    intValue = 1;
                                                }
                                                h.b(intValue);
                                                i.j(str3);
                                                h.x(p(str3));
                                                h.z("key_" + p(str3));
                                            } catch (Exception e3) {
                                                e = e3;
                                                com.baidu.crabsdk.c.a.d("handle crash result days json error, exception is " + e);
                                                h.b(1);
                                                i.j(str3);
                                                h.x(p(str3));
                                                h.z("key_" + p(str3));
                                                e.printStackTrace();
                                                f.f4770g = true;
                                            }
                                        } else if (i2 == 10 || i2 == 15) {
                                            i.j(str3);
                                            h.x(p(str3));
                                            h.z("key_" + p(str3));
                                            h.t(str3);
                                        } else {
                                            i.j(str3);
                                            h.x(p(str3));
                                            h.z("key_" + p(str3));
                                            h.t(str3);
                                        }
                                        f.f4770g = true;
                                    } else {
                                        i.j(str3);
                                        h.x(p(str3));
                                        h.z("key_" + p(str3));
                                        h.t(str3);
                                    }
                                    h.e();
                                    f.f4770g = true;
                                }
                                i2 = num.intValue();
                                com.baidu.crabsdk.c.a.b("###--> errno = " + i2);
                                if (i2 != -1) {
                                }
                                h.e();
                                f.f4770g = true;
                            } else {
                                str2 = "not connected to server!";
                            }
                            com.baidu.crabsdk.c.a.e(str2);
                            f.f4770g = true;
                        }
                        com.baidu.crabsdk.c.a.b(str);
                        com.baidu.crabsdk.c.a.b("HttpSender.doUpload.result: " + str4);
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        com.baidu.crabsdk.c.a.e(str2);
                        f.f4770g = true;
                    } else {
                        i.j(str3);
                        h.t(str3);
                    }
                }
            }
        }
    }

    public static String p(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }
}
