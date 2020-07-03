package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class p extends HttpMessage {
    public long aHr;
    public long aHs;
    public String aHt;
    public String aHu;
    public long aHv;
    public Map<Long, Long> aHw;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public p() {
        super(1021014);
        this.aHw = new HashMap();
    }
}
