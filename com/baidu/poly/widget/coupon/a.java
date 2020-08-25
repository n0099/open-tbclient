package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public boolean bIj;
    public List<C0277a> bIk;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0277a {
        public String af;
        public String bIl;
        public String bIm;
        public Long bIn;
        public String bIo;
        public int cf;
        public String icon;
        public int type;

        public C0277a() {
        }

        C0277a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bIl = jSONObject.optString("display_name");
                this.bIm = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.bIo = jSONObject.optString("host_marketing_detail");
                this.bIn = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cf = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bIk = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bIk.add(new C0277a(jSONObject));
                }
            }
            this.bIj = this.bIk.size() > 1;
        }
    }
}
