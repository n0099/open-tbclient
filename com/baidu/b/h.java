package com.baidu.b;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.b.b.a;
import com.baidu.b.e.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1619b = false;
    private a.C0085a aeR;
    c afr;
    private com.baidu.b.b.c afu;
    private Context c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f1620a = {"V", "O", "0"};

        /* renamed from: b  reason: collision with root package name */
        private String f1621b;
        private String c;
        private String d;
        private long e;
        private String f;
        private int g = 1;

        public String a() {
            return this.f1621b;
        }

        public String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f1621b);
                jSONObject.put("v270fk", this.c);
                jSONObject.put("cck", this.d);
                jSONObject.put("vsk", this.g);
                jSONObject.put("ctk", this.e);
                jSONObject.put("ek", this.f);
                return jSONObject.toString();
            } catch (JSONException e) {
                com.baidu.b.f.c.a(e);
                return null;
            }
        }

        public String c() {
            String str = this.c;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1621b).append("|").append(str);
            if ("V".equals(str)) {
                sb.append(this.d);
            }
            if (!TextUtils.isEmpty(this.f)) {
                sb.append(this.f);
            }
            return sb.toString().trim();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.g == aVar.g && this.f1621b.equals(aVar.f1621b) && this.c.equals(aVar.c) && this.d.equals(aVar.d)) {
                if (this.f == aVar.f) {
                    return true;
                }
                if (this.f != null && this.f.equals(aVar.f)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f1621b, this.c, this.d, this.f, Integer.valueOf(this.g)});
        }
    }

    public h(Context context, com.baidu.b.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.c = context.getApplicationContext();
        this.aeR = aVar.sr().cV("bohrium");
        this.aeR.a();
        this.afr = cVar;
        a(aVar);
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("dik", "");
            String optString2 = jSONObject.optString("cck", "");
            long optLong = jSONObject.optLong("ctk", 0L);
            int optInt = jSONObject.optInt("vsk", 1);
            String optString3 = jSONObject.optString("ek", "");
            String optString4 = jSONObject.optString("v270fk", "V");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            a aVar = new a();
            aVar.f1621b = optString;
            aVar.d = optString2;
            aVar.e = optLong;
            aVar.g = optInt;
            aVar.f = optString3;
            aVar.c = optString4;
            return aVar;
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
            return null;
        }
    }

    private String a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private void a(com.baidu.b.e.a aVar) {
        com.baidu.b.b.c cVar = new com.baidu.b.b.c(new com.baidu.b.a());
        a.C0083a c0083a = new a.C0083a();
        c0083a.f1575a = this.c;
        c0083a.aeM = aVar;
        a.c cVar2 = new a.c();
        for (com.baidu.b.b.a aVar2 : cVar.a()) {
            aVar2.a(c0083a);
            aVar2.a(cVar2);
        }
        this.afu = cVar;
    }

    private static String c(String str) {
        try {
            return new com.baidu.b.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(new com.baidu.b.a.a().a(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static a k(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            String c = c(str);
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = new a();
            aVar.f1621b = str;
            aVar.d = c;
            aVar.e = currentTimeMillis;
            aVar.g = 1;
            aVar.f = str3;
            aVar.c = str2;
            return aVar;
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
            return null;
        }
    }

    public a a() {
        a.d dVar = new a.d();
        dVar.f1577a = true;
        List<com.baidu.b.b.a> a2 = this.afu.a();
        Collections.sort(a2, com.baidu.b.b.a.c);
        List<b> b2 = this.afr.b(this.c);
        if (b2 != null) {
            for (b bVar : b2) {
                if (!bVar.d && bVar.c) {
                    for (com.baidu.b.b.a aVar : a2) {
                        a.e a3 = aVar.a(bVar.aeJ.packageName, dVar);
                        if (a3 != null && a3.a() && a3.aeO != null) {
                            return a3.aeO;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public a a(f fVar) {
        boolean z = false;
        if (fVar == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        a aVar = new a();
        aVar.e = System.currentTimeMillis();
        aVar.g = 1;
        try {
            aVar.c = fVar.f1614b.substring(0, 1);
            aVar.f1621b = fVar.f1613a;
            aVar.d = c(fVar.f1613a);
            String[] strArr = a.f1620a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else if (strArr[i].equals(aVar.c)) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z || fVar.f1614b == null || fVar.f1614b.length() < 2) {
                return aVar;
            }
            aVar.f = fVar.f1614b.substring(1);
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }

    public a b(String str) {
        String a2 = com.baidu.b.d.b.a(("com.baidu" + a(this.c)).getBytes(), true);
        a aVar = new a();
        aVar.e = System.currentTimeMillis();
        aVar.g = 1;
        aVar.f1621b = a2;
        aVar.c = "E";
        aVar.d = c(a2);
        aVar.f = "RO";
        return aVar;
    }
}
