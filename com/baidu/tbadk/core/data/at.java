package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class at extends az {
    public static final BdUniqueId PT = BdUniqueId.gen();
    private PhotoLiveCardData PU;

    public PhotoLiveCardData b(az azVar, int i) {
        if (this.PU == null) {
            if (azVar == null) {
                return null;
            }
            this.PU = new PhotoLiveCardData();
            MetaData author = azVar.getAuthor();
            if (author != null) {
                this.PU.setAuthorName(author.getUserName());
                this.PU.setAuthorPortrait(author.getPortrait());
                this.PU.setFansNum(author.getFansNum());
                this.PU.setNickName(author.getFansNickName());
                this.PU.setAuthorId(author.getUserId());
                this.PU.setGodInfo(author.getGodInfo());
            }
            PraiseData praise = azVar.getPraise();
            if (praise != null) {
                this.PU.setPraiseNum((int) praise.getNum());
            }
            this.PU.setDiscussNum(azVar.getReply_num());
            this.PU.setPostNum(azVar.getPost_num());
            this.PU.setTitle(azVar.getTitle());
            this.PU.setLastModifiedTime(azVar.getLast_time_int());
            this.PU.setPhotoLiveCover(azVar.getPhotoLiveCover());
            this.PU.setContent(azVar.qO());
            this.PU.setThreadId(com.baidu.adp.lib.h.b.c(azVar.getTid(), 0L));
            this.PU.setHeadlive(azVar.isHeadLive());
            this.PU.setExpressionDatas(azVar.qX());
            if (this.PU.getShowStyle() < 0) {
                this.PU.setShowStyle(this.PU.getRandom(3, i));
            }
            this.PU.setShowExpressionViewIndexList(this.PU.getExpressionDatas());
        }
        cr(azVar.getTid());
        setId(azVar.getId());
        setThreadType(azVar.getThreadType());
        setForum_name(azVar.getForum_name());
        return this.PU;
    }

    public PhotoLiveCardData qm() {
        return this.PU;
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return PT;
    }
}
