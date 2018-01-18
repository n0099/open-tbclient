package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId aMQ = BdUniqueId.gen();
    private PhotoLiveCardData aMR;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.aMR == null) {
            if (bdVar == null) {
                return null;
            }
            this.aMR = new PhotoLiveCardData();
            MetaData yS = bdVar.yS();
            if (yS != null) {
                this.aMR.setAuthorName(yS.getUserName());
                this.aMR.setAuthorPortrait(yS.getPortrait());
                this.aMR.setFansNum(yS.getFansNum());
                this.aMR.setNickName(yS.getFansNickName());
                this.aMR.setAuthorId(yS.getUserId());
                this.aMR.setGodInfo(yS.getGodInfo());
            }
            PraiseData yH = bdVar.yH();
            if (yH != null) {
                this.aMR.setPraiseNum((int) yH.getNum());
            }
            this.aMR.setDiscussNum(bdVar.yK());
            this.aMR.setPostNum(bdVar.getPost_num());
            this.aMR.setTitle(bdVar.getTitle());
            this.aMR.setLastModifiedTime(bdVar.yM());
            this.aMR.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.aMR.setContent(bdVar.getAbstract());
            this.aMR.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.aMR.setHeadlive(bdVar.isHeadLive());
            this.aMR.setExpressionDatas(bdVar.zm());
            if (this.aMR.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.aMR;
                this.aMR.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.aMR.setShowExpressionViewIndexList(this.aMR.getExpressionDatas());
        }
        cK(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cO(bdVar.yY());
        return this.aMR;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMQ;
    }
}
