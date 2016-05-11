package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ar extends ax {
    public static final BdUniqueId PH = BdUniqueId.gen();
    private PhotoLiveCardData PI;

    public PhotoLiveCardData b(ax axVar, int i) {
        if (this.PI == null) {
            if (axVar == null) {
                return null;
            }
            this.PI = new PhotoLiveCardData();
            MetaData author = axVar.getAuthor();
            if (author != null) {
                this.PI.setAuthorName(author.getUserName());
                this.PI.setAuthorPortrait(author.getPortrait());
                this.PI.setFansNum(author.getFansNum());
                this.PI.setNickName(author.getFansNickName());
                this.PI.setAuthorId(author.getUserId());
                this.PI.setGodInfo(author.getGodInfo());
            }
            PraiseData praise = axVar.getPraise();
            if (praise != null) {
                this.PI.setPraiseNum((int) praise.getNum());
            }
            this.PI.setDiscussNum(axVar.getReply_num());
            this.PI.setPostNum(axVar.getPost_num());
            this.PI.setTitle(axVar.getTitle());
            this.PI.setLastModifiedTime(axVar.getLast_time_int());
            this.PI.setPhotoLiveCover(axVar.getPhotoLiveCover());
            this.PI.setContent(axVar.qS());
            this.PI.setThreadId(com.baidu.adp.lib.h.b.c(axVar.getTid(), 0L));
            this.PI.setHeadlive(axVar.isHeadLive());
            this.PI.setExpressionDatas(axVar.rb());
            if (this.PI.getShowStyle() < 0) {
                this.PI.setShowStyle(this.PI.getRandom(3, i));
            }
            this.PI.setShowExpressionViewIndexList(this.PI.getExpressionDatas());
        }
        cr(axVar.getTid());
        setId(axVar.getId());
        setThreadType(axVar.getThreadType());
        cs(axVar.qP());
        return this.PI;
    }

    public PhotoLiveCardData qs() {
        return this.PI;
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return PH;
    }
}
