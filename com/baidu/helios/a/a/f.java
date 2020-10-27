package com.baidu.helios.a.a;

import android.content.Context;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class f implements b {
    private JSONObject g;
    private Context h;
    private int c = 1;
    private h axJ = new e();
    private j axK = new n();
    private g axL = new d();

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
            jSONObject.put("aid", this.axJ.a(this.h));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.axL.a(this.h));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.axK.c(this.h));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("network", this.axK.d(this.h));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put(Config.INPUT_DEF_PKG, this.axK.b(this.h));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.axK.b());
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put(com.baidu.fsg.base.statistics.j.c, this.axK.a(this.h));
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.axK.a());
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("iid", this.axJ.e(this.h));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.axJ.an(this.h));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.axJ.c(this.h));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.axJ.d(this.h));
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
    public JSONObject As() {
        if (this.g == null) {
            a(this.h);
        }
        return this.g;
    }
}
