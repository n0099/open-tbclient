package com.baidu.poly.widget;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class o implements Serializable {
    private String Qd;
    private String Rd;
    private String Sd;
    private int Td;
    private int Ud;
    private int Vd;
    private int Wd;
    private long Xd;
    private String Yd;
    private boolean Zd;
    private int _d;
    private long ae;
    private String be;
    private String ce;
    private String icon;
    private String pay_text;
    private int sa;

    public o(JSONObject jSONObject) {
        this.Qd = jSONObject.optString("display_name");
        this.Rd = jSONObject.optString("pay_channel");
        this.pay_text = jSONObject.optString("pay_text");
        this.Sd = jSONObject.optString("error_text");
        this.ae = jSONObject.optLong("available_par_money");
        this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.Td = jSONObject.optInt("is_fold");
        this.Ud = jSONObject.optInt("is_selected");
        this.Vd = jSONObject.optInt("is_private");
        this.Wd = jSONObject.optInt("free_pay");
        this.sa = jSONObject.optInt(com.baidu.fsg.face.base.b.c.l);
        this.Yd = jSONObject.optString("display_color");
        this.Zd = jSONObject.optBoolean("flow");
        this._d = jSONObject.optInt("parasitifer");
        this.be = jSONObject.optString("host_marketing_detail");
        this.Xd = jSONObject.optLong("pre_pay_money");
        this.ce = jSONObject.optString("loading_icon");
    }

    public long C() {
        return this.ae;
    }

    public String D() {
        return this.Yd;
    }

    public int E() {
        return this.sa;
    }

    public String F() {
        return this.be;
    }

    public int G() {
        return this.Ud;
    }

    public String H() {
        return this.ce;
    }

    public String I() {
        return this.Rd;
    }

    public String J() {
        return this.pay_text;
    }

    public String getDisplayName() {
        return this.Qd;
    }

    public String getIcon() {
        return this.icon;
    }

    public void h(int i) {
        this.Ud = i;
    }

    public void k(String str) {
        this.be = str;
    }

    public String toString() {
        return "PayChannelEntity{display_name='" + this.Qd + "', pay_channel='" + this.Rd + "', pay_text='" + this.pay_text + "', error_text='" + this.Sd + "', icon='" + this.icon + "', is_fold=" + this.Td + ", is_selected=" + this.Ud + ", is_private=" + this.Vd + ", free_pay=" + this.Wd + ", pre_pay_money=" + this.Xd + ", enable=" + this.sa + ", display_color='" + this.Yd + "', flow=" + this.Zd + ", parasitifer=" + this._d + '}';
    }
}
