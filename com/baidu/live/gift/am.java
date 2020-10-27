package com.baidu.live.gift;

import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class am extends HttpMessage {
    public long aUe;
    public long aUf;
    public String aUg;
    public String aUh;
    public long aUi;
    public Map<Long, Long> aUk;
    public String aVt;
    public String giftId;
    public String giftName;
    public String liveId;
    public String otherParams;
    public String roomId;
    public String sceneFrom;

    public am() {
        super(1031055);
        this.aUk = new HashMap();
    }
}
