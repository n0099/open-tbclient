package com.baidu.live.sdk.goods.a;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long bvA;
    public String bvB;
    public String bvC;
    public int bvD;
    public double bvE;
    public double bvF;
    public String bvG;
    public String bvH;
    public int bvI;
    public String bvJ;
    public String bvK;
    public String bvL;
    public String bvM;
    public boolean bvN;
    public boolean bvO;
    public JSONObject bvv;
    public String bvw;
    public String bvx;
    public String bvy;
    public long bvz;
    public String fromType;
    public String gid;
    public String imageUrl;
    public String nid;
    public String platform;
    public String price;
    public String source;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bvv = jSONObject.optJSONObject("slink");
            this.bvw = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bvx = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bvy = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bvz = jSONObject.optLong("v_start_time");
            this.bvA = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bvB = jSONObject.optString("c_status");
            this.bvC = jSONObject.optString("b_status");
            this.bvD = jSONObject.optInt("index_id");
            this.bvE = jSONObject.optDouble("reserve_price");
            this.bvF = jSONObject.optDouble("profit");
            this.bvG = jSONObject.optString("sale_num");
            this.bvH = jSONObject.optString("coupon");
            this.bvO = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bvI = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bvL = optJSONObject.optString("Android");
                this.bvM = optJSONObject.optString("h5");
            }
            this.bvN = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bvK = optJSONObject2.optString("na");
                this.bvJ = optJSONObject2.optString("h5");
            }
        }
    }

    public static a P(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bvv = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bvI = jSONObject.optInt("goodsStatus");
        aVar.bvH = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bvO = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bvL = optJSONObject2.optString("Android");
            aVar.bvM = optJSONObject2.optString("h5");
        }
        aVar.bvN = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bvG = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bvK = optJSONObject3.optString("na");
            aVar.bvJ = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean Rj() {
        return (TextUtils.isEmpty(this.bvH) || "0".equals(this.bvH)) ? false : true;
    }

    public boolean Fm() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
