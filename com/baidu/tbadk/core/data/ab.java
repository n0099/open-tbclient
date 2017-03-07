package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class ab extends bj {
    public static final BdUniqueId VM = BdUniqueId.gen();
    private PhotoLiveCardData VN = null;

    public PhotoLiveCardData qm() {
        return this.VN;
    }

    @Override // com.baidu.tbadk.core.data.bj
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.VN == null) {
                this.VN = new PhotoLiveCardData();
            }
            this.VN.parserProtobuf(zhiBoInfoTW);
            this.VN.setShowExpressionViewIndexList(this.VN.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.VN.getThreadId()));
                ci(String.valueOf(this.VN.getThreadId()));
            }
            if (StringUtils.isNull(rV())) {
                co(this.VN.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return VM;
    }
}
