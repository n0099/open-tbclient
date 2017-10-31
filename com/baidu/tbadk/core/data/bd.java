package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bd extends bh {
    public static final BdUniqueId Yg = BdUniqueId.gen();
    private PhotoLiveCardData Yh;

    public PhotoLiveCardData b(bh bhVar, int i) {
        if (this.Yh == null) {
            if (bhVar == null) {
                return null;
            }
            this.Yh = new PhotoLiveCardData();
            MetaData rt = bhVar.rt();
            if (rt != null) {
                this.Yh.setAuthorName(rt.getUserName());
                this.Yh.setAuthorPortrait(rt.getPortrait());
                this.Yh.setFansNum(rt.getFansNum());
                this.Yh.setNickName(rt.getFansNickName());
                this.Yh.setAuthorId(rt.getUserId());
                this.Yh.setGodInfo(rt.getGodInfo());
            }
            PraiseData ri = bhVar.ri();
            if (ri != null) {
                this.Yh.setPraiseNum((int) ri.getNum());
            }
            this.Yh.setDiscussNum(bhVar.rl());
            this.Yh.setPostNum(bhVar.getPost_num());
            this.Yh.setTitle(bhVar.getTitle());
            this.Yh.setLastModifiedTime(bhVar.rn());
            this.Yh.setPhotoLiveCover(bhVar.getPhotoLiveCover());
            this.Yh.setContent(bhVar.getAbstract());
            this.Yh.setThreadId(com.baidu.adp.lib.g.b.c(bhVar.getTid(), 0L));
            this.Yh.setHeadlive(bhVar.isHeadLive());
            this.Yh.setExpressionDatas(bhVar.rN());
            if (this.Yh.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.Yh;
                this.Yh.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Yh.setShowExpressionViewIndexList(this.Yh.getExpressionDatas());
        }
        cD(bhVar.getTid());
        setId(bhVar.getId());
        setThreadType(bhVar.getThreadType());
        cH(bhVar.rz());
        return this.Yh;
    }

    public PhotoLiveCardData qP() {
        return this.Yh;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yg;
    }
}
