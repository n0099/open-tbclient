package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public boolean bCq;
    public List<C0253a> bCr;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0253a {
        public String bCs;
        public String bCt;
        public String bCu;
        public Long bCv;
        public int bCw;
        public String bCx;
        public String icon;
        public int type;

        public C0253a() {
        }

        C0253a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bCs = jSONObject.optString("display_name");
                this.bCt = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.bCu = jSONObject.optString("valid_info");
                this.bCx = jSONObject.optString("host_marketing_detail");
                this.bCv = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.bCw = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.bCr = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.bCr.add(new C0253a(jSONObject));
                }
            }
            this.bCq = this.bCr.size() > 1;
        }
    }
}
