package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ay extends be {
    public static final BdUniqueId Qp = BdUniqueId.gen();
    private PhotoLiveCardData Qq;

    public PhotoLiveCardData b(be beVar, int i) {
        if (this.Qq == null) {
            if (beVar == null) {
                return null;
            }
            this.Qq = new PhotoLiveCardData();
            MetaData author = beVar.getAuthor();
            if (author != null) {
                this.Qq.setAuthorName(author.getUserName());
                this.Qq.setAuthorPortrait(author.getPortrait());
                this.Qq.setFansNum(author.getFansNum());
                this.Qq.setNickName(author.getFansNickName());
                this.Qq.setAuthorId(author.getUserId());
                this.Qq.setGodInfo(author.getGodInfo());
            }
            PraiseData qp = beVar.qp();
            if (qp != null) {
                this.Qq.setPraiseNum((int) qp.getNum());
            }
            this.Qq.setDiscussNum(beVar.qr());
            this.Qq.setPostNum(beVar.getPost_num());
            this.Qq.setTitle(beVar.getTitle());
            this.Qq.setLastModifiedTime(beVar.qs());
            this.Qq.setPhotoLiveCover(beVar.getPhotoLiveCover());
            this.Qq.setContent(beVar.qD());
            this.Qq.setThreadId(com.baidu.adp.lib.h.b.c(beVar.getTid(), 0L));
            this.Qq.setHeadlive(beVar.isHeadLive());
            this.Qq.setExpressionDatas(beVar.qN());
            if (this.Qq.getShowStyle() < 0) {
                this.Qq.setShowStyle(this.Qq.getRandom(3, i));
            }
            this.Qq.setShowExpressionViewIndexList(this.Qq.getExpressionDatas());
        }
        cr(beVar.getTid());
        setId(beVar.getId());
        setThreadType(beVar.getThreadType());
        setForum_name(beVar.getForum_name());
        return this.Qq;
    }

    public PhotoLiveCardData pV() {
        return this.Qq;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Qp;
    }
}
