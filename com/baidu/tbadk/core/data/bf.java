package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends bl {
    public static final BdUniqueId YQ = BdUniqueId.gen();
    private PhotoLiveCardData YR;

    public PhotoLiveCardData b(bl blVar, int i) {
        if (this.YR == null) {
            if (blVar == null) {
                return null;
            }
            this.YR = new PhotoLiveCardData();
            MetaData author = blVar.getAuthor();
            if (author != null) {
                this.YR.setAuthorName(author.getUserName());
                this.YR.setAuthorPortrait(author.getPortrait());
                this.YR.setFansNum(author.getFansNum());
                this.YR.setNickName(author.getFansNickName());
                this.YR.setAuthorId(author.getUserId());
                this.YR.setGodInfo(author.getGodInfo());
            }
            PraiseData rv = blVar.rv();
            if (rv != null) {
                this.YR.setPraiseNum((int) rv.getNum());
            }
            this.YR.setDiscussNum(blVar.rx());
            this.YR.setPostNum(blVar.getPost_num());
            this.YR.setTitle(blVar.getTitle());
            this.YR.setLastModifiedTime(blVar.rz());
            this.YR.setPhotoLiveCover(blVar.getPhotoLiveCover());
            this.YR.setContent(blVar.rN());
            this.YR.setThreadId(com.baidu.adp.lib.g.b.d(blVar.getTid(), 0L));
            this.YR.setHeadlive(blVar.isHeadLive());
            this.YR.setExpressionDatas(blVar.rY());
            if (this.YR.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.YR;
                this.YR.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.YR.setShowExpressionViewIndexList(this.YR.getExpressionDatas());
        }
        cF(blVar.getTid());
        setId(blVar.getId());
        setThreadType(blVar.getThreadType());
        cJ(blVar.rK());
        return this.YR;
    }

    public PhotoLiveCardData rb() {
        return this.YR;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return YQ;
    }
}
