package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2536e;

    /* renamed from: a  reason: collision with root package name */
    public String f2537a;

    /* renamed from: b  reason: collision with root package name */
    public String f2538b;

    /* renamed from: c  reason: collision with root package name */
    public int f2539c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f2540d = 2;

    static {
        String str = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        String str2 = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
        f2536e = str + str2;
    }

    public static boolean a(Context context) {
        File c2 = c(context);
        if (c2.exists()) {
            return c2.delete();
        }
        return false;
    }

    public static a b(Context context) {
        return d(d.a(c(context)));
    }

    public static boolean b(int i2) {
        return i2 >= 14;
    }

    public static a c(String str) {
        JsonReader jsonReader;
        JsonReader jsonReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jsonReader = new JsonReader(new StringReader(str));
            try {
                jsonReader.beginObject();
                String g2 = g("ZGV2aWNlaWQ=");
                String g3 = g("dmVy");
                String str2 = "0";
                String str3 = "";
                int i2 = 2;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (g2.equals(nextName)) {
                        str3 = jsonReader.nextString();
                    } else if (g3.equals(nextName)) {
                        i2 = jsonReader.nextInt();
                    } else {
                        str2 = jsonReader.nextString();
                    }
                }
                jsonReader.endObject();
                int i3 = 0;
                if (i2 == 2 && !TextUtils.isEmpty(str2)) {
                    i3 = str2.length();
                }
                try {
                    jsonReader.close();
                } catch (Exception e2) {
                    d.a(e2);
                }
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                a aVar = new a();
                aVar.a(str3);
                aVar.a(i3);
                if (!aVar.d()) {
                    aVar.b(str2);
                }
                return aVar;
            } catch (IOException unused) {
                if (jsonReader != null) {
                    try {
                        jsonReader.close();
                    } catch (Exception e3) {
                        d.a(e3);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                jsonReader2 = jsonReader;
                if (jsonReader2 != null) {
                    try {
                        jsonReader2.close();
                    } catch (Exception e4) {
                        d.a(e4);
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            jsonReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File c(Context context) {
        return new File(context.getFilesDir(), "libcuid.so");
    }

    public static a d(String str) {
        return c(f(str));
    }

    public static boolean e(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.a.a.b(f2536e, f2536e, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String g(String str) {
        return new String(com.baidu.android.bbalbs.common.a.b.a(str.getBytes()));
    }

    public String a() {
        return this.f2537a;
    }

    public void a(int i2) {
        this.f2539c = i2;
    }

    public void a(String str) {
        this.f2537a = str;
    }

    public String b() {
        return this.f2538b;
    }

    public void b(String str) {
        this.f2538b = str;
    }

    public boolean c() {
        String str;
        if (d()) {
            str = "O";
        } else if (!e()) {
            return false;
        } else {
            str = "0";
        }
        this.f2538b = str;
        return true;
    }

    public boolean d() {
        return b(this.f2539c);
    }

    public boolean e() {
        return e(this.f2538b);
    }
}
