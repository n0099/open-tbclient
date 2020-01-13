package com.baidu.live.data;

import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class af {
    public JSONObject ZS;
    public String ZT;
    public String ZU;
    public String ZV;
    public String ZW;
    public long ZX;
    public long ZY;
    public String ZZ;
    public String aaa;
    public int aab;
    public String aac;
    public String aae;
    public String aaf;
    public String aag;
    public String fromType;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ZS = jSONObject.optJSONObject("slink");
            this.ZT = jSONObject.optString("num_id");
            this.ZU = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.ZV = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.ZW = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.ZX = jSONObject.optLong("v_start_time");
            this.ZY = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.ZZ = jSONObject.optString("c_status");
            this.aaa = jSONObject.optString("b_status");
            this.aab = jSONObject.optInt("index_id");
            this.aac = jSONObject.optString("reserve_price");
            this.aae = jSONObject.optString("profit");
            this.aaf = jSONObject.optString("sale_num");
            this.aag = jSONObject.optString("coupon");
        }
    }
}
