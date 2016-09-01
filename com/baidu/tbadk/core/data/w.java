package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class w extends bg {
    public static final BdUniqueId QS = BdUniqueId.gen();
    private PhotoLiveCardData QT = null;

    public PhotoLiveCardData pM() {
        return this.QT;
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
            if (this.QT == null) {
                this.QT = new PhotoLiveCardData();
            }
            this.QT.parserProtobuf(zhiBoInfoTW);
            this.QT.setShowExpressionViewIndexList(this.QT.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.QT.getThreadId()));
                cs(String.valueOf(this.QT.getThreadId()));
            }
            if (StringUtils.isNull(getForum_name())) {
                setForum_name(this.QT.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return QS;
    }
}
