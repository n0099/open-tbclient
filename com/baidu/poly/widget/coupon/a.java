package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public boolean cfg;
    public List<C0316a> cfh;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0316a {
        public String af;
        public int cf;
        public String cfi;
        public String cfj;
        public Long cfk;
        public String cfl;
        public String icon;
        public int type;

        public C0316a() {
        }

        C0316a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.cfi = jSONObject.optString("display_name");
                this.cfj = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.cfl = jSONObject.optString("host_marketing_detail");
                this.cfk = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cf = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.cfh = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.cfh.add(new C0316a(jSONObject));
                }
            }
            this.cfg = this.cfh.size() > 1;
        }
    }
}
