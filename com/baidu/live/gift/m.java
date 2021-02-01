package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class m extends HttpMessage {
    public long aWN;
    public long aWO;
    public String aWP;
    public String aWQ;
    public long aWR;
    public String aWS;
    public Map<Long, Long> aWT;
    public BdUniqueId aWU;
    public double aXv;
    public double aXw;
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
        this.aWT = new HashMap();
    }

    public void b(double d, double d2) {
        this.aXv = d;
        this.aXw = d2;
        addParam("lng", this.aXv);
        addParam("lat", this.aXw);
    }
}
