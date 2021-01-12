package com.baidu.live.sdk.goods.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.BDxdConfig;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    public String aTK;
    public long authorId;
    public boolean bwd;
    public boolean isHost;
    public long liveId;
    public String source;
    public String tab;
    public String tag;

    public c() {
        super(1021144);
        this.aTK = "";
        this.liveId = 0L;
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("feed_id", this.aTK);
        addParam("anchor_id", this.authorId);
        addParam("live_goods_source", TbConfig.getSubappType());
        addParam("tab", this.tab);
        addParam("tag", this.tag);
        addParam("source", this.source);
        addParam(BDxdConfig.EXTRA_BDXD, BDxdConfig.getIns().getBdxd());
    }
}
