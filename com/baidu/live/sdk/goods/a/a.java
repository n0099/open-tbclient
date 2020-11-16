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
    public String bqA;
    public String bqB;
    public boolean bqC;
    public boolean bqD;
    public JSONObject bqk;
    public String bql;
    public String bqm;
    public String bqn;
    public long bqo;
    public long bqp;
    public String bqq;
    public String bqr;
    public int bqs;
    public double bqt;
    public double bqu;
    public String bqv;
    public String bqw;
    public int bqx;
    public String bqy;
    public String bqz;
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
            this.bqk = jSONObject.optJSONObject("slink");
            this.bql = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bqm = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bqn = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bqo = jSONObject.optLong("v_start_time");
            this.bqp = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bqq = jSONObject.optString("c_status");
            this.bqr = jSONObject.optString("b_status");
            this.bqs = jSONObject.optInt("index_id");
            this.bqt = jSONObject.optDouble("reserve_price");
            this.bqu = jSONObject.optDouble("profit");
            this.bqv = jSONObject.optString("sale_num");
            this.bqw = jSONObject.optString("coupon");
            this.bqD = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bqx = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bqA = optJSONObject.optString("Android");
                this.bqB = optJSONObject.optString("h5");
            }
            this.bqC = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bqz = optJSONObject2.optString("na");
                this.bqy = optJSONObject2.optString("h5");
            }
        }
    }

    public static a N(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bqk = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bqx = jSONObject.optInt("goodsStatus");
        aVar.bqw = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bqD = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bqA = optJSONObject2.optString("Android");
            aVar.bqB = optJSONObject2.optString("h5");
        }
        aVar.bqC = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bqv = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bqz = optJSONObject3.optString("na");
            aVar.bqy = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean OP() {
        return (TextUtils.isEmpty(this.bqw) || "0".equals(this.bqw)) ? false : true;
    }

    public boolean DB() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
