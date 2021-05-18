package com.baidu.tbadk.core.feedManager;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.feedManager.PersonalizedReqIdl;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.z0.w;
import tbclient.Personalized.DataReq;
/* loaded from: classes3.dex */
public class FeedRecRequest extends NetMessage {
    public int loadType;
    public int needForumlist;
    public int pn;
    public int preAdThreadCount;
    public int requestTime;
    public String sourceFrom;
    public int suggestCount;
    public int threadCount;

    public FeedRecRequest() {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        this.requestTime = 0;
        this.sourceFrom = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.need_tags = 0;
        builder.load_type = Integer.valueOf(this.loadType);
        builder.page_thread_count = Integer.valueOf(this.threadCount);
        builder.pre_ad_thread_count = Integer.valueOf(this.preAdThreadCount);
        builder.pn = Integer.valueOf(this.pn);
        builder.sug_count = Integer.valueOf(this.suggestCount);
        builder.tag_code = 0;
        builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst()));
        builder.q_type = Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
        builder.need_forumlist = Integer.valueOf(this.needForumlist);
        builder.new_net_type = Integer.valueOf(j.I());
        builder.new_install = Integer.valueOf(TbadkCoreApplication.getInst().checkNewUser() ? 1 : 0);
        builder.request_times = Integer.valueOf(this.requestTime);
        builder.invoke_source = this.sourceFrom;
        PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getLoadType() {
        return this.loadType;
    }

    public int getNeedForumlist() {
        return this.needForumlist;
    }

    public void setLoadType(int i2) {
        this.loadType = i2;
    }

    public void setNeedForumlist(int i2) {
        if (i2 != 1) {
            this.needForumlist = 0;
        } else {
            this.needForumlist = i2;
        }
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setPreAdThreadCount(int i2) {
        this.preAdThreadCount = i2;
    }

    public void setRequestTime(int i2) {
        this.requestTime = i2;
    }

    public void setSourceFrom(String str) {
        this.sourceFrom = str;
    }

    public void setSuggestCount(int i2) {
        this.suggestCount = i2;
    }

    public void setThreadCount(int i2) {
        if (i2 > 0) {
            this.threadCount = i2;
        } else {
            this.threadCount = 0;
        }
    }
}
