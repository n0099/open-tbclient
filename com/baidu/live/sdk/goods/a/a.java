package com.baidu.live.sdk.goods.a;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public JSONObject bAg;
    public String bAh;
    public String bAi;
    public String bAj;
    public long bAk;
    public long bAl;
    public String bAm;
    public String bAn;
    public int bAo;
    public double bAp;
    public double bAq;
    public String bAr;
    public String bAs;
    public int bAt;
    public String bAu;
    public String bAv;
    public String bAw;
    public String bAx;
    public boolean bAy;
    public boolean bAz;
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
            this.bAg = jSONObject.optJSONObject("slink");
            this.bAh = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bAi = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bAj = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bAk = jSONObject.optLong("v_start_time");
            this.bAl = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString(IntentConfig.NID);
            this.bAm = jSONObject.optString("c_status");
            this.bAn = jSONObject.optString("b_status");
            this.bAo = jSONObject.optInt("index_id");
            this.bAp = jSONObject.optDouble("reserve_price");
            this.bAq = jSONObject.optDouble("profit");
            this.bAr = jSONObject.optString("sale_num");
            this.bAs = jSONObject.optString("coupon");
            this.bAz = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bAt = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bAw = optJSONObject.optString("Android");
                this.bAx = optJSONObject.optString("h5");
            }
            this.bAy = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bAv = optJSONObject2.optString("na");
                this.bAu = optJSONObject2.optString("h5");
            }
        }
    }

    public static a X(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bAg = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bAt = jSONObject.optInt("goodsStatus");
        aVar.bAs = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bAz = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bAw = optJSONObject2.optString("Android");
            aVar.bAx = optJSONObject2.optString("h5");
        }
        aVar.bAy = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bAr = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bAv = optJSONObject3.optString("na");
            aVar.bAu = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean Sm() {
        return (TextUtils.isEmpty(this.bAs) || "0".equals(this.bAs)) ? false : true;
    }

    public boolean EC() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
