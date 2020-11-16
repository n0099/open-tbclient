package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class am extends HttpMessage {
    public long aTL;
    public long aTM;
    public String aTN;
    public String aTO;
    public long aTP;
    public Map<Long, Long> aTR;
    public String aVa;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public am() {
        super(1031056);
        this.aTR = new HashMap();
    }
}
