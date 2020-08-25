package com.baidu.poly.widget;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o implements Serializable {
    private String Wd;
    private String Xd;
    private String Yd;
    private int Zd;
    private int _d;
    private int ae;
    private int be;
    private long ce;

    /* renamed from: de  reason: collision with root package name */
    private String f971de;
    private boolean ee;
    private int fe;
    private long ge;
    private String he;
    private String icon;
    private String ie;
    private String pay_text;
    private int va;

    public o(JSONObject jSONObject) {
        this.Wd = jSONObject.optString("display_name");
        this.Xd = jSONObject.optString("pay_channel");
        this.pay_text = jSONObject.optString("pay_text");
        this.Yd = jSONObject.optString("error_text");
        this.ge = jSONObject.optLong("available_par_money");
        this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.Zd = jSONObject.optInt("is_fold");
        this._d = jSONObject.optInt("is_selected");
        this.ae = jSONObject.optInt("is_private");
        this.be = jSONObject.optInt("free_pay");
        this.va = jSONObject.optInt(com.baidu.fsg.face.base.b.c.l);
        this.f971de = jSONObject.optString("display_color");
        this.ee = jSONObject.optBoolean("flow");
        this.fe = jSONObject.optInt("parasitifer");
        this.he = jSONObject.optString("host_marketing_detail");
        this.ce = jSONObject.optLong("pre_pay_money");
        this.ie = jSONObject.optString("loading_icon");
    }

    public long L() {
        return this.ge;
    }

    public String M() {
        return this.f971de;
    }

    public int N() {
        return this.va;
    }

    public String O() {
        return this.he;
    }

    public int P() {
        return this._d;
    }

    public String Q() {
        return this.ie;
    }

    public String R() {
        return this.Xd;
    }

    public String S() {
        return this.pay_text;
    }

    public String getDisplayName() {
        return this.Wd;
    }

    public String getIcon() {
        return this.icon;
    }

    public void i(int i) {
        this._d = i;
    }

    public void l(String str) {
        this.he = str;
    }

    public String toString() {
        return "PayChannelEntity{display_name='" + this.Wd + "', pay_channel='" + this.Xd + "', pay_text='" + this.pay_text + "', error_text='" + this.Yd + "', icon='" + this.icon + "', is_fold=" + this.Zd + ", is_selected=" + this._d + ", is_private=" + this.ae + ", free_pay=" + this.be + ", pre_pay_money=" + this.ce + ", enable=" + this.va + ", display_color='" + this.f971de + "', flow=" + this.ee + ", parasitifer=" + this.fe + '}';
    }
}
