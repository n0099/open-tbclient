package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class h extends HttpMessage {
    public boolean aQG;
    public String azF;
    public long liveId;

    public h() {
        super(1021144);
        this.azF = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("feed_id", this.azF);
        addParam("live_goods_source", TbConfig.getSubappType());
    }
}
