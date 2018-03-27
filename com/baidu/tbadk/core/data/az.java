package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId aOc = BdUniqueId.gen();
    private PhotoLiveCardData aOd;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.aOd == null) {
            if (bdVar == null) {
                return null;
            }
            this.aOd = new PhotoLiveCardData();
            MetaData zn = bdVar.zn();
            if (zn != null) {
                this.aOd.setAuthorName(zn.getUserName());
                this.aOd.setAuthorPortrait(zn.getPortrait());
                this.aOd.setFansNum(zn.getFansNum());
                this.aOd.setNickName(zn.getFansNickName());
                this.aOd.setAuthorId(zn.getUserId());
                this.aOd.setGodInfo(zn.getGodInfo());
            }
            PraiseData zc = bdVar.zc();
            if (zc != null) {
                this.aOd.setPraiseNum((int) zc.getNum());
            }
            this.aOd.setDiscussNum(bdVar.zf());
            this.aOd.setPostNum(bdVar.getPost_num());
            this.aOd.setTitle(bdVar.getTitle());
            this.aOd.setLastModifiedTime(bdVar.zh());
            this.aOd.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.aOd.setContent(bdVar.getAbstract());
            this.aOd.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.aOd.setHeadlive(bdVar.isHeadLive());
            this.aOd.setExpressionDatas(bdVar.zH());
            if (this.aOd.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.aOd;
                this.aOd.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.aOd.setShowExpressionViewIndexList(this.aOd.getExpressionDatas());
        }
        cV(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cZ(bdVar.zt());
        return this.aOd;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aOc;
    }
}
