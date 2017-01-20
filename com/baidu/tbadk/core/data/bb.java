package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bb extends bh {
    public static final BdUniqueId Sl = BdUniqueId.gen();
    private PhotoLiveCardData Sm;

    public PhotoLiveCardData b(bh bhVar, int i) {
        if (this.Sm == null) {
            if (bhVar == null) {
                return null;
            }
            this.Sm = new PhotoLiveCardData();
            MetaData author = bhVar.getAuthor();
            if (author != null) {
                this.Sm.setAuthorName(author.getUserName());
                this.Sm.setAuthorPortrait(author.getPortrait());
                this.Sm.setFansNum(author.getFansNum());
                this.Sm.setNickName(author.getFansNickName());
                this.Sm.setAuthorId(author.getUserId());
                this.Sm.setGodInfo(author.getGodInfo());
            }
            PraiseData rn = bhVar.rn();
            if (rn != null) {
                this.Sm.setPraiseNum((int) rn.getNum());
            }
            this.Sm.setDiscussNum(bhVar.rp());
            this.Sm.setPostNum(bhVar.getPost_num());
            this.Sm.setTitle(bhVar.getTitle());
            this.Sm.setLastModifiedTime(bhVar.rr());
            this.Sm.setPhotoLiveCover(bhVar.getPhotoLiveCover());
            this.Sm.setContent(bhVar.rE());
            this.Sm.setThreadId(com.baidu.adp.lib.g.b.c(bhVar.getTid(), 0L));
            this.Sm.setHeadlive(bhVar.isHeadLive());
            this.Sm.setExpressionDatas(bhVar.rP());
            if (this.Sm.getShowStyle() < 0) {
                this.Sm.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Sm.setShowExpressionViewIndexList(this.Sm.getExpressionDatas());
        }
        cu(bhVar.getTid());
        setId(bhVar.getId());
        setThreadType(bhVar.getThreadType());
        cv(bhVar.rB());
        return this.Sm;
    }

    public PhotoLiveCardData qT() {
        return this.Sm;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Sl;
    }
}
