package com.baidu.live.sdk.goods.a;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public JSONObject byW;
    public String byX;
    public String byY;
    public String byZ;
    public long bza;
    public long bzb;
    public String bzc;
    public String bzd;
    public int bze;
    public double bzf;
    public double bzg;
    public String bzh;
    public String bzi;
    public int bzj;
    public String bzk;
    public String bzl;
    public String bzm;
    public String bzn;
    public boolean bzo;
    public boolean bzp;
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
            this.byW = jSONObject.optJSONObject("slink");
            this.byX = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.byY = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.byZ = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bza = jSONObject.optLong("v_start_time");
            this.bzb = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString(IntentConfig.NID);
            this.bzc = jSONObject.optString("c_status");
            this.bzd = jSONObject.optString("b_status");
            this.bze = jSONObject.optInt("index_id");
            this.bzf = jSONObject.optDouble("reserve_price");
            this.bzg = jSONObject.optDouble("profit");
            this.bzh = jSONObject.optString("sale_num");
            this.bzi = jSONObject.optString("coupon");
            this.bzp = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bzj = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bzm = optJSONObject.optString("Android");
                this.bzn = optJSONObject.optString("h5");
            }
            this.bzo = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bzl = optJSONObject2.optString("na");
                this.bzk = optJSONObject2.optString("h5");
            }
        }
    }

    public static a Y(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.byW = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bzj = jSONObject.optInt("goodsStatus");
        aVar.bzi = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bzp = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bzm = optJSONObject2.optString("Android");
            aVar.bzn = optJSONObject2.optString("h5");
        }
        aVar.bzo = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bzh = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bzl = optJSONObject3.optString("na");
            aVar.bzk = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean PQ() {
        return (TextUtils.isEmpty(this.bzi) || "0".equals(this.bzi)) ? false : true;
    }

    public boolean BU() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
