package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.ecommerce.view.SpeechRecognitionDialog;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1947a = "alipay_tid_storage";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1948b = "tidinfo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1949c = "upgraded_from_db";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1950d = "tid";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1951e = "client_key";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1952f = "timestamp";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1953g = "vimei";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1954h = "vimsi";
    public static Context i;
    public static b o;
    public String j;
    public String k;
    public long l;
    public String m;
    public String n;
    public boolean p = false;

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (o == null) {
                c.b("TidStorage", "getInstance");
                o = new b();
            }
            if (i == null) {
                o.b(context);
            }
            bVar = o;
        }
        return bVar;
    }

    private void b(Context context) {
        if (context != null) {
            c.b("TidStorage", "TidStorage.initialize context != null");
            i = context.getApplicationContext();
        }
        if (this.p) {
            return;
        }
        this.p = true;
        k();
        l();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
        if (r5 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        com.alipay.sdk.tid.a aVar;
        Throwable th;
        Context context = i;
        if (context == null) {
            return;
        }
        if (a.d(f1947a, f1949c)) {
            c.b("TidStorage", "transferTidFromOldDb: already migrated. returning");
            return;
        }
        try {
            c.b("TidStorage", "transferTidFromOldDb: tid from db: ");
            aVar = new com.alipay.sdk.tid.a(context);
            try {
                String b2 = com.alipay.sdk.util.a.a(context).b();
                String a2 = com.alipay.sdk.util.a.a(context).a();
                String a3 = aVar.a(b2, a2);
                String b3 = aVar.b(b2, a2);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b3)) {
                    c.b("TidStorage", "transferTidFromOldDb: tid from db is " + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b3);
                    a(a3, b3);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    c.a(th);
                } finally {
                    if (aVar != null) {
                        aVar.close();
                    }
                }
            }
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
        }
        aVar.close();
        try {
            c.b("TidStorage", "transferTidFromOldDb: removing database table");
            com.alipay.sdk.tid.a aVar2 = new com.alipay.sdk.tid.a(context);
            try {
                aVar2.a();
                aVar2.close();
            } catch (Throwable th4) {
                th = th4;
                aVar = aVar2;
                try {
                    c.a(th);
                    a.a(f1947a, f1949c, "updated", false);
                } finally {
                    if (aVar != null) {
                        aVar.close();
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
        a.a(f1947a, f1949c, "updated", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l() {
        String str;
        String str2;
        String str3;
        String str4;
        String a2;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String str5 = null;
        try {
            a2 = a.a(f1947a, f1948b, true);
        } catch (Exception e2) {
            e = e2;
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject(a2);
            str = jSONObject.optString("tid", "");
            try {
                str2 = jSONObject.optString(f1951e, "");
                try {
                    valueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    str3 = jSONObject.optString(f1953g, "");
                } catch (Exception e3) {
                    e = e3;
                    str3 = null;
                }
            } catch (Exception e4) {
                e = e4;
                str2 = null;
                str3 = str2;
                c.a(e);
                str4 = null;
                str5 = str;
                c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
                if (!a(str5, str2, str3, str4)) {
                }
            }
            try {
                str4 = jSONObject.optString(f1954h, "");
            } catch (Exception e5) {
                e = e5;
                c.a(e);
                str4 = null;
                str5 = str;
                c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
                if (!a(str5, str2, str3, str4)) {
                }
            }
            str5 = str;
            c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
            if (!a(str5, str2, str3, str4)) {
                m();
                return;
            }
            this.j = str5;
            this.k = str2;
            this.l = valueOf.longValue();
            this.m = str3;
            this.n = str4;
            return;
        }
        str4 = null;
        str2 = null;
        str3 = null;
        c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
        if (!a(str5, str2, str3, str4)) {
        }
    }

    private void m() {
        this.j = "";
        this.k = f();
        this.l = System.currentTimeMillis();
        this.m = n();
        this.n = n();
        a.b(f1947a, f1948b);
    }

    private String n() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(SpeechRecognitionDialog.REQUEST_SETTING_CODE) + 1000);
    }

    private void o() {
    }

    private void p() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.j);
            jSONObject.put(f1951e, this.k);
            jSONObject.put("timestamp", this.l);
            jSONObject.put(f1953g, this.m);
            jSONObject.put(f1954h, this.n);
            a.a(f1947a, f1948b, jSONObject.toString(), true);
        } catch (Exception e2) {
            c.a(e2);
        }
    }

    public String c() {
        c.b("TidStorage", "TidStorage.getVirtualImei " + this.m);
        return this.m;
    }

    public String d() {
        c.b("TidStorage", "TidStorage.getVirtualImsi " + this.n);
        return this.n;
    }

    public boolean e() {
        return TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n);
    }

    public String f() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public void g() {
        String format = String.format("TidStorage::delete > %s，%s，%s，%s，%s", this.j, this.k, Long.valueOf(this.l), this.m, this.n);
        c.b("TidStorage", "TidStorage.delete " + format);
        m();
    }

    public boolean h() {
        return e();
    }

    public Long i() {
        return Long.valueOf(this.l);
    }

    /* loaded from: classes.dex */
    public static class a {
        public static String a() {
            return "!@#23457";
        }

        public static boolean a(String str, String str2) {
            if (b.i == null) {
                return false;
            }
            return b.i.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (b.i == null) {
                return;
            }
            b.i.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static String c(String str, String str2) {
            return a(str, str2, true);
        }

        public static boolean d(String str, String str2) {
            if (b.i == null) {
                return false;
            }
            return b.i.getSharedPreferences(str, 0).contains(str2);
        }

        public static String a(String str, String str2, boolean z) {
            String str3;
            if (b.i == null) {
                return null;
            }
            String string = b.i.getSharedPreferences(str, 0).getString(str2, null);
            if (TextUtils.isEmpty(string) || !z) {
                str3 = string;
            } else {
                String b2 = b();
                str3 = com.alipay.sdk.encrypt.b.b(string, b2);
                if (TextUtils.isEmpty(str3)) {
                    str3 = com.alipay.sdk.encrypt.b.b(string, a());
                    if (!TextUtils.isEmpty(str3)) {
                        a(str, str2, str3, true);
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    String.format("LocalPreference::getLocalPreferences failed %s，%s", string, b2);
                    c.b("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences failed");
                }
            }
            c.b("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences value " + string);
            return str3;
        }

        public static String b() {
            String str;
            try {
                str = b.i.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "unknow";
            }
            return (str + "00000000").substring(0, 8);
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (b.i == null) {
                return;
            }
            SharedPreferences sharedPreferences = b.i.getSharedPreferences(str, 0);
            if (z) {
                String b2 = b();
                String a2 = com.alipay.sdk.encrypt.b.a(str3, b2);
                if (TextUtils.isEmpty(a2)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, b2);
                }
                str3 = a2;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }
    }

    public String a() {
        c.b("TidStorage", "TidStorage.getTid " + this.j);
        return this.j;
    }

    public String b() {
        c.b("TidStorage", "TidStorage.getClientKey " + this.k);
        return this.k;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public void a(String str, String str2) {
        c.b("TidStorage", "TidStorage.save " + ("tid=" + str + ",clientKey=" + str2));
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.j = str;
        this.k = str2;
        this.l = System.currentTimeMillis();
        p();
        o();
    }

    private void a(String str, String str2, String str3, String str4, Long l) {
        if (a(str, str2, str3, str4)) {
            return;
        }
        this.j = str;
        this.k = str2;
        this.m = str3;
        this.n = str4;
        if (l == null) {
            this.l = System.currentTimeMillis();
        } else {
            this.l = l.longValue();
        }
        p();
    }
}
