package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class t extends x {
    public static final BdUniqueId Vz = BdUniqueId.gen();
    private PhotoLiveCardData VA;

    public PhotoLiveCardData a(x xVar) {
        if (this.VA == null) {
            if (xVar == null) {
                return null;
            }
            this.VA = new PhotoLiveCardData();
            MetaData author = xVar.getAuthor();
            if (author != null) {
                this.VA.setAuthorName(author.getUserName());
                this.VA.setAuthorPortrait(author.getPortrait());
                this.VA.setFansNum(author.getFansNum());
                this.VA.setNickName(author.getFansNickName());
                this.VA.setAuthorId(author.getUserId());
            }
            PraiseData praise = xVar.getPraise();
            if (praise != null) {
                this.VA.setPraiseNum((int) praise.getNum());
            }
            this.VA.setDiscussNum(xVar.getReply_num());
            this.VA.setPostNum(xVar.getPost_num());
            this.VA.setTitle(xVar.getTitle());
            this.VA.setLastModifiedTime(xVar.getLast_time_int());
            this.VA.setPhotoLiveCover(xVar.getPhotoLiveCover());
            this.VA.setContent(xVar.sr());
            this.VA.setThreadId(com.baidu.adp.lib.g.b.c(xVar.getTid(), 0L));
            this.VA.setHeadlive(xVar.isHeadLive());
            this.VA.setExpressionDatas(xVar.sz());
            if (this.VA.getShowStyle() < 0) {
                this.VA.setShowStyle(this.VA.getRandom(3, -1));
            }
            this.VA.getShowStyle();
            this.VA.setShowExpressionViewIndexList(this.VA.getExpressionDatas());
        }
        cm(xVar.getTid());
        setId(xVar.getId());
        bC(xVar.sv());
        cn(xVar.so());
        return this.VA;
    }

    public PhotoLiveCardData sh() {
        return this.VA;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vz;
    }
}
