package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class j extends HttpMessage {
    public long aIM;
    public long aIN;
    public String aIO;
    public String aIP;
    public long aIQ;
    public Map<Long, Long> aIR;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public j() {
        super(1021015);
        this.aIR = new HashMap();
    }
}
