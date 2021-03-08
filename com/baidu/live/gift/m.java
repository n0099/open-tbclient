package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class m extends HttpMessage {
    public double aYV;
    public double aYW;
    public long aYn;
    public long aYo;
    public String aYp;
    public String aYq;
    public long aYr;
    public String aYs;
    public Map<Long, Long> aYt;
    public BdUniqueId aYu;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;
    public String userId;
    public String userName;

    public m() {
        super(1021229);
        this.aYt = new HashMap();
    }

    public void b(double d, double d2) {
        this.aYV = d;
        this.aYW = d2;
        addParam("lng", this.aYV);
        addParam("lat", this.aYW);
    }
}
