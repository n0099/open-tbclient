package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class p extends HttpMessage {
    public long aWN;
    public long aWO;
    public String aWP;
    public String aWQ;
    public long aWR;
    public Map<Long, Long> aWT;
    public BdUniqueId aWU;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public p() {
        super(1021014);
        this.aWT = new HashMap();
    }
}
