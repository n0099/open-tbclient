package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends bl {
    public static final BdUniqueId Xs = BdUniqueId.gen();
    private PhotoLiveCardData Xt;

    public PhotoLiveCardData b(bl blVar, int i) {
        if (this.Xt == null) {
            if (blVar == null) {
                return null;
            }
            this.Xt = new PhotoLiveCardData();
            MetaData author = blVar.getAuthor();
            if (author != null) {
                this.Xt.setAuthorName(author.getUserName());
                this.Xt.setAuthorPortrait(author.getPortrait());
                this.Xt.setFansNum(author.getFansNum());
                this.Xt.setNickName(author.getFansNickName());
                this.Xt.setAuthorId(author.getUserId());
                this.Xt.setGodInfo(author.getGodInfo());
            }
            PraiseData rl = blVar.rl();
            if (rl != null) {
                this.Xt.setPraiseNum((int) rl.getNum());
            }
            this.Xt.setDiscussNum(blVar.rn());
            this.Xt.setPostNum(blVar.getPost_num());
            this.Xt.setTitle(blVar.getTitle());
            this.Xt.setLastModifiedTime(blVar.rp());
            this.Xt.setPhotoLiveCover(blVar.getPhotoLiveCover());
            this.Xt.setContent(blVar.rD());
            this.Xt.setThreadId(com.baidu.adp.lib.g.b.c(blVar.getTid(), 0L));
            this.Xt.setHeadlive(blVar.isHeadLive());
            this.Xt.setExpressionDatas(blVar.rO());
            if (this.Xt.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.Xt;
                this.Xt.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Xt.setShowExpressionViewIndexList(this.Xt.getExpressionDatas());
        }
        cz(blVar.getTid());
        setId(blVar.getId());
        setThreadType(blVar.getThreadType());
        cD(blVar.rA());
        return this.Xt;
    }

    public PhotoLiveCardData qR() {
        return this.Xt;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Xs;
    }
}
