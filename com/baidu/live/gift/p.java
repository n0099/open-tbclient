package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class p extends HttpMessage {
    public long aYn;
    public long aYo;
    public String aYp;
    public String aYq;
    public long aYr;
    public Map<Long, Long> aYt;
    public BdUniqueId aYu;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public p() {
        super(1021014);
        this.aYt = new HashMap();
    }
}
