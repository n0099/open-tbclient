package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class j extends HttpMessage {
    public long aTi;
    public long aTj;
    public String aTk;
    public String aTl;
    public long aTm;
    public String aTn;
    public Map<Long, Long> aTo;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public j() {
        super(1021015);
        this.aTo = new HashMap();
    }
}
