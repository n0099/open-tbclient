package com.baidu.live.sdk.goods.a;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String bcA;
    public int bcB;
    public String bcC;
    public String bcD;
    public JSONObject bcn;
    public String bco;
    public String bcp;
    public String bcq;
    public String bcr;
    public long bcs;
    public long bct;
    public String bcu;
    public String bcv;
    public int bcw;
    public String bcx;
    public String bcy;
    public String bcz;
    public String fromType;
    public String imageUrl;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bcn = jSONObject.optJSONObject("slink");
            this.bco = jSONObject.optString("num_id");
            this.bcp = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.bcq = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bcr = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bcs = jSONObject.optLong("v_start_time");
            this.bct = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bcu = jSONObject.optString("c_status");
            this.bcv = jSONObject.optString("b_status");
            this.bcw = jSONObject.optInt("index_id");
            this.bcx = jSONObject.optString("reserve_price");
            this.bcy = jSONObject.optString("profit");
            this.bcz = jSONObject.optString("sale_num");
            this.bcA = jSONObject.optString("coupon");
        }
    }

    public static a K(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bcn = jSONObject.optJSONObject("zhibo_url");
        aVar.bcp = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bcB = jSONObject.optInt("goodsStatus");
        aVar.bcA = jSONObject.optString("coupon");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bcz = jSONObject.optString("sale_num");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject2 != null) {
            aVar.bcD = optJSONObject2.optString("na");
            aVar.bcC = optJSONObject2.optString("h5");
            return aVar;
        }
        return aVar;
    }

    public boolean GU() {
        return (TextUtils.isEmpty(this.bcp) || TextUtils.equals("0", this.bcp)) ? false : true;
    }
}
