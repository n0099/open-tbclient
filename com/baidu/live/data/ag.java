package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ag {
    public JSONObject abX;
    public String abY;
    public String abZ;
    public String aca;
    public String acb;
    public long acc;
    public long acd;
    public String ace;
    public String acf;
    public int acg;
    public String ach;
    public String aci;
    public String acj;
    public String acm;
    public String fromType;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.abX = jSONObject.optJSONObject("slink");
            this.abY = jSONObject.optString("num_id");
            this.abZ = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.aca = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.acb = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.acc = jSONObject.optLong("v_start_time");
            this.acd = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.ace = jSONObject.optString("c_status");
            this.acf = jSONObject.optString("b_status");
            this.acg = jSONObject.optInt("index_id");
            this.ach = jSONObject.optString("reserve_price");
            this.aci = jSONObject.optString("profit");
            this.acj = jSONObject.optString("sale_num");
            this.acm = jSONObject.optString("coupon");
        }
    }
}
