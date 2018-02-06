package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId aOm = BdUniqueId.gen();
    private PhotoLiveCardData aOn;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.aOn == null) {
            if (bdVar == null) {
                return null;
            }
            this.aOn = new PhotoLiveCardData();
            MetaData zn = bdVar.zn();
            if (zn != null) {
                this.aOn.setAuthorName(zn.getUserName());
                this.aOn.setAuthorPortrait(zn.getPortrait());
                this.aOn.setFansNum(zn.getFansNum());
                this.aOn.setNickName(zn.getFansNickName());
                this.aOn.setAuthorId(zn.getUserId());
                this.aOn.setGodInfo(zn.getGodInfo());
            }
            PraiseData zc = bdVar.zc();
            if (zc != null) {
                this.aOn.setPraiseNum((int) zc.getNum());
            }
            this.aOn.setDiscussNum(bdVar.zf());
            this.aOn.setPostNum(bdVar.getPost_num());
            this.aOn.setTitle(bdVar.getTitle());
            this.aOn.setLastModifiedTime(bdVar.zh());
            this.aOn.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.aOn.setContent(bdVar.getAbstract());
            this.aOn.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.aOn.setHeadlive(bdVar.isHeadLive());
            this.aOn.setExpressionDatas(bdVar.zH());
            if (this.aOn.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.aOn;
                this.aOn.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.aOn.setShowExpressionViewIndexList(this.aOn.getExpressionDatas());
        }
        cV(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cZ(bdVar.zt());
        return this.aOn;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aOm;
    }
}
