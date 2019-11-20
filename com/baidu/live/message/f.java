package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class f extends HttpMessage {
    public String WE;
    public boolean ajR;
    public long liveId;

    public f() {
        super(1021144);
        this.WE = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("feed_id", this.WE);
        addParam("live_goods_source", TbConfig.getSubappType());
    }
}
