package com.baidu.live.sdk.goods.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    public String aHt;
    public long authorId;
    public boolean bcT;
    public boolean isHost;
    public long liveId;

    public c() {
        super(1021144);
        this.aHt = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("feed_id", this.aHt);
        addParam("anchor_id", this.authorId);
        addParam("live_goods_source", TbConfig.getSubappType());
    }
}
