package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class k extends z {
    public static final BdUniqueId VJ = BdUniqueId.gen();
    private PhotoLiveCardData VK = null;

    public PhotoLiveCardData rz() {
        return this.VK;
    }

    @Override // com.baidu.tbadk.core.data.z
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.VK == null) {
                this.VK = new PhotoLiveCardData();
            }
            this.VK.parserProtobuf(zhiBoInfoTW);
            this.VK.setShowExpressionViewIndexList(this.VK.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.VK.getThreadId()));
                cx(String.valueOf(this.VK.getThreadId()));
            }
            if (StringUtils.isNull(sv())) {
                cy(this.VK.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return VJ;
    }
}
