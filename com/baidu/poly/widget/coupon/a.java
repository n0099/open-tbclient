package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean aTT;
    public List<C0168a> aTU;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0168a {
        public String aTV;
        public String aTW;
        public String aTX;
        public Long aTY;
        public int aTZ;
        public String aUa;
        public String icon;
        public int type;

        public C0168a() {
        }

        C0168a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aTV = jSONObject.optString("display_name");
                this.aTW = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.aTX = jSONObject.optString("valid_info");
                this.aUa = jSONObject.optString("host_marketing_detail");
                this.aTY = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.aTZ = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aTU = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.aTU.add(new C0168a(jSONObject));
                }
            }
            this.aTT = this.aTU.size() > 1;
        }
    }
}
