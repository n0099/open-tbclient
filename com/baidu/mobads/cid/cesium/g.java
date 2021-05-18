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
    public static boolean f8300b = false;

    /* renamed from: a  reason: collision with root package name */
    public c f8301a;

    /* renamed from: c  reason: collision with root package name */
    public Context f8302c;

    /* renamed from: d  reason: collision with root package name */
    public a.C0105a f8303d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.b.b f8304e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f8305b = {"V", "O", "0"};

        /* renamed from: c  reason: collision with root package name */
        public String f8307c;

        /* renamed from: d  reason: collision with root package name */
        public String f8308d;

        /* renamed from: e  reason: collision with root package name */
        public String f8309e;

        /* renamed from: f  reason: collision with root package name */
        public long f8310f;

        /* renamed from: g  reason: collision with root package name */
        public String f8311g;

        /* renamed from: h  reason: collision with root package name */
        public int f8312h = 1;

        /* renamed from: a  reason: collision with root package name */
        public boolean f8306a = false;

        public String a() {
            if (this.f8306a) {
                return null;
            }
            return this.f8307c;
        }

        public String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f8307c);
                jSONObject.put("v270fk", this.f8308d);
                jSONObject.put("cck", this.f8309e);
                jSONObject.put("vsk", this.f8312h);
                jSONObject.put("ctk", this.f8310f);
                jSONObject.put("ek", this.f8311g);
                return jSONObject.toString();
            } catch (JSONException e2) {
                com.baidu.mobads.cid.cesium.f.c.a(e2);
                return null;
            }
        }

        public String c() {
            if (this.f8306a) {
                return null;
            }
            String str = this.f8308d;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8307c);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.f8309e);
            }
            if (!TextUtils.isEmpty(this.f8311g)) {
                sb.append(this.f8311g);
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
            if (this.f8312h == aVar.f8312h && this.f8307c.equals(aVar.f8307c) && this.f8308d.equals(aVar.f8308d) && this.f8309e.equals(aVar.f8309e)) {
                String str = this.f8311g;
                String str2 = aVar.f8311g;
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
            return Arrays.hashCode(new Object[]{this.f8307c, this.f8308d, this.f8309e, this.f8311g, Integer.valueOf(this.f8312h)});
        }
    }

    public g(Context context, com.baidu.mobads.cid.cesium.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f8302c = context.getApplicationContext();
        a.C0105a a2 = aVar.b().a("bohrium");
        this.f8303d = a2;
        a2.a();
        this.f8301a = cVar;
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
                aVar.f8307c = optString;
                aVar.f8309e = optString2;
                aVar.f8310f = optLong;
                aVar.f8312h = optInt;
                aVar.f8311g = optString3;
                aVar.f8308d = optString4;
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
                aVar.f8307c = str;
                aVar.f8309e = b2;
                aVar.f8310f = currentTimeMillis;
                aVar.f8312h = 1;
                aVar.f8311g = str3;
                aVar.f8308d = str2;
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
        c0103a.f8166a = this.f8302c;
        c0103a.f8167b = aVar;
        a.c cVar = new a.c();
        for (com.baidu.mobads.cid.cesium.b.a aVar2 : bVar.a()) {
            aVar2.a(c0103a);
            aVar2.a(cVar);
        }
        this.f8304e = bVar;
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
        aVar.f8306a = true;
        return aVar;
    }

    public a a(e eVar) {
        String str;
        if (eVar != null) {
            a aVar = new a();
            aVar.f8310f = System.currentTimeMillis();
            aVar.f8312h = 1;
            try {
                boolean z = false;
                aVar.f8308d = eVar.f8284b.substring(0, 1);
                aVar.f8307c = eVar.f8283a;
                aVar.f8309e = b(eVar.f8283a);
                String[] strArr = a.f8305b;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (strArr[i2].equals(aVar.f8308d)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z && (str = eVar.f8284b) != null && str.length() >= 2) {
                    aVar.f8311g = eVar.f8284b.substring(1);
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
        dVar.f8172a = true;
        List<com.baidu.mobads.cid.cesium.b.a> a2 = this.f8304e.a();
        Collections.sort(a2, com.baidu.mobads.cid.cesium.b.a.f8161c);
        List<b> b2 = this.f8301a.b(this.f8302c);
        if (b2 != null) {
            for (b bVar : b2) {
                if (!bVar.f8160d && bVar.f8159c) {
                    for (com.baidu.mobads.cid.cesium.b.a aVar2 : a2) {
                        a.e a3 = aVar2.a(bVar.f8157a.packageName, dVar);
                        if (a3 != null && a3.a() && (aVar = a3.f8173a) != null) {
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
        String a2 = a(this.f8302c);
        String a3 = com.baidu.mobads.cid.cesium.d.b.a(("com.baidu" + a2).getBytes(), true);
        a aVar = new a();
        aVar.f8310f = System.currentTimeMillis();
        aVar.f8312h = 1;
        aVar.f8307c = a3;
        aVar.f8308d = "V";
        aVar.f8309e = b(a3);
        aVar.f8311g = null;
        return aVar;
    }
}
