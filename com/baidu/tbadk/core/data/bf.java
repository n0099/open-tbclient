package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bf extends bj {
    public static final BdUniqueId XZ = BdUniqueId.gen();
    private PhotoLiveCardData Ya;

    public PhotoLiveCardData b(bj bjVar, int i) {
        if (this.Ya == null) {
            if (bjVar == null) {
                return null;
            }
            this.Ya = new PhotoLiveCardData();
            MetaData author = bjVar.getAuthor();
            if (author != null) {
                this.Ya.setAuthorName(author.getUserName());
                this.Ya.setAuthorPortrait(author.getPortrait());
                this.Ya.setFansNum(author.getFansNum());
                this.Ya.setNickName(author.getFansNickName());
                this.Ya.setAuthorId(author.getUserId());
                this.Ya.setGodInfo(author.getGodInfo());
            }
            PraiseData rr = bjVar.rr();
            if (rr != null) {
                this.Ya.setPraiseNum((int) rr.getNum());
            }
            this.Ya.setDiscussNum(bjVar.rt());
            this.Ya.setPostNum(bjVar.getPost_num());
            this.Ya.setTitle(bjVar.getTitle());
            this.Ya.setLastModifiedTime(bjVar.rv());
            this.Ya.setPhotoLiveCover(bjVar.getPhotoLiveCover());
            this.Ya.setContent(bjVar.rJ());
            this.Ya.setThreadId(com.baidu.adp.lib.g.b.c(bjVar.getTid(), 0L));
            this.Ya.setHeadlive(bjVar.isHeadLive());
            this.Ya.setExpressionDatas(bjVar.rU());
            if (this.Ya.getShowStyle() < 0) {
                PhotoLiveCardData photoLiveCardData = this.Ya;
                this.Ya.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Ya.setShowExpressionViewIndexList(this.Ya.getExpressionDatas());
        }
        cy(bjVar.getTid());
        setId(bjVar.getId());
        setThreadType(bjVar.getThreadType());
        cC(bjVar.rG());
        return this.Ya;
    }

    public PhotoLiveCardData qX() {
        return this.Ya;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XZ;
    }
}
