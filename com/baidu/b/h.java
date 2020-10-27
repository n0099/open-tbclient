package com.baidu.b;

import android.content.Context;
import android.provider.Settings;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.b.b.a;
import com.baidu.b.e.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {
    private static boolean b = false;
    c adL;
    private com.baidu.b.b.c adO;
    private a.C0092a adb;
    private Context c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f1268a = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};
        private String b;
        private String c;
        private String d;
        private long e;
        private String f;
        private int g = 1;

        public String a() {
            return this.b;
        }

        public String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.b);
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
            sb.append(this.b).append("|").append(str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
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
            if (this.g == aVar.g && this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.d.equals(aVar.d)) {
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
            return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.f, Integer.valueOf(this.g)});
        }
    }

    public h(Context context, com.baidu.b.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.c = context.getApplicationContext();
        this.adb = aVar.sO().cX("bohrium");
        this.adb.a();
        this.adL = cVar;
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
            String optString4 = jSONObject.optString("v270fk", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            a aVar = new a();
            aVar.b = optString;
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
        a.C0090a c0090a = new a.C0090a();
        c0090a.f1244a = this.c;
        c0090a.acW = aVar;
        a.c cVar2 = new a.c();
        for (com.baidu.b.b.a aVar2 : cVar.a()) {
            aVar2.a(c0090a);
            aVar2.a(cVar2);
        }
        this.adO = cVar;
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
            aVar.b = str;
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
        dVar.f1245a = true;
        List<com.baidu.b.b.a> a2 = this.adO.a();
        Collections.sort(a2, com.baidu.b.b.a.acV);
        List<b> N = this.adL.N(this.c);
        if (N != null) {
            for (b bVar : N) {
                if (!bVar.d && bVar.c) {
                    for (com.baidu.b.b.a aVar : a2) {
                        a.e a3 = aVar.a(bVar.acS.packageName, dVar);
                        if (a3 != null && a3.a() && a3.acY != null) {
                            return a3.acY;
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
            aVar.c = fVar.b.substring(0, 1);
            aVar.b = fVar.f1264a;
            aVar.d = c(fVar.f1264a);
            String[] strArr = a.f1268a;
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
            if (!z || fVar.b == null || fVar.b.length() < 2) {
                return aVar;
            }
            aVar.f = fVar.b.substring(1);
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
        aVar.b = a2;
        aVar.c = ExifInterface.LONGITUDE_EAST;
        aVar.d = c(a2);
        aVar.f = "RO";
        return aVar;
    }
}
