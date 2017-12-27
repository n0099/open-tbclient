package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ba extends be {
    public static final BdUniqueId aMU = BdUniqueId.gen();
    private PhotoLiveCardData aMV;

    public PhotoLiveCardData b(be beVar, int i) {
        if (this.aMV == null) {
            if (beVar == null) {
                return null;
            }
            this.aMV = new PhotoLiveCardData();
            MetaData yX = beVar.yX();
            if (yX != null) {
                this.aMV.setAuthorName(yX.getUserName());
                this.aMV.setAuthorPortrait(yX.getPortrait());
                this.aMV.setFansNum(yX.getFansNum());
                this.aMV.setNickName(yX.getFansNickName());
                this.aMV.setAuthorId(yX.getUserId());
                this.aMV.setGodInfo(yX.getGodInfo());
            }
            PraiseData yM = beVar.yM();
            if (yM != null) {
                this.aMV.setPraiseNum((int) yM.getNum());
            }
            this.aMV.setDiscussNum(beVar.yP());
            this.aMV.setPostNum(beVar.getPost_num());
            this.aMV.setTitle(beVar.getTitle());
            this.aMV.setLastModifiedTime(beVar.yR());
            this.aMV.setPhotoLiveCover(beVar.getPhotoLiveCover());
            this.aMV.setContent(beVar.getAbstract());
            this.aMV.setThreadId(com.baidu.adp.lib.g.b.c(beVar.getTid(), 0L));
            this.aMV.setHeadlive(beVar.isHeadLive());
            this.aMV.setExpressionDatas(beVar.zr());
            if (this.aMV.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.aMV;
                this.aMV.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.aMV.setShowExpressionViewIndexList(this.aMV.getExpressionDatas());
        }
        cK(beVar.getTid());
        setId(beVar.getId());
        setThreadType(beVar.getThreadType());
        cO(beVar.zd());
        return this.aMV;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMU;
    }
}
