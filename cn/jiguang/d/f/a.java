package cn.jiguang.d.f;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.e;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.i;
import cn.jiguang.d.h.f;
import cn.jiguang.d.h.h;
import cn.jpush.android.service.DownloadProvider;
import com.baidu.ar.audio.AudioParams;
import com.baidu.mobstat.Config;
import com.tencent.tauth.AuthActivity;
import java.io.File;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private static final String a = ".jpush" + File.separator + ".shareinfo" + File.separator;
    private static final Object e = new Object();
    private static Boolean f;
    private static Boolean g;
    private static a lH;
    private int b;
    private String d;
    private volatile boolean h;
    private long[] lG;

    private a() {
        e.F("share_process_executor");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (d(r2, r6) != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c J(Context context, String str) {
        c cVar;
        String str2;
        String str3;
        String str4;
        try {
            String a2 = a(context, str, "asai", null);
            if (a2 != null) {
                if (TextUtils.isEmpty(a2) || a2.length() <= 10) {
                    return null;
                }
                String b = cn.jiguang.d.h.a.a.b(a2, "");
                if (TextUtils.isEmpty(b)) {
                    return null;
                }
                return N(b);
            } else if (d(context)) {
                if (cn.jiguang.g.a.a(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                    String f2 = f.f(O(str));
                    if (!TextUtils.isEmpty(f2) && (cVar = N(cn.jiguang.d.h.a.a.b(f2, ""))) != null) {
                        str2 = cVar.e;
                        if (cn.jiguang.g.a.i(context, str2)) {
                            str4 = cVar.e;
                        } else {
                            str3 = cVar.e;
                            a(context, str3);
                        }
                    }
                }
                cVar = null;
                return cVar;
            } else {
                return null;
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("ShareProcessManager", "scanShareProcessBean error:" + th.getMessage());
            return null;
        }
    }

    private c N(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c(this);
            try {
                long optLong = jSONObject.optLong("u");
                String optString = jSONObject.optString("ak");
                String optString2 = jSONObject.optString(Config.PACKAGE_NAME);
                String optString3 = jSONObject.optString("ud");
                int optInt = jSONObject.optInt("idc", -1);
                int optInt2 = jSONObject.optInt("sv");
                long optLong2 = jSONObject.optLong("uct", -1L);
                cVar.d = optLong;
                cVar.c = optString3;
                cVar.f = optString;
                cVar.b = optInt;
                cVar.e = optString2;
                cVar.g = optInt2;
                cVar.h = optLong2;
                return cVar;
            } catch (Throwable th) {
                return cVar;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private static File O(String str) {
        String a2 = cn.jiguang.g.a.a(str);
        if (!TextUtils.isEmpty(a2)) {
            str = a2;
        }
        return new File(Environment.getExternalStorageDirectory(), a + str);
    }

    private static String a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            String str3 = str + ".DownloadProvider";
            if (!str3.startsWith("content://")) {
                str3 = "content://" + str3;
            }
            Uri parse = Uri.parse(str3);
            JSONObject jSONObject = new JSONObject();
            Uri.Builder buildUpon = parse.buildUpon();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("kta", str2);
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            buildUpon.appendQueryParameter("kpgt", cn.jiguang.d.h.a.a.a(jSONObject.toString()));
            return contentResolver.getType(buildUpon.build());
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("asm".equals(intent.getAction())) {
                    Bundle extras = intent.getExtras();
                    extras.putString(AuthActivity.ACTION_KEY, "asm");
                    e.b(context, cn.jiguang.d.a.a, extras);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (cn.jiguang.g.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                File O = O(str);
                if (O.exists()) {
                    O.delete();
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090 A[Catch: Throwable -> 0x00b3, TryCatch #0 {Throwable -> 0x00b3, blocks: (B:3:0x0006, B:5:0x001d, B:9:0x0025, B:10:0x002b, B:12:0x0031, B:14:0x0043, B:16:0x0049, B:18:0x0053, B:20:0x005b, B:22:0x005f, B:24:0x0065, B:26:0x0069, B:28:0x0071, B:32:0x0090, B:33:0x0093, B:35:0x0099, B:36:0x009d, B:38:0x00a3, B:40:0x00af), top: B:44:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<c> b(Context context) {
        List<ResolveInfo> queryIntentServices;
        boolean z;
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(e.bl());
            queryIntentServices = packageManager.queryIntentServices(intent, 0);
        } catch (Throwable th) {
        }
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            return arrayList;
        }
        ArrayList<String> arrayList2 = new ArrayList();
        for (int i = 0; i < queryIntentServices.size(); i++) {
            ServiceInfo serviceInfo = queryIntentServices.get(i).serviceInfo;
            String str = serviceInfo.name;
            String str2 = serviceInfo.packageName;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !context.getPackageName().equals(str2)) {
                ComponentInfo a2 = cn.jiguang.g.a.a(context, str2, DownloadProvider.class);
                if (a2 != null && (a2 instanceof ProviderInfo)) {
                    ProviderInfo providerInfo = (ProviderInfo) a2;
                    if (providerInfo.exported && providerInfo.enabled && !TextUtils.isEmpty(providerInfo.authority) && TextUtils.equals(str2 + ".DownloadProvider", providerInfo.authority)) {
                        z = true;
                        if (!z) {
                            arrayList2.add(str2);
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
        }
        for (String str3 : arrayList2) {
            c J = J(context, str3);
            if (J != null) {
                arrayList.add(J);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, Context context) {
        try {
            if (cn.jiguang.g.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                File O = O(context.getPackageName());
                if (!d(context)) {
                    if (O.exists()) {
                        O.delete();
                        return;
                    }
                    return;
                }
                String c = c(context);
                if (TextUtils.isEmpty(c) || c.length() <= 10) {
                    return;
                }
                if (O.exists()) {
                    O.delete();
                }
                f.b(O, c);
            }
        } catch (Throwable th) {
        }
    }

    public static a bO() {
        if (lH == null) {
            synchronized (e) {
                if (lH == null) {
                    lH = new a();
                }
            }
        }
        return lH;
    }

    private static String c(Context context) {
        if (context == null) {
            return "-1";
        }
        if (!e(context) || d.ae(context) == 1) {
            return "-4";
        }
        if (i.bG().f()) {
            int v = cn.jiguang.d.a.a.v();
            if (v < 0) {
                return "-3";
            }
            long c = d.c(context);
            if (c <= 0) {
                return "-2";
            }
            String r = d.r(context);
            long af = d.af(context);
            String b = cn.jiguang.d.a.b(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("u", c);
                jSONObject.put("p", d.e(context));
                jSONObject.put("ud", r);
                jSONObject.put("ak", b);
                jSONObject.put("idc", v);
                jSONObject.put(Config.PACKAGE_NAME, context.getPackageName());
                jSONObject.put("sv", 125);
                jSONObject.put("uct", af);
                return cn.jiguang.d.h.a.a.a(jSONObject.toString());
            } catch (JSONException e2) {
                return "1.2.5";
            }
        }
        return "-7";
    }

    private static ActivityInfo d(String str, Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DownloadActivity");
            intent.addCategory(str);
            intent.setPackage(str);
            ActivityInfo activityInfo = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
            if ((activityInfo instanceof ActivityInfo) && ((ComponentInfo) activityInfo).exported && ((ComponentInfo) activityInfo).enabled && "jpush.custom".equals(activityInfo.taskAffinity) && activityInfo.theme == 16973840) {
                return activityInfo;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static boolean d(Context context) {
        if (g != null) {
            return g.booleanValue();
        }
        try {
            String str = Build.MANUFACTURER;
            String lowerCase = "Xiaomi".toLowerCase();
            if (!TextUtils.isEmpty(str) && TextUtils.equals(lowerCase, str.toLowerCase())) {
                Boolean bool = false;
                g = bool;
                return bool.booleanValue();
            }
        } catch (Throwable th) {
        }
        if (d(context.getPackageName(), context) != null) {
            g = true;
        } else {
            g = false;
        }
        return g.booleanValue();
    }

    private static boolean e(Context context) {
        if (f != null) {
            return f.booleanValue();
        }
        if (context == null) {
            return true;
        }
        try {
            if (!cn.jiguang.g.a.a(context, e.bl(), true)) {
                Boolean bool = false;
                f = bool;
                return bool.booleanValue();
            }
            ComponentInfo a2 = cn.jiguang.g.a.a(context, context.getPackageName(), DownloadProvider.class);
            if (a2 == null) {
                Boolean bool2 = false;
                f = bool2;
                return bool2.booleanValue();
            } else if (!a2.enabled || !a2.exported || TextUtils.isEmpty(((ProviderInfo) a2).authority)) {
                Boolean bool3 = false;
                f = bool3;
                return bool3.booleanValue();
            } else {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("cn.jiguang.android.share.close");
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    f = true;
                } else {
                    f = false;
                }
                return f.booleanValue();
            }
        } catch (Throwable th) {
            return true;
        }
    }

    public final String a(Context context, Uri uri) {
        String queryParameter;
        if (uri == null) {
            return "1.2.5";
        }
        try {
            queryParameter = uri.getQueryParameter("kpgt");
        } catch (Throwable th) {
        }
        if (TextUtils.isEmpty(queryParameter)) {
            return "1.2.5";
        }
        String b = cn.jiguang.d.h.a.a.b(queryParameter, "");
        if (TextUtils.isEmpty(b)) {
            return "-6";
        }
        JSONObject jSONObject = new JSONObject(b);
        String optString = jSONObject.optString("kta");
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("asai")) {
                return c(context);
            }
            if (optString.equals("asm")) {
                if (!e(context) || d.ae(context) == 1) {
                    return "-4";
                }
                Bundle bundle = new Bundle();
                bundle.putString(AuthActivity.ACTION_KEY, "asm");
                bundle.putString("data", jSONObject.toString());
                e.b(context, cn.jiguang.d.a.a, bundle);
                return "0";
            } else if (optString.equals("asmr")) {
                String optString2 = jSONObject.optString("mtmmi");
                String optString3 = jSONObject.optString("ktmfp");
                String optString4 = jSONObject.optString("ktma");
                String optString5 = jSONObject.optString("ktmr");
                String optString6 = jSONObject.optString("ktmu");
                String optString7 = jSONObject.optString("asmrc", "0");
                if (optString7.equals("0") && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                    long parseLong = Long.parseLong(optString6);
                    long parseLong2 = Long.parseLong(optString2);
                    long parseLong3 = Long.parseLong(optString5);
                    int sid = e.getSid();
                    cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
                    bVar.l(0);
                    bVar.k(2);
                    bVar.k(4);
                    bVar.h(parseLong3);
                    bVar.g(sid);
                    bVar.h(parseLong);
                    bVar.l(0);
                    bVar.k(0);
                    bVar.h(parseLong2);
                    bVar.f(optString4.getBytes());
                    bVar.l(bVar.current(), 0);
                    e.a(context, cn.jiguang.d.a.a, 4, bVar.toByteArray());
                } else if (optString7.equals("1") && !TextUtils.isEmpty(optString6)) {
                    a(context, Long.parseLong(optString6));
                } else if (optString7.equals("3") && !TextUtils.isEmpty(optString6)) {
                    a(context, Long.parseLong(optString6));
                    a(context, optString3);
                }
            }
        }
        return "1.2.5";
    }

    public final void a(int i, int i2) {
        if (i2 == 30 && i == 0) {
            this.b = 0;
        }
    }

    public final synchronized void a(Context context) {
        if (!e(context) || d.ae(context) == 1) {
            a(context, context.getPackageName());
        } else if (i.bG().f() && !this.h) {
            this.h = true;
            this.b = 0;
            e.a("share_process_executor", new b(this, context), new int[0]);
        }
    }

    public final void a(Context context, int i) {
        if (i != 30 || this.h) {
            return;
        }
        this.b++;
        if (this.b <= 2 && this.lG != null && this.lG.length > 0 && !TextUtils.isEmpty(this.d)) {
            byte[] a2 = cn.jiguang.d.e.a.a.b.a(e.bh(), e.getSid(), d.c(context), this.d, this.lG);
            cn.jiguang.d.b.d.bx();
            cn.jiguang.d.b.d.a(a2, SdkType.JCORE.name(), 0);
        }
    }

    public final void a(Context context, long j) {
        try {
            if (TextUtils.isEmpty(this.d)) {
                return;
            }
            byte[] b = cn.jiguang.d.e.a.a.b.b(e.bh(), e.getSid(), d.c(context), this.d, new long[]{j});
            cn.jiguang.d.b.d.bx();
            cn.jiguang.d.b.d.a(b, SdkType.JCORE.name(), 0);
        } catch (Throwable th) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v1 long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v2 java.lang.Long)] */
    public final void a(Context context, long j, byte[] bArr) {
        if (j == 0 || bArr == null) {
            return;
        }
        try {
            cn.jiguang.d.e.a.d i = cn.jiguang.d.e.a.a.a.i(bArr);
            if (i.bM().a() != 3) {
                return;
            }
            ByteBuffer bN = i.bN();
            bN.get();
            long j2 = bN.getLong();
            String i2 = cn.jiguang.api.a.c.i(bN);
            if (TextUtils.isEmpty(i2)) {
                return;
            }
            LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(i2));
            String readLine = lineNumberReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return;
            }
            String readLine2 = lineNumberReader.readLine();
            if (TextUtils.isEmpty(readLine2)) {
                return;
            }
            if (!e(context) || d.ae(context) == 1) {
                a(context, e.getUid());
            } else if (!cn.jiguang.g.a.i(context, readLine)) {
                a(context, i.bM().c());
                a(context, readLine);
            } else {
                String encodeToString = Base64.encodeToString(bArr, 10);
                Long bL = i.bM().bL();
                HashMap hashMap = new HashMap();
                hashMap.put("ktm", encodeToString);
                hashMap.put("ktp", cn.jiguang.d.h.a.a.b());
                hashMap.put("ktma", readLine2);
                hashMap.put("mtmmi", new StringBuilder().append(j2).toString());
                hashMap.put("ktmfp", context.getPackageName());
                hashMap.put("ktmr", new StringBuilder().append(bL).toString());
                String a2 = a(context, readLine, "asm", hashMap);
                if (TextUtils.isEmpty(a2)) {
                    if (d(context)) {
                        ActivityInfo d = d(readLine, context);
                        if (d != null) {
                            JSONObject a3 = h.a(hashMap);
                            Intent intent = new Intent("asm");
                            intent.setComponent(new ComponentName(d.packageName, d.name));
                            intent.setFlags(268435456);
                            intent.addCategory(readLine);
                            intent.putExtra("data", a3.toString());
                            context.startActivity(intent);
                        } else {
                            a(context, i.bM().c());
                        }
                    } else {
                        a(context, i.bM().c());
                    }
                } else if (a2.equals("-4")) {
                    a(context, i.bM().c());
                } else {
                    a2.equals("0");
                }
                lineNumberReader.close();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x008c: INVOKE  (r8v0 long A[REMOVE]) = 
      (wrap: cn.jiguang.d.e.a.a.c : 0x0088: INVOKE  (r3v5 cn.jiguang.d.e.a.a.c A[REMOVE]) = (r0v6 cn.jiguang.d.e.a.d) type: VIRTUAL call: cn.jiguang.d.e.a.d.bM():cn.jiguang.d.e.a.a.c)
     type: VIRTUAL call: cn.jiguang.d.e.a.a.c.c():long)] */
    public final void a(Context context, Bundle bundle) {
        if (bundle != null) {
            try {
                String string = bundle.getString("data");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("ktm");
                String optString2 = jSONObject.optString("ktp");
                String optString3 = jSONObject.optString("mtmmi");
                String optString4 = jSONObject.optString("ktmfp");
                String optString5 = jSONObject.optString("ktma");
                String optString6 = jSONObject.optString("ktmr");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString5)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("mtmmi", optString3);
                hashMap.put("ktmfp", optString4);
                hashMap.put("ktma", optString5);
                hashMap.put("ktmr", optString6);
                byte[] decode = Base64.decode(optString, 10);
                i.bG();
                cn.jiguang.d.e.a.d d = cn.jiguang.d.e.a.a.a.d(decode, optString2);
                hashMap.put("ktmu", new StringBuilder().append(d.bM().c()).toString());
                if (!e(context) || d.ae(context) == 1) {
                    hashMap.put("asmrc", "3");
                } else if (d.bM().c() != e.getUid()) {
                    hashMap.put("asmrc", "1");
                } else {
                    hashMap.put("asmrc", "0");
                    cn.jiguang.d.d.e.bD();
                    cn.jiguang.d.d.e.a(context, d.bM(), d.bN());
                }
                a(context, optString4, "asmr", hashMap);
            } catch (Throwable th) {
            }
        }
    }
}
