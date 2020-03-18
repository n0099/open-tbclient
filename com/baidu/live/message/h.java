package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class h extends HttpMessage {
    public String ahj;
    public boolean awX;
    public long liveId;

    public h() {
        super(1021144);
        this.ahj = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("feed_id", this.ahj);
        addParam("live_goods_source", TbConfig.getSubappType());
    }
}
