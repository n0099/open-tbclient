package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbGoodsInfo;
/* loaded from: classes2.dex */
public class PbGoodsData extends com.baidu.tieba.card.data.d implements Serializable {
    public String goodsUrlH5;
    public String linkFrom;
    public String linkUrl;
    public String picUrl;
    public String price;
    public int sort;
    public String title;

    public void parseProto(PbGoodsInfo pbGoodsInfo) {
        if (pbGoodsInfo != null) {
            this.title = pbGoodsInfo.goods_title;
            this.picUrl = pbGoodsInfo.goods_image;
            this.price = pbGoodsInfo.goods_price;
            this.linkUrl = pbGoodsInfo.goods_url;
            this.sort = pbGoodsInfo.sort.intValue();
            this.linkFrom = pbGoodsInfo.goods_from;
            this.goodsUrlH5 = pbGoodsInfo.goods_url_h5;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.title = jSONObject.optString("goods_title");
            this.picUrl = jSONObject.optString("goods_image");
            this.price = jSONObject.optString("goods_price");
            this.linkUrl = jSONObject.optString("goods_url");
            this.sort = jSONObject.optInt(QuickPersistConfigConst.KEY_SPLASH_SORT);
            this.linkFrom = jSONObject.optString("goods_from");
            this.goodsUrlH5 = jSONObject.optString("goods_url_h5");
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.tieba.card.data.d
    public int sort() {
        return this.sort;
    }
}
