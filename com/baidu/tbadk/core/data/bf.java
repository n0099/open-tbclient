package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends bl {
    public static final BdUniqueId YO = BdUniqueId.gen();
    private PhotoLiveCardData YP;

    public PhotoLiveCardData b(bl blVar, int i) {
        if (this.YP == null) {
            if (blVar == null) {
                return null;
            }
            this.YP = new PhotoLiveCardData();
            MetaData author = blVar.getAuthor();
            if (author != null) {
                this.YP.setAuthorName(author.getUserName());
                this.YP.setAuthorPortrait(author.getPortrait());
                this.YP.setFansNum(author.getFansNum());
                this.YP.setNickName(author.getFansNickName());
                this.YP.setAuthorId(author.getUserId());
                this.YP.setGodInfo(author.getGodInfo());
            }
            PraiseData rv = blVar.rv();
            if (rv != null) {
                this.YP.setPraiseNum((int) rv.getNum());
            }
            this.YP.setDiscussNum(blVar.rx());
            this.YP.setPostNum(blVar.getPost_num());
            this.YP.setTitle(blVar.getTitle());
            this.YP.setLastModifiedTime(blVar.rz());
            this.YP.setPhotoLiveCover(blVar.getPhotoLiveCover());
            this.YP.setContent(blVar.rN());
            this.YP.setThreadId(com.baidu.adp.lib.g.b.d(blVar.getTid(), 0L));
            this.YP.setHeadlive(blVar.isHeadLive());
            this.YP.setExpressionDatas(blVar.rY());
            if (this.YP.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.YP;
                this.YP.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.YP.setShowExpressionViewIndexList(this.YP.getExpressionDatas());
        }
        cF(blVar.getTid());
        setId(blVar.getId());
        setThreadType(blVar.getThreadType());
        cJ(blVar.rK());
        return this.YP;
    }

    public PhotoLiveCardData rb() {
        return this.YP;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return YO;
    }
}
