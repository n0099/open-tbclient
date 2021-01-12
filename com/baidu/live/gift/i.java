package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class i extends HttpMessage {
    public long aTI;
    public long aTJ;
    public String aTK;
    public String aTL;
    public long aTM;
    public String aTN;
    public Map<Long, Long> aTO;
    public BdUniqueId aTP;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public i() {
        super(1021015);
        this.aTO = new HashMap();
    }
}
