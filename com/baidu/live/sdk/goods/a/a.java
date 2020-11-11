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
    public JSONObject brV;
    public String brW;
    public String brX;
    public String brY;
    public long brZ;
    public long bsa;
    public String bsb;
    public String bsc;
    public int bsd;
    public double bse;
    public double bsf;
    public String bsg;
    public String bsh;
    public int bsi;
    public String bsj;
    public String bsk;
    public String bsl;
    public String bsm;
    public boolean bsn;
    public boolean bso;
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
            this.brV = jSONObject.optJSONObject("slink");
            this.brW = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.brX = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.brY = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.brZ = jSONObject.optLong("v_start_time");
            this.bsa = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bsb = jSONObject.optString("c_status");
            this.bsc = jSONObject.optString("b_status");
            this.bsd = jSONObject.optInt("index_id");
            this.bse = jSONObject.optDouble("reserve_price");
            this.bsf = jSONObject.optDouble("profit");
            this.bsg = jSONObject.optString("sale_num");
            this.bsh = jSONObject.optString("coupon");
            this.bso = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bsi = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bsl = optJSONObject.optString("Android");
                this.bsm = optJSONObject.optString("h5");
            }
            this.bsn = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bsk = optJSONObject2.optString("na");
                this.bsj = optJSONObject2.optString("h5");
            }
        }
    }

    public static a T(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.brV = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bsi = jSONObject.optInt("goodsStatus");
        aVar.bsh = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bso = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bsl = optJSONObject2.optString("Android");
            aVar.bsm = optJSONObject2.optString("h5");
        }
        aVar.bsn = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bsg = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bsk = optJSONObject3.optString("na");
            aVar.bsj = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean Py() {
        return (TextUtils.isEmpty(this.bsh) || "0".equals(this.bsh)) ? false : true;
    }

    public boolean Ek() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
