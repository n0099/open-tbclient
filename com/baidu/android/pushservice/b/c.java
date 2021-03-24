package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f2696a;

    /* renamed from: b  reason: collision with root package name */
    public String f2697b;

    /* renamed from: c  reason: collision with root package name */
    public int f2698c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<e> f2699d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<f> f2700e;

    /* renamed from: f  reason: collision with root package name */
    public String f2701f;

    /* renamed from: g  reason: collision with root package name */
    public String f2702g;

    /* renamed from: h  reason: collision with root package name */
    public a f2703h;
    public int i = 0;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2704a;

        /* renamed from: b  reason: collision with root package name */
        public int f2705b;

        public a() {
        }
    }

    public c(Context context, String str) {
        this.f2696a = str;
        a(context, str);
    }

    private void a(Context context, String str) {
        String str2;
        int i;
        String str3;
        String str4 = "apksign";
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
                    fVar.b(jSONObject3.getString("value"));
                    String string3 = jSONObject3.getString(str5);
                    if (string3.equalsIgnoreCase("above")) {
                        str3 = str5;
                        fVar.a(0);
                    } else {
                        str3 = str5;
                        if (string3.equalsIgnoreCase("equal")) {
                            fVar.a(1);
                            fVar.c(jSONObject3.getString("regular"));
                            arrayList2.add(fVar);
                            i3++;
                            jSONArray3 = jSONArray4;
                            str5 = str3;
                        }
                    }
                    fVar.c(jSONObject3.getString("regular"));
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
                b(jSONObject.getString("apkname"));
            }
            if (jSONObject.has(str7)) {
                c(jSONObject.getString(str7));
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
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    public a a() {
        return this.f2703h;
    }

    public void a(int i) {
        this.f2698c = i;
    }

    public void a(int i, int i2) {
        a aVar = new a();
        this.f2703h = aVar;
        aVar.f2704a = i;
        aVar.f2705b = i2;
    }

    public void a(String str) {
        this.f2697b = str;
    }

    public void a(ArrayList<e> arrayList) {
        this.f2699d = arrayList;
    }

    public String b() {
        return this.f2697b;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.f2701f = str;
    }

    public void b(ArrayList<f> arrayList) {
        this.f2700e = arrayList;
    }

    public int c() {
        return this.f2698c;
    }

    public void c(String str) {
        this.f2702g = str;
    }

    public ArrayList<e> d() {
        return this.f2699d;
    }

    public ArrayList<f> e() {
        return this.f2700e;
    }

    public String f() {
        return this.f2701f;
    }

    public String g() {
        return this.f2702g;
    }

    public int h() {
        return this.i;
    }

    public String toString() {
        return this.f2696a;
    }
}
