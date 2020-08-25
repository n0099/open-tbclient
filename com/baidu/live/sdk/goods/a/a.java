package com.baidu.live.sdk.goods.a;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public JSONObject bic;
    public String bie;
    public String bif;
    public String bih;
    public long bii;
    public long bij;
    public String bik;
    public String bil;
    public int bim;
    public double bin;
    public double bip;
    public String biq;
    public String bir;
    public int bis;
    public String bit;
    public String biu;
    public String biv;
    public String biw;
    public boolean bix;
    public boolean biy;
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
            this.bic = jSONObject.optJSONObject("slink");
            this.bie = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bif = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bih = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bii = jSONObject.optLong("v_start_time");
            this.bij = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bik = jSONObject.optString("c_status");
            this.bil = jSONObject.optString("b_status");
            this.bim = jSONObject.optInt("index_id");
            this.bin = jSONObject.optDouble("reserve_price");
            this.bip = jSONObject.optDouble("profit");
            this.biq = jSONObject.optString("sale_num");
            this.bir = jSONObject.optString("coupon");
            this.biy = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bis = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.biv = optJSONObject.optString("Android");
                this.biw = optJSONObject.optString("h5");
            }
            this.bix = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.biu = optJSONObject2.optString("na");
                this.bit = optJSONObject2.optString("h5");
            }
        }
    }

    public static a M(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bic = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bis = jSONObject.optInt("goodsStatus");
        aVar.bir = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.biy = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.biv = optJSONObject2.optString("Android");
            aVar.biw = optJSONObject2.optString("h5");
        }
        aVar.bix = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.biq = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.biu = optJSONObject3.optString("na");
            aVar.bit = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean MR() {
        return (TextUtils.isEmpty(this.bir) || "0".equals(this.bir)) ? false : true;
    }

    public boolean Cw() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
