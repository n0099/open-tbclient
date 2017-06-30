package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg extends bm {
    public static final BdUniqueId Xc = BdUniqueId.gen();
    private PhotoLiveCardData Xd;

    public PhotoLiveCardData b(bm bmVar, int i) {
        if (this.Xd == null) {
            if (bmVar == null) {
                return null;
            }
            this.Xd = new PhotoLiveCardData();
            MetaData author = bmVar.getAuthor();
            if (author != null) {
                this.Xd.setAuthorName(author.getUserName());
                this.Xd.setAuthorPortrait(author.getPortrait());
                this.Xd.setFansNum(author.getFansNum());
                this.Xd.setNickName(author.getFansNickName());
                this.Xd.setAuthorId(author.getUserId());
                this.Xd.setGodInfo(author.getGodInfo());
            }
            PraiseData rh = bmVar.rh();
            if (rh != null) {
                this.Xd.setPraiseNum((int) rh.getNum());
            }
            this.Xd.setDiscussNum(bmVar.rj());
            this.Xd.setPostNum(bmVar.getPost_num());
            this.Xd.setTitle(bmVar.getTitle());
            this.Xd.setLastModifiedTime(bmVar.rl());
            this.Xd.setPhotoLiveCover(bmVar.getPhotoLiveCover());
            this.Xd.setContent(bmVar.rz());
            this.Xd.setThreadId(com.baidu.adp.lib.g.b.c(bmVar.getTid(), 0L));
            this.Xd.setHeadlive(bmVar.isHeadLive());
            this.Xd.setExpressionDatas(bmVar.rK());
            if (this.Xd.getShowStyle() < 0) {
                this.Xd.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Xd.setShowExpressionViewIndexList(this.Xd.getExpressionDatas());
        }
        cu(bmVar.getTid());
        setId(bmVar.getId());
        setThreadType(bmVar.getThreadType());
        cy(bmVar.rw());
        return this.Xd;
    }

    public PhotoLiveCardData qO() {
        return this.Xd;
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xc;
    }
}
