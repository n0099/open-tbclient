package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import d.b.j0.x.e0.c;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbGoodsInfo;
/* loaded from: classes3.dex */
public class PbGoodsData extends c implements Serializable {
    public String goodsUrlH5;
    public String linkFrom;
    public String linkUrl;
    public String picUrl;
    public String price;
    public int sort;
    public String title;

    public void parseJson(JSONObject jSONObject) {
        try {
            this.title = jSONObject.optString("goods_title");
            this.picUrl = jSONObject.optString("goods_image");
            this.price = jSONObject.optString("goods_price");
            this.linkUrl = jSONObject.optString("goods_url");
            this.sort = jSONObject.optInt(QuickPersistConfigConst.KEY_SPLASH_SORT);
            this.linkFrom = jSONObject.optString("goods_from");
            this.goodsUrlH5 = jSONObject.optString("goods_url_h5");
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void parseProto(PbGoodsInfo pbGoodsInfo) {
        if (pbGoodsInfo == null) {
            return;
        }
        this.title = pbGoodsInfo.goods_title;
        this.picUrl = pbGoodsInfo.goods_image;
        this.price = pbGoodsInfo.goods_price;
        this.linkUrl = pbGoodsInfo.goods_url;
        this.sort = pbGoodsInfo.sort.intValue();
        this.linkFrom = pbGoodsInfo.goods_from;
        this.goodsUrlH5 = pbGoodsInfo.goods_url_h5;
    }

    @Override // d.b.j0.x.e0.c
    public int sort() {
        return this.sort;
    }
}
