package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public boolean cdv;
    public List<C0314a> cdw;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0314a {
        public String af;
        public String cdA;
        public String cdx;
        public String cdy;
        public Long cdz;
        public int cf;
        public String icon;
        public int type;

        public C0314a() {
        }

        C0314a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.cdx = jSONObject.optString("display_name");
                this.cdy = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.cdA = jSONObject.optString("host_marketing_detail");
                this.cdz = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cf = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.cdw = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.cdw.add(new C0314a(jSONObject));
                }
            }
            this.cdv = this.cdw.size() > 1;
        }
    }
}
