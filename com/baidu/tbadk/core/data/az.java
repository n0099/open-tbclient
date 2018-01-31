package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId aMT = BdUniqueId.gen();
    private PhotoLiveCardData aMU;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.aMU == null) {
            if (bdVar == null) {
                return null;
            }
            this.aMU = new PhotoLiveCardData();
            MetaData yT = bdVar.yT();
            if (yT != null) {
                this.aMU.setAuthorName(yT.getUserName());
                this.aMU.setAuthorPortrait(yT.getPortrait());
                this.aMU.setFansNum(yT.getFansNum());
                this.aMU.setNickName(yT.getFansNickName());
                this.aMU.setAuthorId(yT.getUserId());
                this.aMU.setGodInfo(yT.getGodInfo());
            }
            PraiseData yI = bdVar.yI();
            if (yI != null) {
                this.aMU.setPraiseNum((int) yI.getNum());
            }
            this.aMU.setDiscussNum(bdVar.yL());
            this.aMU.setPostNum(bdVar.getPost_num());
            this.aMU.setTitle(bdVar.getTitle());
            this.aMU.setLastModifiedTime(bdVar.yN());
            this.aMU.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.aMU.setContent(bdVar.getAbstract());
            this.aMU.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.aMU.setHeadlive(bdVar.isHeadLive());
            this.aMU.setExpressionDatas(bdVar.zn());
            if (this.aMU.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.aMU;
                this.aMU.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.aMU.setShowExpressionViewIndexList(this.aMU.getExpressionDatas());
        }
        cK(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cO(bdVar.yZ());
        return this.aMU;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMT;
    }
}
