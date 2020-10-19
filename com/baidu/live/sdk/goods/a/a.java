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
    public JSONObject boP;
    public String boQ;
    public String boR;
    public String boS;
    public long boT;
    public long boU;
    public String boV;
    public String boW;
    public int boX;
    public double boY;
    public double boZ;
    public String bpa;
    public String bpb;
    public int bpc;
    public String bpd;
    public String bpe;
    public String bpf;
    public String bpg;
    public boolean bph;
    public boolean bpi;
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
            this.boP = jSONObject.optJSONObject("slink");
            this.boQ = jSONObject.optString("num_id");
            this.gid = jSONObject.optString("gid");
            this.title = jSONObject.optString("title");
            this.boR = jSONObject.optString("original_title");
            this.price = jSONObject.optString("price");
            this.boS = jSONObject.optString(TbConfig.IMAGE_CACHE_DIR_NAME);
            this.boT = jSONObject.optLong("v_start_time");
            this.boU = jSONObject.optLong("v_end_time");
            this.fromType = jSONObject.optString("from_type");
            this.source = jSONObject.optString("user_name");
            this.platform = jSONObject.optString("platform");
            this.nid = jSONObject.optString("nid");
            this.boV = jSONObject.optString("c_status");
            this.boW = jSONObject.optString("b_status");
            this.boX = jSONObject.optInt("index_id");
            this.boY = jSONObject.optDouble("reserve_price");
            this.boZ = jSONObject.optDouble("profit");
            this.bpa = jSONObject.optString("sale_num");
            this.bpb = jSONObject.optString("coupon");
            this.bpi = jSONObject.optInt("introduceStatus", 0) == 1;
            this.bpc = jSONObject.optInt("goodsStatus");
            JSONObject optJSONObject = jSONObject.optJSONObject("skip_url");
            if (optJSONObject != null) {
                this.bpf = optJSONObject.optString("Android");
                this.bpg = optJSONObject.optString("h5");
            }
            this.bph = jSONObject.optInt("is_jump_outside", 0) == 1;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("zhibo_url");
            if (optJSONObject2 != null) {
                this.bpe = optJSONObject2.optString("na");
                this.bpd = optJSONObject2.optString("h5");
            }
        }
    }

    public static a O(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.boP = jSONObject.optJSONObject("zhibo_url");
        aVar.gid = jSONObject.optString("gid");
        aVar.price = jSONObject.optString("price");
        aVar.bpc = jSONObject.optInt("goodsStatus");
        aVar.bpb = jSONObject.optString("coupon");
        aVar.source = jSONObject.optString("user_name");
        aVar.platform = jSONObject.optString("platform");
        aVar.title = jSONObject.optString("title");
        aVar.fromType = jSONObject.optString("from_type");
        aVar.bpi = jSONObject.optInt("introduceStatus", 0) == 1;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("skip_url");
        if (optJSONObject2 != null) {
            aVar.bpf = optJSONObject2.optString("Android");
            aVar.bpg = optJSONObject2.optString("h5");
        }
        aVar.bph = jSONObject.optInt("is_jump_outside", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray(MapController.ITEM_LAYER_TAG);
        if (optJSONArray != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            String optString = optJSONObject.optString("url");
            if (!TextUtils.isEmpty(optString) && !optString.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                aVar.imageUrl = SapiUtils.COOKIE_HTTPS_URL_PREFIX + optString;
            } else {
                aVar.imageUrl = optString;
            }
        }
        aVar.bpa = jSONObject.optString("sale_num");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("zhibo_url");
        if (optJSONObject3 != null) {
            aVar.bpe = optJSONObject3.optString("na");
            aVar.bpd = optJSONObject3.optString("h5");
        }
        return aVar;
    }

    public boolean OA() {
        return (TextUtils.isEmpty(this.bpb) || "0".equals(this.bpb)) ? false : true;
    }

    public boolean DI() {
        return (TextUtils.isEmpty(this.gid) || TextUtils.equals("0", this.gid)) ? false : true;
    }
}
