package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId aOb = BdUniqueId.gen();
    private PhotoLiveCardData aOc;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.aOc == null) {
            if (bdVar == null) {
                return null;
            }
            this.aOc = new PhotoLiveCardData();
            MetaData zn = bdVar.zn();
            if (zn != null) {
                this.aOc.setAuthorName(zn.getUserName());
                this.aOc.setAuthorPortrait(zn.getPortrait());
                this.aOc.setFansNum(zn.getFansNum());
                this.aOc.setNickName(zn.getFansNickName());
                this.aOc.setAuthorId(zn.getUserId());
                this.aOc.setGodInfo(zn.getGodInfo());
            }
            PraiseData zc = bdVar.zc();
            if (zc != null) {
                this.aOc.setPraiseNum((int) zc.getNum());
            }
            this.aOc.setDiscussNum(bdVar.zf());
            this.aOc.setPostNum(bdVar.getPost_num());
            this.aOc.setTitle(bdVar.getTitle());
            this.aOc.setLastModifiedTime(bdVar.zh());
            this.aOc.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.aOc.setContent(bdVar.getAbstract());
            this.aOc.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.aOc.setHeadlive(bdVar.isHeadLive());
            this.aOc.setExpressionDatas(bdVar.zH());
            if (this.aOc.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.aOc;
                this.aOc.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.aOc.setShowExpressionViewIndexList(this.aOc.getExpressionDatas());
        }
        cV(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cZ(bdVar.zt());
        return this.aOc;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aOb;
    }
}
