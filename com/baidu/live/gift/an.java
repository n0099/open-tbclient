package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class an extends HttpMessage {
    public long aVA;
    public Map<Long, Long> aVC;
    public String aWM;
    public int aWg;
    public String giftId;
    public String giftName;
    public String sceneFrom;

    public an() {
        super(1031057);
        this.aVC = new HashMap();
    }

    public void c(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        this.giftId = str;
        this.sceneFrom = com.baidu.live.utils.s.UK();
        this.aWg = i;
        this.aWM = str6;
        addParam("scene_from", this.sceneFrom);
        addParam(LegoListActivityConfig.ITEM_ID, str);
        addParam("item_type", str2);
        addParam("platform", "2");
        addParam("benefit_uid", str3);
        addParam("live_id", str4);
        addParam("consume_amount", i);
        addParam("is_combo", i2);
        addParam("attach", str5);
        addParam("benefit_info", com.baidu.live.utils.r.iI(str6));
    }
}
