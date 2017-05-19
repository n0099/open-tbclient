package com.baidu.android.pushservice.config;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private String a;
    private String b;
    private int c;
    private ArrayList<d> d;
    private ArrayList<e> e;
    private String f;
    private String g;
    private a h;

    /* loaded from: classes2.dex */
    public class a {
        public int a;
        public int b;

        public a() {
        }
    }

    public c(String str) {
        this.a = str;
        d(str);
    }

    private void d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a(jSONObject.getString("manufacturer"));
            com.baidu.android.pushservice.e.a.c("Manufacturer", " manufacturer name " + b());
            String string = jSONObject.getString("mode");
            com.baidu.android.pushservice.e.a.c("Manufacturer", "mode " + string);
            if ("I".equalsIgnoreCase(string)) {
                a(ModeConfig.MODE_I);
            } else if ("I_HW".equalsIgnoreCase(string)) {
                a(ModeConfig.MODE_I_HW);
            } else if ("I_XM".equalsIgnoreCase(string)) {
                a(ModeConfig.MODE_I_XM);
            } else if ("C".equalsIgnoreCase(string)) {
                a(ModeConfig.MODE_C);
            } else {
                a(ModeConfig.MODE_O);
            }
            ArrayList<d> arrayList = new ArrayList<>();
            if (jSONObject.has("osversion")) {
                JSONArray jSONArray = jSONObject.getJSONArray("osversion");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    d dVar = new d();
                    dVar.a(jSONObject2.getString("key"));
                    com.baidu.android.pushservice.e.a.c("Manufacturer", " key " + dVar.a());
                    dVar.b(jSONObject2.getString("value"));
                    com.baidu.android.pushservice.e.a.c("Manufacturer", " value " + dVar.b());
                    String string2 = jSONObject2.getString("match");
                    if (string2.equalsIgnoreCase("above")) {
                        dVar.a(0);
                    } else if (string2.equalsIgnoreCase("equal")) {
                        dVar.a(1);
                    } else if (string2.equalsIgnoreCase("regular")) {
                        dVar.a(2);
                    }
                    arrayList.add(dVar);
                }
            }
            ArrayList<e> arrayList2 = new ArrayList<>();
            if (jSONObject.has("systemprop")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("systemprop");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    e eVar = new e();
                    eVar.a(jSONObject3.getString("key"));
                    eVar.b(jSONObject3.getString("value"));
                    String string3 = jSONObject3.getString("match");
                    if (string3.equalsIgnoreCase("above")) {
                        eVar.a(0);
                    } else if (string3.equalsIgnoreCase("equal")) {
                        eVar.a(1);
                    }
                    eVar.c(jSONObject3.getString("regular"));
                    arrayList2.add(eVar);
                }
            }
            if (jSONObject.has("apkname")) {
                b(jSONObject.getString("apkname"));
                com.baidu.android.pushservice.e.a.c("Manufacturer", " pkgname " + f());
            }
            if (jSONObject.has("apksign")) {
                c(jSONObject.getString("apksign"));
                com.baidu.android.pushservice.e.a.c("Manufacturer", "apkSign " + g());
            }
            if (jSONObject.has("apkversion")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("apkversion");
                a(jSONObject4.optInt("from"), jSONObject4.optInt("to"));
                com.baidu.android.pushservice.e.a.c("Manufacturer", "from " + a().a + " to " + a().b);
            }
            if (arrayList.size() > 0) {
                a(arrayList);
            }
            if (arrayList2.size() > 0) {
                b(arrayList2);
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.d("Manufacturer", " exception parseConfig for manufacture!");
        }
    }

    public a a() {
        return this.h;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(int i, int i2) {
        this.h = new a();
        this.h.a = i;
        this.h.b = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(ArrayList<d> arrayList) {
        this.d = arrayList;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.f = str;
    }

    public void b(ArrayList<e> arrayList) {
        this.e = arrayList;
    }

    public int c() {
        return this.c;
    }

    public void c(String str) {
        this.g = str;
    }

    public ArrayList<d> d() {
        return this.d;
    }

    public ArrayList<e> e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String toString() {
        return this.a;
    }
}
