package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class f extends HttpMessage {
    public String WX;
    public boolean akj;
    public long liveId;

    public f() {
        super(1021144);
        this.WX = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("feed_id", this.WX);
        addParam("live_goods_source", TbConfig.getSubappType());
    }
}
