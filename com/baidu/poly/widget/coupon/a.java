package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    public boolean csg;
    public List<C0318a> csh;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0318a {
        public String af;
        public String csi;
        public String csj;
        public Long csk;
        public int csl;
        public String csm;
        public String icon;
        public int type;

        public C0318a() {
        }

        C0318a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.csi = jSONObject.optString("display_name");
                this.csj = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.csm = jSONObject.optString("host_marketing_detail");
                this.csk = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.csl = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.csh = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.csh.add(new C0318a(jSONObject));
                }
            }
            this.csg = this.csh.size() > 1;
        }
    }
}
