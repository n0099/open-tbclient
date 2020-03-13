package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean aTG;
    public List<C0168a> aTH;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0168a {
        public String aTI;
        public String aTJ;
        public String aTK;
        public Long aTL;
        public int aTM;
        public String aTN;
        public String icon;
        public int type;

        public C0168a() {
        }

        C0168a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aTI = jSONObject.optString("display_name");
                this.aTJ = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.aTK = jSONObject.optString("valid_info");
                this.aTN = jSONObject.optString("host_marketing_detail");
                this.aTL = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.aTM = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aTH = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.aTH.add(new C0168a(jSONObject));
                }
            }
            this.aTG = this.aTH.size() > 1;
        }
    }
}
