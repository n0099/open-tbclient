package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class y {
    public JSONObject Th;
    public String Ti;
    public String Tj;
    public String Tk;
    public String Tl;
    public long Tm;
    public long Tn;
    public String To;
    public String Tp;
    public String Tq;
    public int Tr;
    public String Ts;
    public String Tt;
    public String Tu;
    public String Tv;
    public String fromType;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Th = jSONObject.optJSONObject("slink");
            this.Ti = jSONObject.optString("num_id");
            this.Tj = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.Tk = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.Tl = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.Tm = jSONObject.optLong("v_start_time");
            this.Tn = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.To = jSONObject.optString("nid");
            this.Tp = jSONObject.optString("c_status");
            this.Tq = jSONObject.optString("b_status");
            this.Tr = jSONObject.optInt("index_id");
            this.Ts = jSONObject.optString("reserve_price");
            this.Tt = jSONObject.optString("profit");
            this.Tu = jSONObject.optString("sale_num");
            this.Tv = jSONObject.optString("coupon");
        }
    }
}
