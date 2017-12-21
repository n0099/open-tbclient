package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId Yv = BdUniqueId.gen();
    private PhotoLiveCardData Yw;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.Yw == null) {
            if (bdVar == null) {
                return null;
            }
            this.Yw = new PhotoLiveCardData();
            MetaData rv = bdVar.rv();
            if (rv != null) {
                this.Yw.setAuthorName(rv.getUserName());
                this.Yw.setAuthorPortrait(rv.getPortrait());
                this.Yw.setFansNum(rv.getFansNum());
                this.Yw.setNickName(rv.getFansNickName());
                this.Yw.setAuthorId(rv.getUserId());
                this.Yw.setGodInfo(rv.getGodInfo());
            }
            PraiseData rk = bdVar.rk();
            if (rk != null) {
                this.Yw.setPraiseNum((int) rk.getNum());
            }
            this.Yw.setDiscussNum(bdVar.rn());
            this.Yw.setPostNum(bdVar.getPost_num());
            this.Yw.setTitle(bdVar.getTitle());
            this.Yw.setLastModifiedTime(bdVar.rp());
            this.Yw.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.Yw.setContent(bdVar.getAbstract());
            this.Yw.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.Yw.setHeadlive(bdVar.isHeadLive());
            this.Yw.setExpressionDatas(bdVar.rP());
            if (this.Yw.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.Yw;
                this.Yw.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Yw.setShowExpressionViewIndexList(this.Yw.getExpressionDatas());
        }
        cD(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cH(bdVar.rB());
        return this.Yw;
    }

    public PhotoLiveCardData qR() {
        return this.Yw;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yv;
    }
}
