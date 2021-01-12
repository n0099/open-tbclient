package com.baidu.live.sdk.goods.a;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String bvA;
    public String bvB;
    public int bvC;
    public double bvD;
    public double bvE;
    public String bvF;
    public String bvG;
    public int bvH;
    public String bvI;
    public String bvJ;
    public String bvK;
    public String bvL;
    public boolean bvM;
    public boolean bvN;
    public JSONObject bvu;
    public String bvv;
    public String bvw;
    public String bvx;
    public long bvy;
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
            this.bvu = jSONObject.optJSONObject("slink");
            this.bvv = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bvw = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bvx = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bvy = jSONObject.optLong("v_start_time");
            this.bvz = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString(IntentConfig.NID);
            this.bvA = jSONObject.optString("c_status");
            this.bvB = jSONObject.optString("b_status");
            this.bvC = jSONObject.optInt("index_id");
            this.bvD = jSONObject.optDouble("reserve_price");
            this.bvE = jSONObject.optDouble("profit");
            this.bvF = jSONObject.optString("sale_num");
            this.bvG = jSONObject.optString("coupon");
            this.bvN = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bvH = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bvK = optJSONObject.optString("Android");
                this.bvL = optJSONObject.optString("h5");
            }
            this.bvM = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bvJ = optJSONObject2.optString("na");
                this.bvI = optJSONObject2.optString("h5");
            }
        }
    }

    public static a X(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bvu = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bvH = jSONObject.optInt("goodsStatus");
        aVar.bvG = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bvN = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bvK = optJSONObject2.optString("Android");
            aVar.bvL = optJSONObject2.optString("h5");
        }
        aVar.bvM = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bvF = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bvJ = optJSONObject3.optString("na");
            aVar.bvI = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean Or() {
        return (TextUtils.isEmpty(this.bvG) || "0".equals(this.bvG)) ? false : true;
    }

    public boolean AH() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
