package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bc extends bi {
    public static final BdUniqueId XP = BdUniqueId.gen();
    private PhotoLiveCardData XQ;

    public PhotoLiveCardData b(bi biVar, int i) {
        if (this.XQ == null) {
            if (biVar == null) {
                return null;
            }
            this.XQ = new PhotoLiveCardData();
            MetaData author = biVar.getAuthor();
            if (author != null) {
                this.XQ.setAuthorName(author.getUserName());
                this.XQ.setAuthorPortrait(author.getPortrait());
                this.XQ.setFansNum(author.getFansNum());
                this.XQ.setNickName(author.getFansNickName());
                this.XQ.setAuthorId(author.getUserId());
                this.XQ.setGodInfo(author.getGodInfo());
            }
            PraiseData se = biVar.se();
            if (se != null) {
                this.XQ.setPraiseNum((int) se.getNum());
            }
            this.XQ.setDiscussNum(biVar.sh());
            this.XQ.setPostNum(biVar.getPost_num());
            this.XQ.setTitle(biVar.getTitle());
            this.XQ.setLastModifiedTime(biVar.sj());
            this.XQ.setPhotoLiveCover(biVar.getPhotoLiveCover());
            this.XQ.setContent(biVar.sw());
            this.XQ.setThreadId(com.baidu.adp.lib.g.b.c(biVar.getTid(), 0L));
            this.XQ.setHeadlive(biVar.isHeadLive());
            this.XQ.setExpressionDatas(biVar.sH());
            if (this.XQ.getShowStyle() < 0) {
                this.XQ.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.XQ.setShowExpressionViewIndexList(this.XQ.getExpressionDatas());
        }
        cp(biVar.getTid());
        setId(biVar.getId());
        setThreadType(biVar.getThreadType());
        cv(biVar.st());
        return this.XQ;
    }

    public PhotoLiveCardData rK() {
        return this.XQ;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return XP;
    }
}
