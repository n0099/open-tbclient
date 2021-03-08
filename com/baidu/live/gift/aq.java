package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class aq extends HttpMessage {
    public int aYZ;
    public long aYr;
    public Map<Long, Long> aYt;
    public long aZL;
    public String aZN;
    public String giftId;
    public String giftName;
    public String sceneFrom;

    public aq() {
        super(1031057);
        this.aYt = new HashMap();
    }

    public void c(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        this.giftId = str;
        this.sceneFrom = com.baidu.live.utils.t.Vx();
        this.aYZ = i;
        this.aZN = str6;
        this.aZL = j;
        addParam("scene_from", this.sceneFrom);
        addParam(LegoListActivityConfig.ITEM_ID, str);
        addParam("item_type", str2);
        addParam("platform", "2");
        addParam("benefit_uid", str3);
        addParam("live_id", str4);
        addParam("consume_amount", i);
        addParam("is_combo", i2);
        addParam("is_comboGift", i3);
        addParam("combo_groupid", j);
        addParam("attach", str5);
        addParam("benefit_info", com.baidu.live.utils.s.im(str6));
    }
}
