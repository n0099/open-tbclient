package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public boolean crd;
    public List<C0325a> cre;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0325a {
        public String af;
        public String crf;
        public String crg;
        public Long crh;
        public int cri;
        public String crj;
        public String icon;
        public int type;

        public C0325a() {
        }

        C0325a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.crf = jSONObject.optString("display_name");
                this.crg = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.crj = jSONObject.optString("host_marketing_detail");
                this.crh = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cri = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.cre = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.cre.add(new C0325a(jSONObject));
                }
            }
            this.crd = this.cre.size() > 1;
        }
    }
}
