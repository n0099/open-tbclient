package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aj {
    public JSONObject auA;
    public String auB;
    public String auC;
    public String auD;
    public String auE;
    public long auF;
    public long auG;
    public String auH;
    public String auI;
    public int auJ;
    public String auK;
    public String auL;
    public String auM;
    public String auN;
    public String fromType;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auA = jSONObject.optJSONObject("slink");
            this.auB = jSONObject.optString("num_id");
            this.auC = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.auD = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.auE = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.auF = jSONObject.optLong("v_start_time");
            this.auG = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.auH = jSONObject.optString("c_status");
            this.auI = jSONObject.optString("b_status");
            this.auJ = jSONObject.optInt("index_id");
            this.auK = jSONObject.optString("reserve_price");
            this.auL = jSONObject.optString("profit");
            this.auM = jSONObject.optString("sale_num");
            this.auN = jSONObject.optString("coupon");
        }
    }
}
