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
    public boolean biA;
    public boolean biB;
    public JSONObject bih;
    public String bii;
    public String bij;
    public String bik;
    public long bil;
    public long bim;
    public String bin;
    public String bip;
    public int biq;
    public double bir;
    public double bis;
    public String bit;
    public String biu;
    public int biv;
    public String biw;
    public String bix;
    public String biy;
    public String biz;
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
            this.bih = jSONObject.optJSONObject("slink");
            this.bii = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.bij = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bik = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bil = jSONObject.optLong("v_start_time");
            this.bim = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bin = jSONObject.optString("c_status");
            this.bip = jSONObject.optString("b_status");
            this.biq = jSONObject.optInt("index_id");
            this.bir = jSONObject.optDouble("reserve_price");
            this.bis = jSONObject.optDouble("profit");
            this.bit = jSONObject.optString("sale_num");
            this.biu = jSONObject.optString("coupon");
            this.biB = jSONObject.optInt("introduceStatus", 0) == 1;
            this.biv = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.biy = optJSONObject.optString("Android");
                this.biz = optJSONObject.optString("h5");
            }
            this.biA = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bix = optJSONObject2.optString("na");
                this.biw = optJSONObject2.optString("h5");
            }
        }
    }

    public static a M(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bih = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.biv = jSONObject.optInt("goodsStatus");
        aVar.biu = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.biB = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.biy = optJSONObject2.optString("Android");
            aVar.biz = optJSONObject2.optString("h5");
        }
        aVar.biA = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bit = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bix = optJSONObject3.optString("na");
            aVar.biw = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean MR() {
        return (TextUtils.isEmpty(this.biu) || "0".equals(this.biu)) ? false : true;
    }

    public boolean Cw() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
