package com.baidu.poly.widget;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n implements Serializable {
    private String Jd;
    private String Kd;
    private String Ld;
    private int Md;
    private int Nd;
    private int Od;
    private int Pd;
    private long Qd;
    private String Rd;
    private boolean Sd;
    private int Td;
    private long Ud;
    private String Vd;
    private String Wd;
    private String icon;
    private String pay_text;
    private int qa;

    public n(JSONObject jSONObject) {
        this.Jd = jSONObject.optString("display_name");
        this.Kd = jSONObject.optString("pay_channel");
        this.pay_text = jSONObject.optString("pay_text");
        this.Ld = jSONObject.optString("error_text");
        this.Ud = jSONObject.optLong("available_par_money");
        this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.Md = jSONObject.optInt("is_fold");
        this.Nd = jSONObject.optInt("is_selected");
        this.Od = jSONObject.optInt("is_private");
        this.Pd = jSONObject.optInt("free_pay");
        this.qa = jSONObject.optInt(com.baidu.fsg.face.base.b.c.l);
        this.Rd = jSONObject.optString("display_color");
        this.Sd = jSONObject.optBoolean("flow");
        this.Td = jSONObject.optInt("parasitifer");
        this.Vd = jSONObject.optString("host_marketing_detail");
        this.Qd = jSONObject.optLong("pre_pay_money");
        this.Wd = jSONObject.optString("loading_icon");
    }

    public String getIcon() {
        return this.icon;
    }

    public void h(int i) {
        this.Nd = i;
    }

    public void j(String str) {
        this.Vd = str;
    }

    public long r() {
        return this.Ud;
    }

    public String s() {
        return this.Rd;
    }

    public String t() {
        return this.Jd;
    }

    public String toString() {
        return "PayChannelEntity{display_name='" + this.Jd + "', pay_channel='" + this.Kd + "', pay_text='" + this.pay_text + "', error_text='" + this.Ld + "', icon='" + this.icon + "', is_fold=" + this.Md + ", is_selected=" + this.Nd + ", is_private=" + this.Od + ", free_pay=" + this.Pd + ", pre_pay_money=" + this.Qd + ", enable=" + this.qa + ", display_color='" + this.Rd + "', flow=" + this.Sd + ", parasitifer=" + this.Td + '}';
    }

    public int u() {
        return this.qa;
    }

    public String v() {
        return this.Vd;
    }

    public int w() {
        return this.Nd;
    }

    public String x() {
        return this.Wd;
    }

    public String y() {
        return this.Kd;
    }

    public String z() {
        return this.pay_text;
    }
}
