package com.baidu.tbadk.core.feedManager;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.feedManager.PersonalizedReqIdl;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.u;
import tbclient.Personalized.DataReq;
/* loaded from: classes.dex */
public class FeedRecRequest extends NetMessage {
    private int loadType;
    private int needForumlist;
    private int pn;
    private int preAdThreadCount;
    private int requestTime;
    private String sourceFrom;
    private int suggestCount;
    private int threadCount;

    public FeedRecRequest() {
        super(1003070, CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED);
        this.requestTime = 0;
        this.sourceFrom = "";
    }

    public void setLoadType(int i) {
        this.loadType = i;
    }

    public int getLoadType() {
        return this.loadType;
    }

    public void setThreadCount(int i) {
        if (i > 0) {
            this.threadCount = i;
        } else {
            this.threadCount = 0;
        }
    }

    public void setRequestTime(int i) {
        this.requestTime = i;
    }

    public void setPreAdThreadCount(int i) {
        this.preAdThreadCount = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setSuggestCount(int i) {
        this.suggestCount = i;
    }

    public void setNeedForumlist(int i) {
        if (i != 1) {
            this.needForumlist = 0;
        } else {
            this.needForumlist = i;
        }
    }

    public void setSourceFrom(String str) {
        this.sourceFrom = str;
    }

    public int getNeedForumlist() {
        return this.needForumlist;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        u.a(builder, true, false, true);
        builder.need_tags = 0;
        builder.load_type = Integer.valueOf(this.loadType);
        builder.page_thread_count = Integer.valueOf(this.threadCount);
        builder.pre_ad_thread_count = Integer.valueOf(this.preAdThreadCount);
        builder.pn = Integer.valueOf(this.pn);
        builder.sug_count = Integer.valueOf(this.suggestCount);
        builder.tag_code = 0;
        builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        builder.scr_dip = Double.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        builder.q_type = Integer.valueOf(au.boO().boP() ? 2 : 1);
        builder.need_forumlist = Integer.valueOf(this.needForumlist);
        builder.new_net_type = Integer.valueOf(j.netType());
        builder.new_install = Integer.valueOf(TbadkCoreApplication.getInst().checkNewUser() ? 1 : 0);
        builder.request_times = Integer.valueOf(this.requestTime);
        builder.invoke_source = this.sourceFrom;
        PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
