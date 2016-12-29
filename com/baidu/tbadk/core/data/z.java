package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class z extends bg {
    public static final BdUniqueId Rq = BdUniqueId.gen();
    private PhotoLiveCardData Rr = null;

    public PhotoLiveCardData qb() {
        return this.Rr;
    }

    @Override // com.baidu.tbadk.core.data.bg
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.Rr == null) {
                this.Rr = new PhotoLiveCardData();
            }
            this.Rr.parserProtobuf(zhiBoInfoTW);
            this.Rr.setShowExpressionViewIndexList(this.Rr.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.Rr.getThreadId()));
                cw(String.valueOf(this.Rr.getThreadId()));
            }
            if (StringUtils.isNull(rK())) {
                cx(this.Rr.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Rq;
    }
}
