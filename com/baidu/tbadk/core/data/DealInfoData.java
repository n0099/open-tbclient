package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.DealAuthInfo;
import tbclient.DealInfo;
import tbclient.DealMedia;
/* loaded from: classes.dex */
public class DealInfoData implements Serializable {
    public static final int STATUS_DELETE = 4;
    public static final int STATUS_FAIL_REVIEW = 3;
    public static final int STATUS_OFF_SHELF = 0;
    public static final int STATUS_ON_SHELF = 1;
    public static final int STATUS_UNDER_REVIEW = 2;
    private static final long serialVersionUID = 820602053326042886L;
    public ArrayList<DealAuthInfoData> authInfo;
    public String des;
    public long expireTime;
    public boolean hasRecommend;
    public ArrayList<DealMediaData> media;
    public long productId;
    public long recommendations;
    public long sales;
    public String sellerAddress;
    public float shipFee;
    public int status;
    public long stock;
    public String title;
    public float unitPrice;

    public void parserProtobuf(DealInfo dealInfo) {
        if (dealInfo != null || EcommSwitchStatic.Fq()) {
            if (dealInfo.auth_info != null) {
                this.authInfo = new ArrayList<>();
                for (DealAuthInfo dealAuthInfo : dealInfo.auth_info) {
                    if (dealAuthInfo != null) {
                        DealAuthInfoData dealAuthInfoData = new DealAuthInfoData();
                        if (dealAuthInfo != null) {
                            dealAuthInfoData.itemContent = dealAuthInfo.item_content;
                            dealAuthInfoData.itemName = dealAuthInfo.item_name;
                            dealAuthInfoData.itemUrl = dealAuthInfo.item_url;
                            this.authInfo.add(dealAuthInfoData);
                        } else {
                            return;
                        }
                    }
                }
            }
            this.des = dealInfo.des;
            this.expireTime = dealInfo.expire_time.intValue();
            this.hasRecommend = dealInfo.has_recommend.booleanValue();
            if (dealInfo.media != null) {
                this.media = new ArrayList<>();
                for (DealMedia dealMedia : dealInfo.media) {
                    if (dealMedia != null) {
                        DealMediaData dealMediaData = new DealMediaData();
                        if (dealMedia != null) {
                            dealMediaData.bigPic = dealMedia.big_pic;
                            dealMediaData.smallPic = dealMedia.small_pic;
                            dealMediaData.type = dealMedia.type.intValue();
                            dealMediaData.waterPic = dealMedia.water_pic;
                            this.media.add(dealMediaData);
                        } else {
                            return;
                        }
                    }
                }
            }
            this.productId = dealInfo.product_id.longValue();
            this.recommendations = dealInfo.recommendations.longValue();
            this.sales = dealInfo.sales.longValue();
            this.sellerAddress = dealInfo.seller_address;
            this.shipFee = ((float) dealInfo.ship_fee.longValue()) / 100.0f;
            this.status = dealInfo.status.intValue();
            this.stock = dealInfo.stock.longValue();
            this.title = dealInfo.title;
            this.unitPrice = ((float) dealInfo.unit_price.longValue()) / 100.0f;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (EcommSwitchStatic.Fq() && jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("auth_info");
                if (optJSONArray != null) {
                    this.authInfo = new ArrayList<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        DealAuthInfoData dealAuthInfoData = new DealAuthInfoData();
                        dealAuthInfoData.parserJson(optJSONArray.optJSONObject(i));
                        this.authInfo.add(dealAuthInfoData);
                    }
                }
                this.des = jSONObject.optString("des");
                this.expireTime = jSONObject.optLong("expire_time");
                this.hasRecommend = jSONObject.optBoolean("has_recommend");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    this.media = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        DealMediaData dealMediaData = new DealMediaData();
                        dealMediaData.parserJson(optJSONArray2.optJSONObject(i2));
                        this.media.add(dealMediaData);
                    }
                }
                this.productId = jSONObject.optLong("product_id");
                this.recommendations = jSONObject.optLong("recommendations");
                this.sales = jSONObject.optLong("sales");
                this.sellerAddress = jSONObject.optString("seller_address");
                this.shipFee = ((float) jSONObject.optLong("ship_fee")) / 100.0f;
                this.status = jSONObject.optInt("status");
                this.stock = jSONObject.optLong("stock");
                this.title = jSONObject.optString("title");
                this.unitPrice = ((float) jSONObject.optLong("unit_price")) / 100.0f;
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
