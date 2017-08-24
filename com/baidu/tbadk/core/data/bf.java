package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends bl {
    public static final BdUniqueId YR = BdUniqueId.gen();
    private PhotoLiveCardData YS;

    public PhotoLiveCardData b(bl blVar, int i) {
        if (this.YS == null) {
            if (blVar == null) {
                return null;
            }
            this.YS = new PhotoLiveCardData();
            MetaData author = blVar.getAuthor();
            if (author != null) {
                this.YS.setAuthorName(author.getUserName());
                this.YS.setAuthorPortrait(author.getPortrait());
                this.YS.setFansNum(author.getFansNum());
                this.YS.setNickName(author.getFansNickName());
                this.YS.setAuthorId(author.getUserId());
                this.YS.setGodInfo(author.getGodInfo());
            }
            PraiseData rw = blVar.rw();
            if (rw != null) {
                this.YS.setPraiseNum((int) rw.getNum());
            }
            this.YS.setDiscussNum(blVar.ry());
            this.YS.setPostNum(blVar.getPost_num());
            this.YS.setTitle(blVar.getTitle());
            this.YS.setLastModifiedTime(blVar.rA());
            this.YS.setPhotoLiveCover(blVar.getPhotoLiveCover());
            this.YS.setContent(blVar.rO());
            this.YS.setThreadId(com.baidu.adp.lib.g.b.d(blVar.getTid(), 0L));
            this.YS.setHeadlive(blVar.isHeadLive());
            this.YS.setExpressionDatas(blVar.rZ());
            if (this.YS.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.YS;
                this.YS.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.YS.setShowExpressionViewIndexList(this.YS.getExpressionDatas());
        }
        cI(blVar.getTid());
        setId(blVar.getId());
        setThreadType(blVar.getThreadType());
        cM(blVar.rL());
        return this.YS;
    }

    public PhotoLiveCardData rc() {
        return this.YS;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return YR;
    }
}
