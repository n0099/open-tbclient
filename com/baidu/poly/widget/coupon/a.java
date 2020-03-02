package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean aTF;
    public List<C0168a> aTG;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0168a {
        public String aTH;
        public String aTI;
        public String aTJ;
        public Long aTK;
        public int aTL;
        public String aTM;
        public String icon;
        public int type;

        public C0168a() {
        }

        C0168a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aTH = jSONObject.optString("display_name");
                this.aTI = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.aTJ = jSONObject.optString("valid_info");
                this.aTM = jSONObject.optString("host_marketing_detail");
                this.aTK = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.aTL = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aTG = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.aTG.add(new C0168a(jSONObject));
                }
            }
            this.aTF = this.aTG.size() > 1;
        }
    }
}
