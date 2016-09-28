package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bc extends bi {
    public static final BdUniqueId Tf = BdUniqueId.gen();
    private PhotoLiveCardData Tg;

    public PhotoLiveCardData b(bi biVar, int i) {
        if (this.Tg == null) {
            if (biVar == null) {
                return null;
            }
            this.Tg = new PhotoLiveCardData();
            MetaData author = biVar.getAuthor();
            if (author != null) {
                this.Tg.setAuthorName(author.getUserName());
                this.Tg.setAuthorPortrait(author.getPortrait());
                this.Tg.setFansNum(author.getFansNum());
                this.Tg.setNickName(author.getFansNickName());
                this.Tg.setAuthorId(author.getUserId());
                this.Tg.setGodInfo(author.getGodInfo());
            }
            PraiseData rF = biVar.rF();
            if (rF != null) {
                this.Tg.setPraiseNum((int) rF.getNum());
            }
            this.Tg.setDiscussNum(biVar.rH());
            this.Tg.setPostNum(biVar.getPost_num());
            this.Tg.setTitle(biVar.getTitle());
            this.Tg.setLastModifiedTime(biVar.rI());
            this.Tg.setPhotoLiveCover(biVar.getPhotoLiveCover());
            this.Tg.setContent(biVar.rU());
            this.Tg.setThreadId(com.baidu.adp.lib.h.b.c(biVar.getTid(), 0L));
            this.Tg.setHeadlive(biVar.isHeadLive());
            this.Tg.setExpressionDatas(biVar.se());
            if (this.Tg.getShowStyle() < 0) {
                this.Tg.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Tg.setShowExpressionViewIndexList(this.Tg.getExpressionDatas());
        }
        cu(biVar.getTid());
        setId(biVar.getId());
        setThreadType(biVar.getThreadType());
        setForum_name(biVar.getForum_name());
        return this.Tg;
    }

    public PhotoLiveCardData rk() {
        return this.Tg;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Tf;
    }
}
