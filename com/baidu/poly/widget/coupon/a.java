package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    public boolean cjZ;
    public List<C0325a> cka;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0325a {
        public String af;
        public String ckb;
        public String ckc;
        public Long ckd;
        public int cke;
        public String ckf;
        public String icon;
        public int type;

        public C0325a() {
        }

        C0325a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.ckb = jSONObject.optString("display_name");
                this.ckc = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.ckf = jSONObject.optString("host_marketing_detail");
                this.ckd = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cke = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.cka = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.cka.add(new C0325a(jSONObject));
                }
            }
            this.cjZ = this.cka.size() > 1;
        }
    }
}
