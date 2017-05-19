package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class be extends bk {
    public static final BdUniqueId Xh = BdUniqueId.gen();
    private PhotoLiveCardData Xi;

    public PhotoLiveCardData b(bk bkVar, int i) {
        if (this.Xi == null) {
            if (bkVar == null) {
                return null;
            }
            this.Xi = new PhotoLiveCardData();
            MetaData author = bkVar.getAuthor();
            if (author != null) {
                this.Xi.setAuthorName(author.getUserName());
                this.Xi.setAuthorPortrait(author.getPortrait());
                this.Xi.setFansNum(author.getFansNum());
                this.Xi.setNickName(author.getFansNickName());
                this.Xi.setAuthorId(author.getUserId());
                this.Xi.setGodInfo(author.getGodInfo());
            }
            PraiseData ro = bkVar.ro();
            if (ro != null) {
                this.Xi.setPraiseNum((int) ro.getNum());
            }
            this.Xi.setDiscussNum(bkVar.rr());
            this.Xi.setPostNum(bkVar.getPost_num());
            this.Xi.setTitle(bkVar.getTitle());
            this.Xi.setLastModifiedTime(bkVar.rt());
            this.Xi.setPhotoLiveCover(bkVar.getPhotoLiveCover());
            this.Xi.setContent(bkVar.rG());
            this.Xi.setThreadId(com.baidu.adp.lib.g.b.c(bkVar.getTid(), 0L));
            this.Xi.setHeadlive(bkVar.isHeadLive());
            this.Xi.setExpressionDatas(bkVar.rR());
            if (this.Xi.getShowStyle() < 0) {
                this.Xi.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Xi.setShowExpressionViewIndexList(this.Xi.getExpressionDatas());
        }
        cp(bkVar.getTid());
        setId(bkVar.getId());
        setThreadType(bkVar.getThreadType());
        ct(bkVar.rD());
        return this.Xi;
    }

    public PhotoLiveCardData qV() {
        return this.Xi;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xh;
    }
}
