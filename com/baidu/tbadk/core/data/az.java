package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class az extends bd {
    public static final BdUniqueId Yy = BdUniqueId.gen();
    private PhotoLiveCardData Yz;

    public PhotoLiveCardData b(bd bdVar, int i) {
        if (this.Yz == null) {
            if (bdVar == null) {
                return null;
            }
            this.Yz = new PhotoLiveCardData();
            MetaData rx = bdVar.rx();
            if (rx != null) {
                this.Yz.setAuthorName(rx.getUserName());
                this.Yz.setAuthorPortrait(rx.getPortrait());
                this.Yz.setFansNum(rx.getFansNum());
                this.Yz.setNickName(rx.getFansNickName());
                this.Yz.setAuthorId(rx.getUserId());
                this.Yz.setGodInfo(rx.getGodInfo());
            }
            PraiseData rm = bdVar.rm();
            if (rm != null) {
                this.Yz.setPraiseNum((int) rm.getNum());
            }
            this.Yz.setDiscussNum(bdVar.rp());
            this.Yz.setPostNum(bdVar.getPost_num());
            this.Yz.setTitle(bdVar.getTitle());
            this.Yz.setLastModifiedTime(bdVar.rr());
            this.Yz.setPhotoLiveCover(bdVar.getPhotoLiveCover());
            this.Yz.setContent(bdVar.getAbstract());
            this.Yz.setThreadId(com.baidu.adp.lib.g.b.c(bdVar.getTid(), 0L));
            this.Yz.setHeadlive(bdVar.isHeadLive());
            this.Yz.setExpressionDatas(bdVar.rR());
            if (this.Yz.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.Yz;
                this.Yz.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Yz.setShowExpressionViewIndexList(this.Yz.getExpressionDatas());
        }
        cD(bdVar.getTid());
        setId(bdVar.getId());
        setThreadType(bdVar.getThreadType());
        cH(bdVar.rD());
        return this.Yz;
    }

    public PhotoLiveCardData qT() {
        return this.Yz;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yy;
    }
}
