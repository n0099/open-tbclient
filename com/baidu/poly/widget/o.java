package com.baidu.poly.widget;

import com.baidu.fsg.face.base.b.c;
import com.baidu.searchbox.live.interfaces.DI;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o implements Serializable {
    public String Xd;
    public String Yd;
    public String Zd;
    public int _d;
    public int ae;
    public int be;
    public int ce;
    public long de;
    public String ee;
    public boolean fe;
    public int ge;
    public long he;
    public String icon;
    public String ie;
    public String je;
    public String pay_text;
    public int wa;

    public o(JSONObject jSONObject) {
        this.Xd = jSONObject.optString("display_name");
        this.Yd = jSONObject.optString(DI.PAY_CHANNEL);
        this.pay_text = jSONObject.optString("pay_text");
        this.Zd = jSONObject.optString("error_text");
        this.he = jSONObject.optLong("available_par_money");
        this.icon = jSONObject.optString("icon");
        this._d = jSONObject.optInt("is_fold");
        this.ae = jSONObject.optInt("is_selected");
        this.be = jSONObject.optInt("is_private");
        this.ce = jSONObject.optInt("free_pay");
        this.wa = jSONObject.optInt(c.l);
        this.ee = jSONObject.optString("display_color");
        this.fe = jSONObject.optBoolean("flow");
        this.ge = jSONObject.optInt("parasitifer");
        this.ie = jSONObject.optString("host_marketing_detail");
        this.de = jSONObject.optLong("pre_pay_money");
        this.je = jSONObject.optString("loading_icon");
    }

    public long L() {
        return this.he;
    }

    public String M() {
        return this.ee;
    }

    public int N() {
        return this.wa;
    }

    public String O() {
        return this.ie;
    }

    public int P() {
        return this.ae;
    }

    public String Q() {
        return this.je;
    }

    public String R() {
        return this.Yd;
    }

    public String S() {
        return this.pay_text;
    }

    public String getDisplayName() {
        return this.Xd;
    }

    public String getIcon() {
        return this.icon;
    }

    public void i(int i2) {
        this.ae = i2;
    }

    public void l(String str) {
        this.ie = str;
    }

    public String toString() {
        return "PayChannelEntity{display_name='" + this.Xd + "', pay_channel='" + this.Yd + "', pay_text='" + this.pay_text + "', error_text='" + this.Zd + "', icon='" + this.icon + "', is_fold=" + this._d + ", is_selected=" + this.ae + ", is_private=" + this.be + ", free_pay=" + this.ce + ", pre_pay_money=" + this.de + ", enable=" + this.wa + ", display_color='" + this.ee + "', flow=" + this.fe + ", parasitifer=" + this.ge + '}';
    }
}
