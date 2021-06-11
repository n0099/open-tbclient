package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f2754a;

    /* renamed from: b  reason: collision with root package name */
    public String f2755b;

    /* renamed from: c  reason: collision with root package name */
    public int f2756c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<e> f2757d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<f> f2758e;

    /* renamed from: f  reason: collision with root package name */
    public String f2759f;

    /* renamed from: g  reason: collision with root package name */
    public String f2760g;

    /* renamed from: h  reason: collision with root package name */
    public a f2761h;

    /* renamed from: i  reason: collision with root package name */
    public int f2762i = 0;

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2763a;

        /* renamed from: b  reason: collision with root package name */
        public int f2764b;

        public a() {
        }
    }

    public c(Context context, String str) {
        this.f2754a = str;
        a(context, str);
    }

    private void a(Context context, String str) {
        String str2;
        int i2;
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
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
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
                        i3++;
                        jSONArray = jSONArray2;
                        str4 = str6;
                    }
                    arrayList.add(eVar);
                    i3++;
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
                int i4 = 0;
                while (i4 < jSONArray3.length()) {
                    JSONObject jSONObject3 = jSONArray3.getJSONObject(i4);
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
                            i4++;
                            jSONArray3 = jSONArray4;
                            str5 = str3;
                        }
                    }
                    fVar.c(jSONObject3.getString("regular"));
                    arrayList2.add(fVar);
                    i4++;
                    jSONArray3 = jSONArray4;
                    str5 = str3;
                }
            }
            if (jSONObject.has("proxyswitch")) {
                try {
                    i2 = Integer.parseInt(jSONObject.getString("proxyswitch"));
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                b(i2);
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
        return this.f2761h;
    }

    public void a(int i2) {
        this.f2756c = i2;
    }

    public void a(int i2, int i3) {
        a aVar = new a();
        this.f2761h = aVar;
        aVar.f2763a = i2;
        aVar.f2764b = i3;
    }

    public void a(String str) {
        this.f2755b = str;
    }

    public void a(ArrayList<e> arrayList) {
        this.f2757d = arrayList;
    }

    public String b() {
        return this.f2755b;
    }

    public void b(int i2) {
        this.f2762i = i2;
    }

    public void b(String str) {
        this.f2759f = str;
    }

    public void b(ArrayList<f> arrayList) {
        this.f2758e = arrayList;
    }

    public int c() {
        return this.f2756c;
    }

    public void c(String str) {
        this.f2760g = str;
    }

    public ArrayList<e> d() {
        return this.f2757d;
    }

    public ArrayList<f> e() {
        return this.f2758e;
    }

    public String f() {
        return this.f2759f;
    }

    public String g() {
        return this.f2760g;
    }

    public int h() {
        return this.f2762i;
    }

    public String toString() {
        return this.f2754a;
    }
}
