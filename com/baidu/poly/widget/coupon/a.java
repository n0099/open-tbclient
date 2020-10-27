package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public boolean bZu;
    public List<C0304a> bZv;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0304a {
        public String af;
        public String bZw;
        public String bZx;
        public Long bZy;
        public String bZz;
        public int cf;
        public String icon;
        public int type;

        public C0304a() {
        }

        C0304a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bZw = jSONObject.optString("display_name");
                this.bZx = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.bZz = jSONObject.optString("host_marketing_detail");
                this.bZy = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cf = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bZv = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bZv.add(new C0304a(jSONObject));
                }
            }
            this.bZu = this.bZv.size() > 1;
        }
    }
}
