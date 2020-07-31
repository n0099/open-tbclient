package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public boolean bCI;
    public List<C0256a> bCJ;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0256a {
        public String af;
        public String bCK;
        public String bCL;
        public Long bCM;
        public int bCN;
        public String bCO;
        public String icon;
        public int type;

        public C0256a() {
        }

        C0256a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bCK = jSONObject.optString("display_name");
                this.bCL = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.bCO = jSONObject.optString("host_marketing_detail");
                this.bCM = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.bCN = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bCJ = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bCJ.add(new C0256a(jSONObject));
                }
            }
            this.bCI = this.bCJ.size() > 1;
        }
    }
}
