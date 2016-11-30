package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class be extends bk {
    public static final BdUniqueId TA = BdUniqueId.gen();
    private PhotoLiveCardData TB;

    public PhotoLiveCardData b(bk bkVar, int i) {
        if (this.TB == null) {
            if (bkVar == null) {
                return null;
            }
            this.TB = new PhotoLiveCardData();
            MetaData author = bkVar.getAuthor();
            if (author != null) {
                this.TB.setAuthorName(author.getUserName());
                this.TB.setAuthorPortrait(author.getPortrait());
                this.TB.setFansNum(author.getFansNum());
                this.TB.setNickName(author.getFansNickName());
                this.TB.setAuthorId(author.getUserId());
                this.TB.setGodInfo(author.getGodInfo());
            }
            PraiseData rH = bkVar.rH();
            if (rH != null) {
                this.TB.setPraiseNum((int) rH.getNum());
            }
            this.TB.setDiscussNum(bkVar.rJ());
            this.TB.setPostNum(bkVar.getPost_num());
            this.TB.setTitle(bkVar.getTitle());
            this.TB.setLastModifiedTime(bkVar.rK());
            this.TB.setPhotoLiveCover(bkVar.getPhotoLiveCover());
            this.TB.setContent(bkVar.rW());
            this.TB.setThreadId(com.baidu.adp.lib.h.b.c(bkVar.getTid(), 0L));
            this.TB.setHeadlive(bkVar.isHeadLive());
            this.TB.setExpressionDatas(bkVar.sg());
            if (this.TB.getShowStyle() < 0) {
                this.TB.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.TB.setShowExpressionViewIndexList(this.TB.getExpressionDatas());
        }
        cw(bkVar.getTid());
        setId(bkVar.getId());
        setThreadType(bkVar.getThreadType());
        setForum_name(bkVar.getForum_name());
        return this.TB;
    }

    public PhotoLiveCardData rm() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TA;
    }
}
