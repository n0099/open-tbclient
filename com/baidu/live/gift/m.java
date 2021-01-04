package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class m extends HttpMessage {
    public String aYA;
    public Map<Long, Long> aYB;
    public BdUniqueId aYC;
    public long aYv;
    public long aYw;
    public String aYx;
    public String aYy;
    public long aYz;
    public double aZd;
    public double aZe;
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
        this.aYB = new HashMap();
    }

    public void b(double d, double d2) {
        this.aZd = d;
        this.aZe = d2;
        addParam("lng", this.aZd);
        addParam("lat", this.aZe);
    }
}
