package com.baidu.live.gift;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes3.dex */
public class q extends HttpMessage {
    public int aFE;
    public String giftId;
    public String sceneFrom;

    public q() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        this.giftId = str;
        this.sceneFrom = com.baidu.live.utils.q.Id();
        this.aFE = i;
        addParam("scene_from", this.sceneFrom);
        addParam(LegoListActivityConfig.ITEM_ID, str);
        addParam("item_type", str2);
        addParam("platform", "2");
        addParam("benefit_uid", str3);
        addParam("live_id", str4);
        addParam("consume_amount", i);
        addParam("is_combo", i2);
        addParam("attach", str5);
    }
}
