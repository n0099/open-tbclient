package com.baidu.android.pushservice.l;

import android.content.Context;
import com.baidu.ar.constants.HttpConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String a;
    public String b;
    public int c;
    public ArrayList<e> d;
    public ArrayList<f> e;
    public String f;
    public String g;
    public a h;
    public int i = 0;

    /* loaded from: classes.dex */
    public class a {
        public int a;
        public int b;

        public a(c cVar) {
        }
    }

    public c(Context context, String str) {
        this.a = str;
        a(context, str);
    }

    public String a() {
        return this.f;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(int i, int i2) {
        a aVar = new a(this);
        this.h = aVar;
        aVar.a = i;
        aVar.b = i2;
    }

    public final void a(Context context, String str) {
        String str2;
        int i;
        String str3;
        String str4 = "apksign";
        try {
            JSONObject jSONObject = new JSONObject(str);
            c(jSONObject.getString(HttpConstants.HTTP_MANUFACTURER));
            String string = jSONObject.getString("mode");
            if ("I".equalsIgnoreCase(string)) {
                a(1);
            } else if ("I_HW".equalsIgnoreCase(string)) {
                a(5);
            } else if ("I_XM".equalsIgnoreCase(string)) {
                a(6);
            } else if ("I_MZ".equalsIgnoreCase(string)) {
                a(7);
            } else if ("I_OP".equalsIgnoreCase(string)) {
                a(8);
            } else if ("I_VI".equalsIgnoreCase(string)) {
                a(9);
            } else if ("I_HN".equalsIgnoreCase(string)) {
                a(10);
            } else if ("C".equalsIgnoreCase(string)) {
                a(2);
            } else {
                a(0);
            }
            ArrayList<e> arrayList = new ArrayList<>();
            String str5 = "match";
            if (jSONObject.has("osversion")) {
                JSONArray jSONArray = jSONObject.getJSONArray("osversion");
                str2 = "apkversion";
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    JSONArray jSONArray2 = jSONArray;
                    e eVar = new e();
                    String str6 = str4;
                    eVar.a(jSONObject2.getString("key"));
                    eVar.b(jSONObject2.getString("value"));
                    String string2 = jSONObject2.getString("match");
                    if (string2.equalsIgnoreCase("above")) {
                        eVar.a(0);
                    } else if (string2.equalsIgnoreCase("equal")) {
                        eVar.a(1);
                    } else if (string2.equalsIgnoreCase("regular")) {
                        eVar.a(2);
                        arrayList.add(eVar);
                        i2++;
                        jSONArray = jSONArray2;
                        str4 = str6;
                    }
                    arrayList.add(eVar);
                    i2++;
                    jSONArray = jSONArray2;
                    str4 = str6;
                }
            } else {
                str2 = "apkversion";
            }
            String str7 = str4;
            ArrayList<f> arrayList2 = new ArrayList<>();
            if (jSONObject.has("systemprop")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("systemprop");
                int i3 = 0;
                while (i3 < jSONArray3.length()) {
                    JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                    f fVar = new f();
                    JSONArray jSONArray4 = jSONArray3;
                    fVar.a(jSONObject3.getString("key"));
                    fVar.c(jSONObject3.getString("value"));
                    String string3 = jSONObject3.getString(str5);
                    if (string3.equalsIgnoreCase("above")) {
                        str3 = str5;
                        fVar.a(0);
                    } else {
                        str3 = str5;
                        if (string3.equalsIgnoreCase("equal")) {
                            fVar.a(1);
                            fVar.b(jSONObject3.getString("regular"));
                            arrayList2.add(fVar);
                            i3++;
                            jSONArray3 = jSONArray4;
                            str5 = str3;
                        }
                    }
                    fVar.b(jSONObject3.getString("regular"));
                    arrayList2.add(fVar);
                    i3++;
                    jSONArray3 = jSONArray4;
                    str5 = str3;
                }
            }
            if (jSONObject.has("proxyswitch")) {
                try {
                    i = Integer.parseInt(jSONObject.getString("proxyswitch"));
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                b(i);
            }
            if (jSONObject.has("apkname")) {
                a(jSONObject.getString("apkname"));
            }
            if (jSONObject.has(str7)) {
                b(jSONObject.getString(str7));
            }
            String str8 = str2;
            if (jSONObject.has(str8)) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(str8);
                a(jSONObject4.optInt("from"), jSONObject4.optInt("to"));
            }
            if (arrayList.size() > 0) {
                a(arrayList);
            }
            if (arrayList2.size() > 0) {
                b(arrayList2);
            }
        } catch (Exception unused2) {
        }
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(ArrayList<e> arrayList) {
        this.d = arrayList;
    }

    public String b() {
        return this.g;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.g = str;
    }

    public void b(ArrayList<f> arrayList) {
        this.e = arrayList;
    }

    public a c() {
        return this.h;
    }

    public void c(String str) {
        this.b = str;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public ArrayList<e> f() {
        return this.d;
    }

    public int g() {
        return this.i;
    }

    public ArrayList<f> h() {
        return this.e;
    }

    public String toString() {
        return this.a;
    }
}
