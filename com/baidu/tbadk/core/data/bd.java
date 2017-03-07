package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bd extends bj {
    public static final BdUniqueId Xy = BdUniqueId.gen();
    private PhotoLiveCardData Xz;

    public PhotoLiveCardData b(bj bjVar, int i) {
        if (this.Xz == null) {
            if (bjVar == null) {
                return null;
            }
            this.Xz = new PhotoLiveCardData();
            MetaData author = bjVar.getAuthor();
            if (author != null) {
                this.Xz.setAuthorName(author.getUserName());
                this.Xz.setAuthorPortrait(author.getPortrait());
                this.Xz.setFansNum(author.getFansNum());
                this.Xz.setNickName(author.getFansNickName());
                this.Xz.setAuthorId(author.getUserId());
                this.Xz.setGodInfo(author.getGodInfo());
            }
            PraiseData rG = bjVar.rG();
            if (rG != null) {
                this.Xz.setPraiseNum((int) rG.getNum());
            }
            this.Xz.setDiscussNum(bjVar.rJ());
            this.Xz.setPostNum(bjVar.getPost_num());
            this.Xz.setTitle(bjVar.getTitle());
            this.Xz.setLastModifiedTime(bjVar.rL());
            this.Xz.setPhotoLiveCover(bjVar.getPhotoLiveCover());
            this.Xz.setContent(bjVar.rY());
            this.Xz.setThreadId(com.baidu.adp.lib.g.b.c(bjVar.getTid(), 0L));
            this.Xz.setHeadlive(bjVar.isHeadLive());
            this.Xz.setExpressionDatas(bjVar.sj());
            if (this.Xz.getShowStyle() < 0) {
                this.Xz.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Xz.setShowExpressionViewIndexList(this.Xz.getExpressionDatas());
        }
        ci(bjVar.getTid());
        setId(bjVar.getId());
        setThreadType(bjVar.getThreadType());
        co(bjVar.rV());
        return this.Xz;
    }

    public PhotoLiveCardData rm() {
        return this.Xz;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xy;
    }
}
