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
    public JSONObject blc;
    public String bld;
    public String ble;
    public String blf;
    public long blg;
    public long blh;
    public String bli;
    public String blj;
    public int blk;
    public double bll;
    public double blm;
    public String bln;
    public String blo;
    public int blp;
    public String blq;
    public String blr;
    public String bls;
    public String blt;
    public boolean blu;
    public boolean blv;
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
            this.blc = jSONObject.optJSONObject("slink");
            this.bld = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.ble = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.blf = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.blg = jSONObject.optLong("v_start_time");
            this.blh = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bli = jSONObject.optString("c_status");
            this.blj = jSONObject.optString("b_status");
            this.blk = jSONObject.optInt("index_id");
            this.bll = jSONObject.optDouble("reserve_price");
            this.blm = jSONObject.optDouble("profit");
            this.bln = jSONObject.optString("sale_num");
            this.blo = jSONObject.optString("coupon");
            this.blv = jSONObject.optInt("introduceStatus", 0) == 1;
            this.blp = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bls = optJSONObject.optString("Android");
                this.blt = optJSONObject.optString("h5");
            }
            this.blu = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.blr = optJSONObject2.optString("na");
                this.blq = optJSONObject2.optString("h5");
            }
        }
    }

    public static a P(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.blc = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.blp = jSONObject.optInt("goodsStatus");
        aVar.blo = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.blv = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bls = optJSONObject2.optString("Android");
            aVar.blt = optJSONObject2.optString("h5");
        }
        aVar.blu = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bln = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.blr = optJSONObject3.optString("na");
            aVar.blq = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean Nv() {
        return (TextUtils.isEmpty(this.blo) || "0".equals(this.blo)) ? false : true;
    }

    public boolean CL() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
