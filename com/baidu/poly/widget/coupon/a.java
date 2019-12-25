package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public boolean aOn;
    public List<C0157a> aOo;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0157a {
        public String aOp;
        public String aOq;
        public String aOr;
        public Long aOs;
        public int aOt;
        public String aOu;
        public String icon;
        public int type;

        public C0157a() {
        }

        C0157a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aOp = jSONObject.optString("display_name");
                this.aOq = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.aOr = jSONObject.optString("valid_info");
                this.aOu = jSONObject.optString("host_marketing_detail");
                this.aOs = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.aOt = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.aOo = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.aOo.add(new C0157a(jSONObject));
                }
            }
            this.aOn = this.aOo.size() > 1;
        }
    }
}
