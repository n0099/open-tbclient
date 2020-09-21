package com.baidu.live.gift;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class q extends HttpMessage {
    public int aQH;
    public long aQb;
    public Map<Long, Long> aQd;
    public String giftId;
    public String giftName;
    public String sceneFrom;

    public q() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
        this.aQd = new HashMap();
    }

    public void a(String str, String str2, String str3, String str4, int i, int i2, String str5, long j) {
        this.giftId = str;
        this.sceneFrom = com.baidu.live.utils.p.PR();
        this.aQH = i;
        addParam("scene_from", this.sceneFrom);
        addParam(LegoListActivityConfig.ITEM_ID, str);
        addParam("item_type", str2);
        addParam("platform", "2");
        addParam("benefit_uid", str3);
        addParam("live_id", str4);
        addParam("consume_amount", i);
        addParam("is_combo", i2);
        addParam("attach", str5);
        addParam("pk_id", j);
    }
}
