package com.baidu.helios.a.a;

import android.content.Context;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class f implements b {
    private JSONObject g;
    private Context h;
    private int c = 1;
    private h aqk = new e();
    private j aql = new n();
    private g aqm = new d();

    public f(Context context) {
        if (this.g == null) {
            a(context);
        }
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.aqk.a(this.h));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.aqm.a(this.h));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.aql.c(this.h));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("network", this.aql.d(this.h));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put(Config.INPUT_DEF_PKG, this.aql.b(this.h));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.aql.b());
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put(com.baidu.fsg.base.statistics.j.c, this.aql.a(this.h));
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.aql.a());
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("iid", this.aqk.e(this.h));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.aqk.ai(this.h));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.aqk.c(this.h));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.aqk.d(this.h));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        return jSONObject;
    }

    private void a(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.h == null) {
            this.h = context.getApplicationContext();
        }
        this.g = a();
    }

    @Override // com.baidu.helios.a.a.b
    public JSONObject uh() {
        if (this.g == null) {
            a(this.h);
        }
        return this.g;
    }
}
