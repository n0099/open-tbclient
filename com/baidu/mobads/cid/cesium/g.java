package com.baidu.mobads.cid.cesium;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
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
    public static boolean f8195b = false;

    /* renamed from: a  reason: collision with root package name */
    public c f8196a;

    /* renamed from: c  reason: collision with root package name */
    public Context f8197c;

    /* renamed from: d  reason: collision with root package name */
    public a.C0105a f8198d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.mobads.cid.cesium.b.b f8199e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f8200b = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};

        /* renamed from: c  reason: collision with root package name */
        public String f8202c;

        /* renamed from: d  reason: collision with root package name */
        public String f8203d;

        /* renamed from: e  reason: collision with root package name */
        public String f8204e;

        /* renamed from: f  reason: collision with root package name */
        public long f8205f;

        /* renamed from: g  reason: collision with root package name */
        public String f8206g;

        /* renamed from: h  reason: collision with root package name */
        public int f8207h = 1;

        /* renamed from: a  reason: collision with root package name */
        public boolean f8201a = false;

        public String a() {
            if (this.f8201a) {
                return null;
            }
            return this.f8202c;
        }

        public String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f8202c);
                jSONObject.put("v270fk", this.f8203d);
                jSONObject.put("cck", this.f8204e);
                jSONObject.put("vsk", this.f8207h);
                jSONObject.put("ctk", this.f8205f);
                jSONObject.put("ek", this.f8206g);
                return jSONObject.toString();
            } catch (JSONException e2) {
                com.baidu.mobads.cid.cesium.f.c.a(e2);
                return null;
            }
        }

        public String c() {
            if (this.f8201a) {
                return null;
            }
            String str = this.f8203d;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8202c);
            sb.append(FieldBuilder.SE);
            sb.append(str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                sb.append(this.f8204e);
            }
            if (!TextUtils.isEmpty(this.f8206g)) {
                sb.append(this.f8206g);
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
            if (this.f8207h == aVar.f8207h && this.f8202c.equals(aVar.f8202c) && this.f8203d.equals(aVar.f8203d) && this.f8204e.equals(aVar.f8204e)) {
                String str = this.f8206g;
                String str2 = aVar.f8206g;
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
            return Arrays.hashCode(new Object[]{this.f8202c, this.f8203d, this.f8204e, this.f8206g, Integer.valueOf(this.f8207h)});
        }
    }

    public g(Context context, com.baidu.mobads.cid.cesium.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f8197c = context.getApplicationContext();
        a.C0105a a2 = aVar.b().a("bohrium");
        this.f8198d = a2;
        a2.a();
        this.f8196a = cVar;
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
            if (!TextUtils.isEmpty(optString)) {
                a aVar = new a();
                aVar.f8202c = optString;
                aVar.f8204e = optString2;
                aVar.f8205f = optLong;
                aVar.f8207h = optInt;
                aVar.f8206g = optString3;
                aVar.f8203d = optString4;
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
                aVar.f8202c = str;
                aVar.f8204e = b2;
                aVar.f8205f = currentTimeMillis;
                aVar.f8207h = 1;
                aVar.f8206g = str3;
                aVar.f8203d = str2;
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
        c0103a.f8063a = this.f8197c;
        c0103a.f8064b = aVar;
        a.c cVar = new a.c();
        for (com.baidu.mobads.cid.cesium.b.a aVar2 : bVar.a()) {
            aVar2.a(c0103a);
            aVar2.a(cVar);
        }
        this.f8199e = bVar;
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
        aVar.f8201a = true;
        return aVar;
    }

    public a a(e eVar) {
        String str;
        if (eVar != null) {
            a aVar = new a();
            aVar.f8205f = System.currentTimeMillis();
            aVar.f8207h = 1;
            try {
                boolean z = false;
                aVar.f8203d = eVar.f8179b.substring(0, 1);
                aVar.f8202c = eVar.f8178a;
                aVar.f8204e = b(eVar.f8178a);
                String[] strArr = a.f8200b;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    } else if (strArr[i].equals(aVar.f8203d)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z && (str = eVar.f8179b) != null && str.length() >= 2) {
                    aVar.f8206g = eVar.f8179b.substring(1);
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
        dVar.f8069a = true;
        List<com.baidu.mobads.cid.cesium.b.a> a2 = this.f8199e.a();
        Collections.sort(a2, com.baidu.mobads.cid.cesium.b.a.f8058c);
        List<b> b2 = this.f8196a.b(this.f8197c);
        if (b2 != null) {
            for (b bVar : b2) {
                if (!bVar.f8057d && bVar.f8056c) {
                    for (com.baidu.mobads.cid.cesium.b.a aVar2 : a2) {
                        a.e a3 = aVar2.a(bVar.f8054a.packageName, dVar);
                        if (a3 != null && a3.a() && (aVar = a3.f8070a) != null) {
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
        String a2 = a(this.f8197c);
        String a3 = com.baidu.mobads.cid.cesium.d.b.a(("com.baidu" + a2).getBytes(), true);
        a aVar = new a();
        aVar.f8205f = System.currentTimeMillis();
        aVar.f8207h = 1;
        aVar.f8202c = a3;
        aVar.f8203d = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        aVar.f8204e = b(a3);
        aVar.f8206g = null;
        return aVar;
    }
}
