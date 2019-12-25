package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes2.dex */
public class h extends HttpMessage {
    public String aej;
    public boolean arP;
    public long liveId;

    public h() {
        super(1021144);
        this.aej = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("feed_id", this.aej);
        addParam("live_goods_source", TbConfig.getSubappType());
    }
}
