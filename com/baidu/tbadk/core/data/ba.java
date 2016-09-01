package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ba extends bg {
    public static final BdUniqueId SY = BdUniqueId.gen();
    private PhotoLiveCardData SZ;

    public PhotoLiveCardData b(bg bgVar, int i) {
        if (this.SZ == null) {
            if (bgVar == null) {
                return null;
            }
            this.SZ = new PhotoLiveCardData();
            MetaData author = bgVar.getAuthor();
            if (author != null) {
                this.SZ.setAuthorName(author.getUserName());
                this.SZ.setAuthorPortrait(author.getPortrait());
                this.SZ.setFansNum(author.getFansNum());
                this.SZ.setNickName(author.getFansNickName());
                this.SZ.setAuthorId(author.getUserId());
                this.SZ.setGodInfo(author.getGodInfo());
            }
            PraiseData rt = bgVar.rt();
            if (rt != null) {
                this.SZ.setPraiseNum((int) rt.getNum());
            }
            this.SZ.setDiscussNum(bgVar.rv());
            this.SZ.setPostNum(bgVar.getPost_num());
            this.SZ.setTitle(bgVar.getTitle());
            this.SZ.setLastModifiedTime(bgVar.rw());
            this.SZ.setPhotoLiveCover(bgVar.getPhotoLiveCover());
            this.SZ.setContent(bgVar.rI());
            this.SZ.setThreadId(com.baidu.adp.lib.h.b.c(bgVar.getTid(), 0L));
            this.SZ.setHeadlive(bgVar.isHeadLive());
            this.SZ.setExpressionDatas(bgVar.rS());
            if (this.SZ.getShowStyle() < 0) {
                this.SZ.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.SZ.setShowExpressionViewIndexList(this.SZ.getExpressionDatas());
        }
        cs(bgVar.getTid());
        setId(bgVar.getId());
        setThreadType(bgVar.getThreadType());
        setForum_name(bgVar.getForum_name());
        return this.SZ;
    }

    public PhotoLiveCardData qZ() {
        return this.SZ;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return SY;
    }
}
