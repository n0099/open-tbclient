package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bd extends bh {
    public static final BdUniqueId XO = BdUniqueId.gen();
    private PhotoLiveCardData XP;

    public PhotoLiveCardData b(bh bhVar, int i) {
        if (this.XP == null) {
            if (bhVar == null) {
                return null;
            }
            this.XP = new PhotoLiveCardData();
            MetaData author = bhVar.getAuthor();
            if (author != null) {
                this.XP.setAuthorName(author.getUserName());
                this.XP.setAuthorPortrait(author.getPortrait());
                this.XP.setFansNum(author.getFansNum());
                this.XP.setNickName(author.getFansNickName());
                this.XP.setAuthorId(author.getUserId());
                this.XP.setGodInfo(author.getGodInfo());
            }
            PraiseData re = bhVar.re();
            if (re != null) {
                this.XP.setPraiseNum((int) re.getNum());
            }
            this.XP.setDiscussNum(bhVar.rg());
            this.XP.setPostNum(bhVar.getPost_num());
            this.XP.setTitle(bhVar.getTitle());
            this.XP.setLastModifiedTime(bhVar.ri());
            this.XP.setPhotoLiveCover(bhVar.getPhotoLiveCover());
            this.XP.setContent(bhVar.rw());
            this.XP.setThreadId(com.baidu.adp.lib.g.b.c(bhVar.getTid(), 0L));
            this.XP.setHeadlive(bhVar.isHeadLive());
            this.XP.setExpressionDatas(bhVar.rH());
            if (this.XP.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.XP;
                this.XP.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.XP.setShowExpressionViewIndexList(this.XP.getExpressionDatas());
        }
        cx(bhVar.getTid());
        setId(bhVar.getId());
        setThreadType(bhVar.getThreadType());
        cB(bhVar.rt());
        return this.XP;
    }

    public PhotoLiveCardData qK() {
        return this.XP;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XO;
    }
}
