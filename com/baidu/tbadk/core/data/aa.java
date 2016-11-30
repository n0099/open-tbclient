package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class aa extends bk {
    public static final BdUniqueId Rt = BdUniqueId.gen();
    private PhotoLiveCardData Ru = null;

    public PhotoLiveCardData qa() {
        return this.Ru;
    }

    @Override // com.baidu.tbadk.core.data.bk
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.Ru == null) {
                this.Ru = new PhotoLiveCardData();
            }
            this.Ru.parserProtobuf(zhiBoInfoTW);
            this.Ru.setShowExpressionViewIndexList(this.Ru.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.Ru.getThreadId()));
                cw(String.valueOf(this.Ru.getThreadId()));
            }
            if (StringUtils.isNull(getForum_name())) {
                setForum_name(this.Ru.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Rt;
    }
}
