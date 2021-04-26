package com.baidu.mobads.cid.cesium;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8488b = false;

    /* renamed from: a  reason: collision with root package name */
    public c f8489a;

    /* renamed from: c  reason: collision with root package name */
    public Context f8490c;

    /* renamed from: d  reason: collision with root package name */
    public a.C0105a f8491d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.b.b f8492e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f8493b = {"V", "O", "0"};

        /* renamed from: c  reason: collision with root package name */
        public String f8495c;

        /* renamed from: d  reason: collision with root package name */
        public String f8496d;

        /* renamed from: e  reason: collision with root package name */
        public String f8497e;

        /* renamed from: f  reason: collision with root package name */
        public long f8498f;

        /* renamed from: g  reason: collision with root package name */
        public String f8499g;

        /* renamed from: h  reason: collision with root package name */
        public int f8500h = 1;

        /* renamed from: a  reason: collision with root package name */
        public boolean f8494a = false;

        public String a() {
            if (this.f8494a) {
                return null;
            }
            return this.f8495c;
        }

        public String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f8495c);
                jSONObject.put("v270fk", this.f8496d);
                jSONObject.put("cck", this.f8497e);
                jSONObject.put("vsk", this.f8500h);
                jSONObject.put("ctk", this.f8498f);
                jSONObject.put("ek", this.f8499g);
                return jSONObject.toString();
            } catch (JSONException e2) {
                com.baidu.mobads.cid.cesium.f.c.a(e2);
                return null;
            }
        }

        public String c() {
            if (this.f8494a) {
                return null;
            }
            String str = this.f8496d;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8495c);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.f8497e);
            }
            if (!TextUtils.isEmpty(this.f8499g)) {
                sb.append(this.f8499g);
            }
            return sb.toString().trim();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f8500h == aVar.f8500h && this.f8495c.equals(aVar.f8495c) && this.f8496d.equals(aVar.f8496d) && this.f8497e.equals(aVar.f8497e)) {
                String str = this.f8499g;
                String str2 = aVar.f8499g;
                if (str == str2) {
                    return true;
                }
                if (str != null && str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f8495c, this.f8496d, this.f8497e, this.f8499g, Integer.valueOf(this.f8500h)});
        }
    }

    public g(Context context, com.baidu.mobads.cid.cesium.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f8490c = context.getApplicationContext();
        a.C0105a a2 = aVar.b().a("bohrium");
        this.f8491d = a2;
        a2.a();
        this.f8489a = cVar;
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
            if (!TextUtils.isEmpty(optString)) {
                a aVar = new a();
                aVar.f8495c = optString;
                aVar.f8497e = optString2;
                aVar.f8498f = optLong;
                aVar.f8500h = optInt;
                aVar.f8499g = optString3;
                aVar.f8496d = optString4;
                return aVar;
            }
        } catch (Exception e2) {
            com.baidu.mobads.cid.cesium.f.c.a(e2);
        }
        return null;
    }

    public static a a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String b2 = b(str);
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = new a();
                aVar.f8495c = str;
                aVar.f8497e = b2;
                aVar.f8498f = currentTimeMillis;
                aVar.f8500h = 1;
                aVar.f8499g = str3;
                aVar.f8496d = str2;
                return aVar;
            } catch (Exception e2) {
                com.baidu.mobads.cid.cesium.f.c.a(e2);
            }
        }
        return null;
    }

    private String a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private void a(com.baidu.mobads.cid.cesium.e.a aVar) {
        com.baidu.mobads.cid.cesium.b.b bVar = new com.baidu.mobads.cid.cesium.b.b(new com.baidu.mobads.cid.cesium.a());
        a.C0103a c0103a = new a.C0103a();
        c0103a.f8354a = this.f8490c;
        c0103a.f8355b = aVar;
        a.c cVar = new a.c();
        for (com.baidu.mobads.cid.cesium.b.a aVar2 : bVar.a()) {
            aVar2.a(c0103a);
            aVar2.a(cVar);
        }
        this.f8492e = bVar;
    }

    public static String b(String str) {
        try {
            return new com.baidu.mobads.cid.cesium.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(new com.baidu.mobads.cid.cesium.a.a().a(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public a a() {
        a aVar = new a();
        aVar.f8494a = true;
        return aVar;
    }

    public a a(e eVar) {
        String str;
        if (eVar != null) {
            a aVar = new a();
            aVar.f8498f = System.currentTimeMillis();
            aVar.f8500h = 1;
            try {
                boolean z = false;
                aVar.f8496d = eVar.f8472b.substring(0, 1);
                aVar.f8495c = eVar.f8471a;
                aVar.f8497e = b(eVar.f8471a);
                String[] strArr = a.f8493b;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f8496d)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = eVar.f8472b) != null && str.length() >= 2) {
                    aVar.f8499g = eVar.f8472b.substring(1);
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public a b() {
        a aVar;
        a.d dVar = new a.d();
        dVar.f8360a = true;
        List<com.baidu.mobads.cid.cesium.b.a> a2 = this.f8492e.a();
        Collections.sort(a2, com.baidu.mobads.cid.cesium.b.a.f8349c);
        List<b> b2 = this.f8489a.b(this.f8490c);
        if (b2 != null) {
            for (b bVar : b2) {
                if (!bVar.f8348d && bVar.f8347c) {
                    for (com.baidu.mobads.cid.cesium.b.a aVar2 : a2) {
                        a.e a3 = aVar2.a(bVar.f8345a.packageName, dVar);
                        if (a3 != null && a3.a() && (aVar = a3.f8361a) != null) {
                            return aVar;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return null;
    }

    public a c() {
        String a2 = a(this.f8490c);
        String a3 = com.baidu.mobads.cid.cesium.d.b.a(("com.baidu" + a2).getBytes(), true);
        a aVar = new a();
        aVar.f8498f = System.currentTimeMillis();
        aVar.f8500h = 1;
        aVar.f8495c = a3;
        aVar.f8496d = "V";
        aVar.f8497e = b(a3);
        aVar.f8499g = null;
        return aVar;
    }
}
