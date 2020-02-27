package com.baidu.android.pushservice.b;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private String a;
    private String b;
    private int c;
    private ArrayList<e> d;
    private ArrayList<f> e;
    private String f;
    private String g;
    private a h;

    /* loaded from: classes8.dex */
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
            } else if ("C".equalsIgnoreCase(string)) {
                a(2);
            } else {
                a(0);
            }
            ArrayList<e> arrayList = new ArrayList<>();
            if (jSONObject.has("osversion")) {
                JSONArray jSONArray = jSONObject.getJSONArray("osversion");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    e eVar = new e();
                    eVar.a(jSONObject2.getString("key"));
                    eVar.b(jSONObject2.getString("value"));
                    String string2 = jSONObject2.getString("match");
                    if (string2.equalsIgnoreCase("above")) {
                        eVar.a(0);
                    } else if (string2.equalsIgnoreCase("equal")) {
                        eVar.a(1);
                    } else if (string2.equalsIgnoreCase("regular")) {
                        eVar.a(2);
                    }
                    arrayList.add(eVar);
                }
            }
            ArrayList<f> arrayList2 = new ArrayList<>();
            if (jSONObject.has("systemprop")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("systemprop");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    f fVar = new f();
                    fVar.a(jSONObject3.getString("key"));
                    fVar.b(jSONObject3.getString("value"));
                    String string3 = jSONObject3.getString("match");
                    if (string3.equalsIgnoreCase("above")) {
                        fVar.a(0);
                    } else if (string3.equalsIgnoreCase("equal")) {
                        fVar.a(1);
                    }
                    fVar.c(jSONObject3.getString("regular"));
                    arrayList2.add(fVar);
                }
            }
            if (jSONObject.has("apkname")) {
                b(jSONObject.getString("apkname"));
            }
            if (jSONObject.has("apksign")) {
                c(jSONObject.getString("apksign"));
            }
            if (jSONObject.has("apkversion")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("apkversion");
                a(jSONObject4.optInt("from"), jSONObject4.optInt("to"));
            }
            if (arrayList.size() > 0) {
                a(arrayList);
            }
            if (arrayList2.size() > 0) {
                b(arrayList2);
            }
        } catch (Exception e) {
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

    public void a(ArrayList<e> arrayList) {
        this.d = arrayList;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.f = str;
    }

    public void b(ArrayList<f> arrayList) {
        this.e = arrayList;
    }

    public int c() {
        return this.c;
    }

    public void c(String str) {
        this.g = str;
    }

    public ArrayList<e> d() {
        return this.d;
    }

    public ArrayList<f> e() {
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
