package com.baidu.live.sdk.goods.a;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public JSONObject bcF;
    public String bcG;
    public String bcH;
    public String bcI;
    public String bcJ;
    public long bcK;
    public long bcL;
    public String bcM;
    public String bcN;
    public int bcO;
    public String bcP;
    public String bcQ;
    public String bcR;
    public String bcS;
    public int bcT;
    public String bcU;
    public String bcV;
    public String fromType;
    public String imageUrl;
    public String nid;
    public String platform;
    public String price;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bcF = jSONObject.optJSONObject("slink");
            this.bcG = jSONObject.optString("num_id");
            this.bcH = jSONObject.optString("goods_id");
            this.title = jSONObject.optString("title");
            this.bcI = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.bcJ = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.bcK = jSONObject.optLong("v_start_time");
            this.bcL = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.bcM = jSONObject.optString("c_status");
            this.bcN = jSONObject.optString("b_status");
            this.bcO = jSONObject.optInt("index_id");
            this.bcP = jSONObject.optString("reserve_price");
            this.bcQ = jSONObject.optString("profit");
            this.bcR = jSONObject.optString("sale_num");
            this.bcS = jSONObject.optString("coupon");
        }
    }

    public static a K(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.bcF = jSONObject.optJSONObject("zhibo_url");
        aVar.bcH = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bcT = jSONObject.optInt("goodsStatus");
        aVar.bcS = jSONObject.optString("coupon");
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
        aVar.bcR = jSONObject.optString("sale_num");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject2 != null) {
            aVar.bcV = optJSONObject2.optString("na");
            aVar.bcU = optJSONObject2.optString("h5");
            return aVar;
        }
        return aVar;
    }

    public boolean Ha() {
        return (TextUtils.isEmpty(this.bcH) || TextUtils.equals("0", this.bcH)) ? false : true;
    }
}
