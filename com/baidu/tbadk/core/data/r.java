package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class r extends ax {
    public static final BdUniqueId NY = BdUniqueId.gen();
    private PhotoLiveCardData NZ = null;

    public PhotoLiveCardData pc() {
        return this.NZ;
    }

    @Override // com.baidu.tbadk.core.data.ax
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.NZ == null) {
                this.NZ = new PhotoLiveCardData();
            }
            this.NZ.parserProtobuf(zhiBoInfoTW);
            this.NZ.setShowExpressionViewIndexList(this.NZ.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.NZ.getThreadId()));
                cr(String.valueOf(this.NZ.getThreadId()));
            }
            if (StringUtils.isNull(qP())) {
                cs(this.NZ.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return NY;
    }
}
