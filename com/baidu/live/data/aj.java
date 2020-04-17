package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aj {
    public long auA;
    public String auB;
    public String auC;
    public int auD;
    public String auE;
    public String auF;
    public String auG;
    public String auH;
    public JSONObject auu;
    public String auv;
    public String auw;
    public String aux;
    public String auy;
    public long auz;
    public String fromType;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auu = jSONObject.optJSONObject("slink");
            this.auv = jSONObject.optString("num_id");
            this.auw = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.aux = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.auy = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.auz = jSONObject.optLong("v_start_time");
            this.auA = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.auB = jSONObject.optString("c_status");
            this.auC = jSONObject.optString("b_status");
            this.auD = jSONObject.optInt("index_id");
            this.auE = jSONObject.optString("reserve_price");
            this.auF = jSONObject.optString("profit");
            this.auG = jSONObject.optString("sale_num");
            this.auH = jSONObject.optString("coupon");
        }
    }
}
