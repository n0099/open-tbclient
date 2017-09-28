package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bd extends bh {
    public static final BdUniqueId Ya = BdUniqueId.gen();
    private PhotoLiveCardData Yb;

    public PhotoLiveCardData b(bh bhVar, int i) {
        if (this.Yb == null) {
            if (bhVar == null) {
                return null;
            }
            this.Yb = new PhotoLiveCardData();
            MetaData author = bhVar.getAuthor();
            if (author != null) {
                this.Yb.setAuthorName(author.getUserName());
                this.Yb.setAuthorPortrait(author.getPortrait());
                this.Yb.setFansNum(author.getFansNum());
                this.Yb.setNickName(author.getFansNickName());
                this.Yb.setAuthorId(author.getUserId());
                this.Yb.setGodInfo(author.getGodInfo());
            }
            PraiseData rl = bhVar.rl();
            if (rl != null) {
                this.Yb.setPraiseNum((int) rl.getNum());
            }
            this.Yb.setDiscussNum(bhVar.rn());
            this.Yb.setPostNum(bhVar.getPost_num());
            this.Yb.setTitle(bhVar.getTitle());
            this.Yb.setLastModifiedTime(bhVar.rp());
            this.Yb.setPhotoLiveCover(bhVar.getPhotoLiveCover());
            this.Yb.setContent(bhVar.rD());
            this.Yb.setThreadId(com.baidu.adp.lib.g.b.c(bhVar.getTid(), 0L));
            this.Yb.setHeadlive(bhVar.isHeadLive());
            this.Yb.setExpressionDatas(bhVar.rO());
            if (this.Yb.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.Yb;
                this.Yb.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Yb.setShowExpressionViewIndexList(this.Yb.getExpressionDatas());
        }
        cy(bhVar.getTid());
        setId(bhVar.getId());
        setThreadType(bhVar.getThreadType());
        cC(bhVar.rA());
        return this.Yb;
    }

    public PhotoLiveCardData qR() {
        return this.Yb;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Ya;
    }
}
