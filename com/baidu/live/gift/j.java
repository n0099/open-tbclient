package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class j extends HttpMessage {
    public long aPX;
    public long aPY;
    public String aPZ;
    public String aQa;
    public long aQb;
    public String aQc;
    public Map<Long, Long> aQd;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public j() {
        super(1021015);
        this.aQd = new HashMap();
    }
}
