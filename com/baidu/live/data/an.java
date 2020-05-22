package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class an {
    public JSONObject azE;
    public String azF;
    public String azG;
    public String azH;
    public String azI;
    public long azJ;
    public long azK;
    public String azL;
    public String azM;
    public int azN;
    public String azO;
    public String azP;
    public String azQ;
    public String azR;
    public String fromType;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azE = jSONObject.optJSONObject("slink");
            this.azF = jSONObject.optString("num_id");
            this.azG = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.azH = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.azI = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.azJ = jSONObject.optLong("v_start_time");
            this.azK = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.azL = jSONObject.optString("c_status");
            this.azM = jSONObject.optString("b_status");
            this.azN = jSONObject.optInt("index_id");
            this.azO = jSONObject.optString("reserve_price");
            this.azP = jSONObject.optString("profit");
            this.azQ = jSONObject.optString("sale_num");
            this.azR = jSONObject.optString("coupon");
        }
    }
}
