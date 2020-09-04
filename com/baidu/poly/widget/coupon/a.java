package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public boolean bIn;
    public List<C0277a> bIo;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0277a {
        public String af;
        public String bIp;
        public String bIq;
        public Long bIr;
        public String bIs;
        public int cf;
        public String icon;
        public int type;

        public C0277a() {
        }

        C0277a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bIp = jSONObject.optString("display_name");
                this.bIq = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.bIs = jSONObject.optString("host_marketing_detail");
                this.bIr = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cf = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bIo = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bIo.add(new C0277a(jSONObject));
                }
            }
            this.bIn = this.bIo.size() > 1;
        }
    }
}
