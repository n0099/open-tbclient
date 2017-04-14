package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bc extends bi {
    public static final BdUniqueId XO = BdUniqueId.gen();
    private PhotoLiveCardData XP;

    public PhotoLiveCardData b(bi biVar, int i) {
        if (this.XP == null) {
            if (biVar == null) {
                return null;
            }
            this.XP = new PhotoLiveCardData();
            MetaData author = biVar.getAuthor();
            if (author != null) {
                this.XP.setAuthorName(author.getUserName());
                this.XP.setAuthorPortrait(author.getPortrait());
                this.XP.setFansNum(author.getFansNum());
                this.XP.setNickName(author.getFansNickName());
                this.XP.setAuthorId(author.getUserId());
                this.XP.setGodInfo(author.getGodInfo());
            }
            PraiseData se = biVar.se();
            if (se != null) {
                this.XP.setPraiseNum((int) se.getNum());
            }
            this.XP.setDiscussNum(biVar.sh());
            this.XP.setPostNum(biVar.getPost_num());
            this.XP.setTitle(biVar.getTitle());
            this.XP.setLastModifiedTime(biVar.sj());
            this.XP.setPhotoLiveCover(biVar.getPhotoLiveCover());
            this.XP.setContent(biVar.sw());
            this.XP.setThreadId(com.baidu.adp.lib.g.b.c(biVar.getTid(), 0L));
            this.XP.setHeadlive(biVar.isHeadLive());
            this.XP.setExpressionDatas(biVar.sH());
            if (this.XP.getShowStyle() < 0) {
                this.XP.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.XP.setShowExpressionViewIndexList(this.XP.getExpressionDatas());
        }
        cp(biVar.getTid());
        setId(biVar.getId());
        setThreadType(biVar.getThreadType());
        cv(biVar.st());
        return this.XP;
    }

    public PhotoLiveCardData rK() {
        return this.XP;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return XO;
    }
}
