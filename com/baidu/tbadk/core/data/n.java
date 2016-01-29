package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class n extends ah {
    public static final BdUniqueId Vv = BdUniqueId.gen();
    private PhotoLiveCardData Vw = null;

    public PhotoLiveCardData sd() {
        return this.Vw;
    }

    @Override // com.baidu.tbadk.core.data.ah
    public void a(ThreadInfo threadInfo) {
        super.a(threadInfo);
        if (threadInfo.twzhibo_info != null) {
            a(threadInfo.twzhibo_info);
        }
    }

    private void a(ZhiBoInfoTW zhiBoInfoTW) {
        if (zhiBoInfoTW != null) {
            if (this.Vw == null) {
                this.Vw = new PhotoLiveCardData();
            }
            this.Vw.parserProtobuf(zhiBoInfoTW);
            this.Vw.setShowExpressionViewIndexList(this.Vw.getExpressionDatas());
            if (StringUtils.isNull(getTid()) || getTid().equals("0")) {
                setId(String.valueOf(this.Vw.getThreadId()));
                cw(String.valueOf(this.Vw.getThreadId()));
            }
            if (StringUtils.isNull(tn())) {
                cx(this.Vw.getForumName());
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.ah, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vv;
    }
}
