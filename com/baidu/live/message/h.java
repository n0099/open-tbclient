package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class h extends HttpMessage {
    public String aeS;
    public boolean asB;
    public long liveId;

    public h() {
        super(1021144);
        this.aeS = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("feed_id", this.aeS);
        addParam("live_goods_source", TbConfig.getSubappType());
    }
}
