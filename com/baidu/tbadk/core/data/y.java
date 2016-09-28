package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class y extends bi {
    public static final BdUniqueId QY = BdUniqueId.gen();
    private PhotoLiveCardData QZ = null;

    public PhotoLiveCardData pX() {
        return this.QZ;
    }

    @Override // com.baidu.tbadk.core.data.bi
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.QZ == null) {
                this.QZ = new PhotoLiveCardData();
            }
            this.QZ.parserProtobuf(zhiBoInfoTW);
            this.QZ.setShowExpressionViewIndexList(this.QZ.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.QZ.getThreadId()));
                cu(String.valueOf(this.QZ.getThreadId()));
            }
            if (StringUtils.isNull(getForum_name())) {
                setForum_name(this.QZ.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return QY;
    }
}
