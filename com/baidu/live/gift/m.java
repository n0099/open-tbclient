package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class m extends HttpMessage {
    public long aWP;
    public long aWQ;
    public String aWR;
    public String aWS;
    public long aWT;
    public String aWU;
    public Map<Long, Long> aWV;
    public BdUniqueId aWW;
    public double aXy;
    public double aXz;
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
        this.aWV = new HashMap();
    }

    public void b(double d, double d2) {
        this.aXy = d;
        this.aXz = d2;
        addParam("lng", this.aXy);
        addParam("lat", this.aXz);
    }
}
