package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class k extends z {
    public static final BdUniqueId Vj = BdUniqueId.gen();
    private PhotoLiveCardData Vk = null;

    public PhotoLiveCardData rQ() {
        return this.Vk;
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
            if (this.Vk == null) {
                this.Vk = new PhotoLiveCardData();
            }
            this.Vk.parserProtobuf(zhiBoInfoTW);
            this.Vk.setShowExpressionViewIndexList(this.Vk.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.Vk.getThreadId()));
                cu(String.valueOf(this.Vk.getThreadId()));
            }
            if (StringUtils.isNull(sL())) {
                cv(this.Vk.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vj;
    }
}
