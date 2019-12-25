package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ab {
    public JSONObject ZF;
    public String ZG;
    public String ZH;
    public String ZI;
    public String ZJ;
    public long ZK;
    public long ZL;
    public String ZM;
    public String ZN;
    public int ZO;
    public String ZP;
    public String ZQ;
    public String ZR;
    public String ZS;
    public String fromType;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ZF = jSONObject.optJSONObject("slink");
            this.ZG = jSONObject.optString("num_id");
            this.ZH = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.ZI = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.ZJ = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.ZK = jSONObject.optLong("v_start_time");
            this.ZL = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.ZM = jSONObject.optString("c_status");
            this.ZN = jSONObject.optString("b_status");
            this.ZO = jSONObject.optInt("index_id");
            this.ZP = jSONObject.optString("reserve_price");
            this.ZQ = jSONObject.optString("profit");
            this.ZR = jSONObject.optString("sale_num");
            this.ZS = jSONObject.optString("coupon");
        }
    }
}
