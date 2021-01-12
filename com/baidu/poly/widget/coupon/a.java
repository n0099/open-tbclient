package com.baidu.poly.widget.coupon;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public boolean cmn;
    public List<C0308a> cmo;

    /* renamed from: com.baidu.poly.widget.coupon.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0308a {
        public String af;
        public String cmp;
        public String cmq;
        public Long cmr;
        public int cms;
        public String cmt;
        public String icon;
        public int type;

        public C0308a() {
        }

        C0308a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.cmp = jSONObject.optString("display_name");
                this.cmq = jSONObject.optString("pay_text");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.af = jSONObject.optString("valid_info");
                this.cmt = jSONObject.optString("host_marketing_detail");
                this.cmr = Long.valueOf(jSONObject.optLong("available_par_money"));
                this.cms = jSONObject.optInt("is_selected");
                this.type = jSONObject.optInt("type");
            }
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.cmo = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    this.cmo.add(new C0308a(jSONObject));
                }
            }
            this.cmn = this.cmo.size() > 1;
        }
    }
}
