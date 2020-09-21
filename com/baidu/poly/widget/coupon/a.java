package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public boolean bKo;
    public List<C0275a> bKp;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0275a {
        public String af;
        public String bKq;
        public String bKr;
        public Long bKs;
        public String bKt;
        public int cf;
        public String icon;
        public int type;

        public C0275a() {
        }

        C0275a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bKq = jSONObject.optString("display_name");
                this.bKr = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.bKt = jSONObject.optString("host_marketing_detail");
                this.bKs = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cf = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bKp = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bKp.add(new C0275a(jSONObject));
                }
            }
            this.bKo = this.bKp.size() > 1;
        }
    }
}
