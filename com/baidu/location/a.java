package com.baidu.location;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f453a;
    public b b;
    private int c;
    private String d;
    private double e;
    private double f;
    private boolean g;
    private double h;
    private boolean i;
    private float j;
    private boolean k;
    private float l;
    private boolean m;
    private int n;
    private float o;
    private String p;
    private String q;
    private boolean r;
    private boolean s;
    private String t;
    private boolean u;

    public a() {
        this.c = 0;
        this.d = null;
        this.e = Double.MIN_VALUE;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = Double.MIN_VALUE;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = 0.0f;
        this.m = false;
        this.n = -1;
        this.o = -1.0f;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = null;
        this.f453a = null;
        this.u = false;
        this.b = new b(this);
    }

    public a(String str) {
        String str2;
        this.c = 0;
        this.d = null;
        this.e = Double.MIN_VALUE;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = Double.MIN_VALUE;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = 0.0f;
        this.m = false;
        this.n = -1;
        this.o = -1.0f;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = null;
        this.f453a = null;
        this.u = false;
        this.b = new b(this);
        if (str == null || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
            int parseInt = Integer.parseInt(jSONObject2.getString("error"));
            a(parseInt);
            a(jSONObject2.getString("time"));
            if (parseInt == 61) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                JSONObject jSONObject4 = jSONObject3.getJSONObject("point");
                a(Double.parseDouble(jSONObject4.getString("y")));
                b(Double.parseDouble(jSONObject4.getString("x")));
                b(Float.parseFloat(jSONObject3.getString("radius")));
                a(Float.parseFloat(jSONObject3.getString("s")));
                c(Float.parseFloat(jSONObject3.getString("d")));
                b(Integer.parseInt(jSONObject3.getString("n")));
            } else if (parseInt != 161) {
                if (parseInt == 66 || parseInt == 68) {
                    JSONObject jSONObject5 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("point");
                    a(Double.parseDouble(jSONObject6.getString("y")));
                    b(Double.parseDouble(jSONObject6.getString("x")));
                    b(Float.parseFloat(jSONObject5.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject5.getString("isCellChanged"))));
                }
            } else {
                JSONObject jSONObject7 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                JSONObject jSONObject8 = jSONObject7.getJSONObject("point");
                a(Double.parseDouble(jSONObject8.getString("y")));
                b(Double.parseDouble(jSONObject8.getString("x")));
                b(Float.parseFloat(jSONObject7.getString("radius")));
                if (jSONObject7.has("addr")) {
                    String string = jSONObject7.getString("addr");
                    this.b.g = string;
                    ap.a("baidu_location_service", string);
                    String[] split = string.split(",");
                    this.b.f467a = split[0];
                    this.b.b = split[1];
                    this.b.c = split[2];
                    this.b.d = split[3];
                    this.b.e = split[4];
                    this.b.f = split[5];
                    if ((this.b.f467a.contains("北京") && this.b.b.contains("北京")) || ((this.b.f467a.contains("上海") && this.b.b.contains("上海")) || ((this.b.f467a.contains("天津") && this.b.b.contains("天津")) || (this.b.f467a.contains("重庆") && this.b.b.contains("重庆"))))) {
                        ap.a("baidu_location_service", "true,beijing");
                        str2 = this.b.f467a;
                    } else {
                        str2 = this.b.f467a + this.b.b;
                    }
                    this.b.g = str2 + this.b.c + this.b.d + this.b.e;
                    this.r = true;
                } else {
                    this.r = false;
                    b((String) null);
                }
                if (jSONObject7.has("poi")) {
                    this.s = true;
                    this.q = jSONObject7.getJSONObject("poi").toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.c = 0;
            this.r = false;
        }
    }

    private void a(Boolean bool) {
        this.u = bool.booleanValue();
    }

    public double a() {
        return this.e;
    }

    public void a(double d) {
        this.e = d;
    }

    public void a(float f) {
        this.j = f;
        this.i = true;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public double b() {
        return this.f;
    }

    public void b(double d) {
        this.f = d;
    }

    public void b(float f) {
        this.l = f;
        this.k = true;
    }

    public void b(int i) {
        this.n = i;
    }

    public void b(String str) {
        this.t = str;
        this.r = true;
    }

    public float c() {
        return this.l;
    }

    public void c(float f) {
        this.o = f;
    }

    public int d() {
        return this.c;
    }

    public String e() {
        return this.b.g;
    }

    public String f() {
        return this.b.b;
    }

    public String g() {
        return this.b.c;
    }

    public String h() {
        return this.b.d;
    }
}
