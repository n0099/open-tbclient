package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId Ys = BdUniqueId.gen();
    private PhotoLiveCardData Yt;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.Yt == null) {
            if (bdVar == null) {
                return null;
            }
            this.Yt = new PhotoLiveCardData();
            MetaData rv = bdVar.rv();
            if (rv != null) {
                this.Yt.setAuthorName(rv.getUserName());
                this.Yt.setAuthorPortrait(rv.getPortrait());
                this.Yt.setFansNum(rv.getFansNum());
                this.Yt.setNickName(rv.getFansNickName());
                this.Yt.setAuthorId(rv.getUserId());
                this.Yt.setGodInfo(rv.getGodInfo());
            }
            PraiseData rk = bdVar.rk();
            if (rk != null) {
                this.Yt.setPraiseNum((int) rk.getNum());
            }
            this.Yt.setDiscussNum(bdVar.rn());
            this.Yt.setPostNum(bdVar.getPost_num());
            this.Yt.setTitle(bdVar.getTitle());
            this.Yt.setLastModifiedTime(bdVar.rp());
            this.Yt.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.Yt.setContent(bdVar.getAbstract());
            this.Yt.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.Yt.setHeadlive(bdVar.isHeadLive());
            this.Yt.setExpressionDatas(bdVar.rP());
            if (this.Yt.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.Yt;
                this.Yt.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Yt.setShowExpressionViewIndexList(this.Yt.getExpressionDatas());
        }
        cD(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cH(bdVar.rB());
        return this.Yt;
    }

    public PhotoLiveCardData qR() {
        return this.Yt;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Ys;
    }
}
