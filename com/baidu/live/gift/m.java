package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class m extends HttpMessage {
    public long aTI;
    public long aTJ;
    public String aTK;
    public String aTL;
    public long aTM;
    public String aTN;
    public Map<Long, Long> aTO;
    public BdUniqueId aTP;
    public double aUq;
    public double aUr;
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
        this.aTO = new HashMap();
    }

    public void b(double d, double d2) {
        this.aUq = d;
        this.aUr = d2;
        addParam("lng", this.aUq);
        addParam("lat", this.aUr);
    }
}
