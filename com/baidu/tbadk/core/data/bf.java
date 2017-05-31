package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends bl {
    public static final BdUniqueId Xc = BdUniqueId.gen();
    private PhotoLiveCardData Xd;

    public PhotoLiveCardData b(bl blVar, int i) {
        if (this.Xd == null) {
            if (blVar == null) {
                return null;
            }
            this.Xd = new PhotoLiveCardData();
            MetaData author = blVar.getAuthor();
            if (author != null) {
                this.Xd.setAuthorName(author.getUserName());
                this.Xd.setAuthorPortrait(author.getPortrait());
                this.Xd.setFansNum(author.getFansNum());
                this.Xd.setNickName(author.getFansNickName());
                this.Xd.setAuthorId(author.getUserId());
                this.Xd.setGodInfo(author.getGodInfo());
            }
            PraiseData rk = blVar.rk();
            if (rk != null) {
                this.Xd.setPraiseNum((int) rk.getNum());
            }
            this.Xd.setDiscussNum(blVar.rn());
            this.Xd.setPostNum(blVar.getPost_num());
            this.Xd.setTitle(blVar.getTitle());
            this.Xd.setLastModifiedTime(blVar.rp());
            this.Xd.setPhotoLiveCover(blVar.getPhotoLiveCover());
            this.Xd.setContent(blVar.rC());
            this.Xd.setThreadId(com.baidu.adp.lib.g.b.c(blVar.getTid(), 0L));
            this.Xd.setHeadlive(blVar.isHeadLive());
            this.Xd.setExpressionDatas(blVar.rN());
            if (this.Xd.getShowStyle() < 0) {
                this.Xd.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Xd.setShowExpressionViewIndexList(this.Xd.getExpressionDatas());
        }
        co(blVar.getTid());
        setId(blVar.getId());
        setThreadType(blVar.getThreadType());
        cs(blVar.rz());
        return this.Xd;
    }

    public PhotoLiveCardData qR() {
        return this.Xd;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xc;
    }
}
