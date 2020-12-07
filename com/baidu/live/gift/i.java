package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class i extends HttpMessage {
    public long aWP;
    public long aWQ;
    public String aWR;
    public String aWS;
    public long aWT;
    public String aWU;
    public Map<Long, Long> aWV;
    public BdUniqueId aWW;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public i() {
        super(1021015);
        this.aWV = new HashMap();
    }
}
