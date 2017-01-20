package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class aa extends bh {
    public static final BdUniqueId Qz = BdUniqueId.gen();
    private PhotoLiveCardData QA = null;

    public PhotoLiveCardData pU() {
        return this.QA;
    }

    @Override // com.baidu.tbadk.core.data.bh
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.QA == null) {
                this.QA = new PhotoLiveCardData();
            }
            this.QA.parserProtobuf(zhiBoInfoTW);
            this.QA.setShowExpressionViewIndexList(this.QA.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.QA.getThreadId()));
                cu(String.valueOf(this.QA.getThreadId()));
            }
            if (StringUtils.isNull(rB())) {
                cv(this.QA.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Qz;
    }
}
