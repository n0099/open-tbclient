package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean bpX;
    public List<C0214a> bpY;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0214a {
        public String bpZ;
        public String bqa;
        public String bqb;
        public Long bqc;
        public int bqd;
        public String bqe;
        public String icon;
        public int type;

        public C0214a() {
        }

        C0214a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bpZ = jSONObject.optString("display_name");
                this.bqa = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.bqb = jSONObject.optString("valid_info");
                this.bqe = jSONObject.optString("host_marketing_detail");
                this.bqc = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.bqd = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bpY = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bpY.add(new C0214a(jSONObject));
                }
            }
            this.bpX = this.bpY.size() > 1;
        }
    }
}
