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
    public long bAA;
    public long bAB;
    public String bAC;
    public String bAD;
    public int bAE;
    public double bAF;
    public double bAG;
    public String bAH;
    public String bAI;
    public int bAJ;
    public String bAK;
    public String bAL;
    public String bAM;
    public String bAN;
    public boolean bAO;
    public boolean bAP;
    public JSONObject bAw;
    public String bAx;
    public String bAy;
    public String bAz;
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
            this.bAw = jSONObject.optJSONObject("slink");
            this.bAx = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bAy = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bAz = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bAA = jSONObject.optLong("v_start_time");
            this.bAB = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString(IntentConfig.NID);
            this.bAC = jSONObject.optString("c_status");
            this.bAD = jSONObject.optString("b_status");
            this.bAE = jSONObject.optInt("index_id");
            this.bAF = jSONObject.optDouble("reserve_price");
            this.bAG = jSONObject.optDouble("profit");
            this.bAH = jSONObject.optString("sale_num");
            this.bAI = jSONObject.optString("coupon");
            this.bAP = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bAJ = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bAM = optJSONObject.optString("Android");
                this.bAN = optJSONObject.optString("h5");
            }
            this.bAO = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bAL = optJSONObject2.optString("na");
                this.bAK = optJSONObject2.optString("h5");
            }
        }
    }

    public static a aa(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bAw = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bAJ = jSONObject.optInt("goodsStatus");
        aVar.bAI = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bAP = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bAM = optJSONObject2.optString("Android");
            aVar.bAN = optJSONObject2.optString("h5");
        }
        aVar.bAO = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bAH = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bAL = optJSONObject3.optString("na");
            aVar.bAK = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean PT() {
        return (TextUtils.isEmpty(this.bAI) || "0".equals(this.bAI)) ? false : true;
    }

    public boolean BX() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
