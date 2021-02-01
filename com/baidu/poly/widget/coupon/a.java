package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public boolean cqF;
    public List<C0312a> cqG;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0312a {
        public String af;
        public String cqH;
        public String cqI;
        public Long cqJ;
        public int cqK;
        public String cqL;
        public String icon;
        public int type;

        public C0312a() {
        }

        C0312a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.cqH = jSONObject.optString("display_name");
                this.cqI = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.cqL = jSONObject.optString("host_marketing_detail");
                this.cqJ = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cqK = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.cqG = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.cqG.add(new C0312a(jSONObject));
                }
            }
            this.cqF = this.cqG.size() > 1;
        }
    }
}
