package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean bpS;
    public List<C0192a> bpT;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0192a {
        public String bpU;
        public String bpV;
        public String bpW;
        public Long bpX;
        public int bpY;
        public String bpZ;
        public String icon;
        public int type;

        public C0192a() {
        }

        C0192a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bpU = jSONObject.optString("display_name");
                this.bpV = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.bpW = jSONObject.optString("valid_info");
                this.bpZ = jSONObject.optString("host_marketing_detail");
                this.bpX = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.bpY = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bpT = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bpT.add(new C0192a(jSONObject));
                }
            }
            this.bpS = this.bpT.size() > 1;
        }
    }
}
