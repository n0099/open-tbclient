package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class t extends az {
    public static final BdUniqueId NX = BdUniqueId.gen();
    private PhotoLiveCardData NY = null;

    public PhotoLiveCardData oU() {
        return this.NY;
    }

    @Override // com.baidu.tbadk.core.data.az
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.NY == null) {
                this.NY = new PhotoLiveCardData();
            }
            this.NY.parserProtobuf(zhiBoInfoTW);
            this.NY.setShowExpressionViewIndexList(this.NY.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.NY.getThreadId()));
                cr(String.valueOf(this.NY.getThreadId()));
            }
            if (StringUtils.isNull(getForum_name())) {
                setForum_name(this.NY.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return NX;
    }
}
