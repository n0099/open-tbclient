package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ag {
    public JSONObject abN;
    public String abO;
    public String abP;
    public String abQ;
    public String abR;
    public long abS;
    public long abT;
    public String abU;
    public String abV;
    public int abW;
    public String abX;
    public String abY;
    public String abZ;
    public String aca;
    public String fromType;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.abN = jSONObject.optJSONObject("slink");
            this.abO = jSONObject.optString("num_id");
            this.abP = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.abQ = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.abR = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.abS = jSONObject.optLong("v_start_time");
            this.abT = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.abU = jSONObject.optString("c_status");
            this.abV = jSONObject.optString("b_status");
            this.abW = jSONObject.optInt("index_id");
            this.abX = jSONObject.optString("reserve_price");
            this.abY = jSONObject.optString("profit");
            this.abZ = jSONObject.optString("sale_num");
            this.aca = jSONObject.optString("coupon");
        }
    }
}
