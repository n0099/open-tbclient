package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public boolean aPf;
    public List<C0159a> aPg;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0159a {
        public String aPh;
        public String aPi;
        public String aPj;
        public Long aPk;
        public int aPl;
        public String aPm;
        public String icon;
        public int type;

        public C0159a() {
        }

        C0159a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aPh = jSONObject.optString("display_name");
                this.aPi = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.aPj = jSONObject.optString("valid_info");
                this.aPm = jSONObject.optString("host_marketing_detail");
                this.aPk = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.aPl = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aPg = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.aPg.add(new C0159a(jSONObject));
                }
            }
            this.aPf = this.aPg.size() > 1;
        }
    }
}
