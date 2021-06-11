package com.baidu.mobads.cid.cesium;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8262b = false;

    /* renamed from: a  reason: collision with root package name */
    public c f8263a;

    /* renamed from: c  reason: collision with root package name */
    public Context f8264c;

    /* renamed from: d  reason: collision with root package name */
    public a.C0107a f8265d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.b.b f8266e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f8267b = {"V", "O", "0"};

        /* renamed from: c  reason: collision with root package name */
        public String f8269c;

        /* renamed from: d  reason: collision with root package name */
        public String f8270d;

        /* renamed from: e  reason: collision with root package name */
        public String f8271e;

        /* renamed from: f  reason: collision with root package name */
        public long f8272f;

        /* renamed from: g  reason: collision with root package name */
        public String f8273g;

        /* renamed from: h  reason: collision with root package name */
        public int f8274h = 1;

        /* renamed from: a  reason: collision with root package name */
        public boolean f8268a = false;

        public String a() {
            if (this.f8268a) {
                return null;
            }
            return this.f8269c;
        }

        public String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f8269c);
                jSONObject.put("v270fk", this.f8270d);
                jSONObject.put("cck", this.f8271e);
                jSONObject.put("vsk", this.f8274h);
                jSONObject.put("ctk", this.f8272f);
                jSONObject.put("ek", this.f8273g);
                return jSONObject.toString();
            } catch (JSONException e2) {
                com.baidu.mobads.cid.cesium.f.c.a(e2);
                return null;
            }
        }

        public String c() {
            if (this.f8268a) {
                return null;
            }
            String str = this.f8270d;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8269c);
            sb.append("|");
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.f8271e);
            }
            if (!TextUtils.isEmpty(this.f8273g)) {
                sb.append(this.f8273g);
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
            if (this.f8274h == aVar.f8274h && this.f8269c.equals(aVar.f8269c) && this.f8270d.equals(aVar.f8270d) && this.f8271e.equals(aVar.f8271e)) {
                String str = this.f8273g;
                String str2 = aVar.f8273g;
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
            return Arrays.hashCode(new Object[]{this.f8269c, this.f8270d, this.f8271e, this.f8273g, Integer.valueOf(this.f8274h)});
        }
    }

    public g(Context context, com.baidu.mobads.cid.cesium.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f8264c = context.getApplicationContext();
        a.C0107a a2 = aVar.b().a("bohrium");
        this.f8265d = a2;
        a2.a();
        this.f8263a = cVar;
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
                aVar.f8269c = optString;
                aVar.f8271e = optString2;
                aVar.f8272f = optLong;
                aVar.f8274h = optInt;
                aVar.f8273g = optString3;
                aVar.f8270d = optString4;
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
                aVar.f8269c = str;
                aVar.f8271e = b2;
                aVar.f8272f = currentTimeMillis;
                aVar.f8274h = 1;
                aVar.f8273g = str3;
                aVar.f8270d = str2;
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
        a.C0105a c0105a = new a.C0105a();
        c0105a.f8128a = this.f8264c;
        c0105a.f8129b = aVar;
        a.c cVar = new a.c();
        for (com.baidu.mobads.cid.cesium.b.a aVar2 : bVar.a()) {
            aVar2.a(c0105a);
            aVar2.a(cVar);
        }
        this.f8266e = bVar;
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
        aVar.f8268a = true;
        return aVar;
    }

    public a a(e eVar) {
        String str;
        if (eVar != null) {
            a aVar = new a();
            aVar.f8272f = System.currentTimeMillis();
            aVar.f8274h = 1;
            try {
                boolean z = false;
                aVar.f8270d = eVar.f8246b.substring(0, 1);
                aVar.f8269c = eVar.f8245a;
                aVar.f8271e = b(eVar.f8245a);
                String[] strArr = a.f8267b;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f8270d)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = eVar.f8246b) != null && str.length() >= 2) {
                    aVar.f8273g = eVar.f8246b.substring(1);
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
        dVar.f8134a = true;
        List<com.baidu.mobads.cid.cesium.b.a> a2 = this.f8266e.a();
        Collections.sort(a2, com.baidu.mobads.cid.cesium.b.a.f8123c);
        List<b> b2 = this.f8263a.b(this.f8264c);
        if (b2 != null) {
            for (b bVar : b2) {
                if (!bVar.f8122d && bVar.f8121c) {
                    for (com.baidu.mobads.cid.cesium.b.a aVar2 : a2) {
                        a.e a3 = aVar2.a(bVar.f8119a.packageName, dVar);
                        if (a3 != null && a3.a() && (aVar = a3.f8135a) != null) {
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
        String a2 = a(this.f8264c);
        String a3 = com.baidu.mobads.cid.cesium.d.b.a(("com.baidu" + a2).getBytes(), true);
        a aVar = new a();
        aVar.f8272f = System.currentTimeMillis();
        aVar.f8274h = 1;
        aVar.f8269c = a3;
        aVar.f8270d = "V";
        aVar.f8271e = b(a3);
        aVar.f8273g = null;
        return aVar;
    }
}
