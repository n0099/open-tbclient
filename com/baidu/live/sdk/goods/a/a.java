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
    public JSONObject bqC;
    public String bqD;
    public String bqE;
    public String bqF;
    public long bqG;
    public long bqH;
    public String bqI;
    public String bqJ;
    public int bqK;
    public double bqL;
    public double bqM;
    public String bqN;
    public String bqO;
    public int bqP;
    public String bqQ;
    public String bqR;
    public String bqS;
    public String bqT;
    public boolean bqU;
    public boolean bqV;
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
            this.bqC = jSONObject.optJSONObject("slink");
            this.bqD = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bqE = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bqF = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bqG = jSONObject.optLong("v_start_time");
            this.bqH = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bqI = jSONObject.optString("c_status");
            this.bqJ = jSONObject.optString("b_status");
            this.bqK = jSONObject.optInt("index_id");
            this.bqL = jSONObject.optDouble("reserve_price");
            this.bqM = jSONObject.optDouble("profit");
            this.bqN = jSONObject.optString("sale_num");
            this.bqO = jSONObject.optString("coupon");
            this.bqV = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bqP = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bqS = optJSONObject.optString("Android");
                this.bqT = optJSONObject.optString("h5");
            }
            this.bqU = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bqR = optJSONObject2.optString("na");
                this.bqQ = optJSONObject2.optString("h5");
            }
        }
    }

    public static a Q(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bqC = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bqP = jSONObject.optInt("goodsStatus");
        aVar.bqO = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bqV = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bqS = optJSONObject2.optString("Android");
            aVar.bqT = optJSONObject2.optString("h5");
        }
        aVar.bqU = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bqN = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bqR = optJSONObject3.optString("na");
            aVar.bqQ = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean OY() {
        return (TextUtils.isEmpty(this.bqO) || "0".equals(this.bqO)) ? false : true;
    }

    public boolean DR() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
