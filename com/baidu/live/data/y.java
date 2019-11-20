package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class y {
    public JSONObject SM;
    public String SO;
    public String SQ;
    public String SR;
    public String SS;
    public long ST;
    public long SU;
    public String SV;
    public String SW;
    public String SX;
    public int SY;
    public String SZ;
    public String Ta;
    public String Tb;
    public String Tc;
    public String fromType;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.SM = jSONObject.optJSONObject("slink");
            this.SO = jSONObject.optString("num_id");
            this.SQ = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.SR = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.SS = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.ST = jSONObject.optLong("v_start_time");
            this.SU = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.SV = jSONObject.optString("nid");
            this.SW = jSONObject.optString("c_status");
            this.SX = jSONObject.optString("b_status");
            this.SY = jSONObject.optInt("index_id");
            this.SZ = jSONObject.optString("reserve_price");
            this.Ta = jSONObject.optString("profit");
            this.Tb = jSONObject.optString("sale_num");
            this.Tc = jSONObject.optString("coupon");
        }
    }
}
