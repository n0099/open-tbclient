package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean bxA;
    public List<C0247a> bxB;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0247a {
        public String bxC;
        public String bxD;
        public String bxE;
        public Long bxF;
        public int bxG;
        public String bxH;
        public String icon;
        public int type;

        public C0247a() {
        }

        C0247a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bxC = jSONObject.optString("display_name");
                this.bxD = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.bxE = jSONObject.optString("valid_info");
                this.bxH = jSONObject.optString("host_marketing_detail");
                this.bxF = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.bxG = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bxB = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bxB.add(new C0247a(jSONObject));
                }
            }
            this.bxA = this.bxB.size() > 1;
        }
    }
}
