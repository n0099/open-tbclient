package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class r extends as {
    public static final BdUniqueId Tk = BdUniqueId.gen();
    private PhotoLiveCardData Tl = null;

    public PhotoLiveCardData rJ() {
        return this.Tl;
    }

    @Override // com.baidu.tbadk.core.data.as
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.Tl == null) {
                this.Tl = new PhotoLiveCardData();
            }
            this.Tl.parserProtobuf(zhiBoInfoTW);
            this.Tl.setShowExpressionViewIndexList(this.Tl.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.Tl.getThreadId()));
                cu(String.valueOf(this.Tl.getThreadId()));
            }
            if (StringUtils.isNull(tr())) {
                cv(this.Tl.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.as, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Tk;
    }
}
