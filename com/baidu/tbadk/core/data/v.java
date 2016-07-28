package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class v extends be {
    public static final BdUniqueId Og = BdUniqueId.gen();
    private PhotoLiveCardData Oh = null;

    public PhotoLiveCardData oJ() {
        return this.Oh;
    }

    @Override // com.baidu.tbadk.core.data.be
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.Oh == null) {
                this.Oh = new PhotoLiveCardData();
            }
            this.Oh.parserProtobuf(zhiBoInfoTW);
            this.Oh.setShowExpressionViewIndexList(this.Oh.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.Oh.getThreadId()));
                cr(String.valueOf(this.Oh.getThreadId()));
            }
            if (StringUtils.isNull(getForum_name())) {
                setForum_name(this.Oh.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Og;
    }
}
