package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ba extends bg {
    public static final BdUniqueId Tb = BdUniqueId.gen();
    private PhotoLiveCardData Tc;

    public PhotoLiveCardData b(bg bgVar, int i) {
        if (this.Tc == null) {
            if (bgVar == null) {
                return null;
            }
            this.Tc = new PhotoLiveCardData();
            MetaData author = bgVar.getAuthor();
            if (author != null) {
                this.Tc.setAuthorName(author.getUserName());
                this.Tc.setAuthorPortrait(author.getPortrait());
                this.Tc.setFansNum(author.getFansNum());
                this.Tc.setNickName(author.getFansNickName());
                this.Tc.setAuthorId(author.getUserId());
                this.Tc.setGodInfo(author.getGodInfo());
            }
            PraiseData rv = bgVar.rv();
            if (rv != null) {
                this.Tc.setPraiseNum((int) rv.getNum());
            }
            this.Tc.setDiscussNum(bgVar.rx());
            this.Tc.setPostNum(bgVar.getPost_num());
            this.Tc.setTitle(bgVar.getTitle());
            this.Tc.setLastModifiedTime(bgVar.rz());
            this.Tc.setPhotoLiveCover(bgVar.getPhotoLiveCover());
            this.Tc.setContent(bgVar.rN());
            this.Tc.setThreadId(com.baidu.adp.lib.h.b.c(bgVar.getTid(), 0L));
            this.Tc.setHeadlive(bgVar.isHeadLive());
            this.Tc.setExpressionDatas(bgVar.rX());
            if (this.Tc.getShowStyle() < 0) {
                this.Tc.setShowStyle(PhotoLiveCardData.getRandom(3, i));
            }
            this.Tc.setShowExpressionViewIndexList(this.Tc.getExpressionDatas());
        }
        cw(bgVar.getTid());
        setId(bgVar.getId());
        setThreadType(bgVar.getThreadType());
        cx(bgVar.rK());
        return this.Tc;
    }

    public PhotoLiveCardData rb() {
        return this.Tc;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Tb;
    }
}
