package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public boolean bQX;
    public List<C0290a> bQY;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0290a {
        public String af;
        public String bQZ;
        public String bRa;
        public Long bRb;
        public String bRc;
        public int cf;
        public String icon;
        public int type;

        public C0290a() {
        }

        C0290a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bQZ = jSONObject.optString("display_name");
                this.bRa = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.bRc = jSONObject.optString("host_marketing_detail");
                this.bRb = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cf = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bQY = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bQY.add(new C0290a(jSONObject));
                }
            }
            this.bQX = this.bQY.size() > 1;
        }
    }
}
