package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f1018a;
    private String b;
    private int c;
    private ArrayList<e> d;
    private ArrayList<f> e;
    private String f;
    private String g;
    private a h;
    private int i = 0;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1019a;
        public int b;

        public a() {
        }
    }

    public c(Context context, String str) {
        this.f1018a = str;
        a(context, str);
    }

    private void a(Context context, String str) {
        int i = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            a(jSONObject.getString(HttpConstants.HTTP_MANUFACTURER));
            String string = jSONObject.getString(UbcStatConstant.KEY_CONTENT_EXT_MODE);
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
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
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
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
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
            if (jSONObject.has("proxyswitch")) {
                try {
                    i = Integer.parseInt(jSONObject.getString("proxyswitch"));
                } catch (NumberFormatException e) {
                }
                b(i);
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
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
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
        this.h.f1019a = i;
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

    public void b(int i) {
        this.i = i;
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

    public int h() {
        return this.i;
    }

    public String toString() {
        return this.f1018a;
    }
}
