package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class t extends w {
    public static final BdUniqueId Vq = BdUniqueId.gen();
    private PhotoLiveCardData Vr;

    public PhotoLiveCardData a(w wVar, int i) {
        if (this.Vr == null) {
            if (wVar == null) {
                return null;
            }
            this.Vr = new PhotoLiveCardData();
            MetaData author = wVar.getAuthor();
            if (author != null) {
                this.Vr.setAuthorName(author.getUserName());
                this.Vr.setAuthorPortrait(author.getPortrait());
                this.Vr.setFansNum(author.getFansNum());
                this.Vr.setNickName(author.getFansNickName());
                this.Vr.setAuthorId(author.getUserId());
            }
            PraiseData praise = wVar.getPraise();
            if (praise != null) {
                this.Vr.setPraiseNum((int) praise.getNum());
            }
            this.Vr.setDiscussNum(wVar.getReply_num());
            this.Vr.setPostNum(wVar.getPost_num());
            this.Vr.setTitle(wVar.getTitle());
            this.Vr.setLastModifiedTime(wVar.getLast_time_int());
            this.Vr.setPhotoLiveCover(wVar.getPhotoLiveCover());
            this.Vr.setContent(wVar.sm());
            this.Vr.setThreadId(com.baidu.adp.lib.g.b.c(wVar.getTid(), 0L));
            this.Vr.setHeadlive(wVar.isHeadLive());
            this.Vr.setExpressionDatas(wVar.su());
            if (this.Vr.getShowStyle() < 0) {
                this.Vr.setShowStyle(this.Vr.getRandom(3, i));
            }
            this.Vr.setShowExpressionViewIndexList(this.Vr.getExpressionDatas());
        }
        cn(wVar.getTid());
        setId(wVar.getId());
        bC(wVar.sq());
        co(wVar.sj());
        return this.Vr;
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            this.Vr = new PhotoLiveCardData();
            PhotoLiveCardData photoLiveCardData = this.Vr;
            if (zhiBoInfoTW.user != null) {
                photoLiveCardData.setAuthorId(String.valueOf(zhiBoInfoTW.user.id));
                photoLiveCardData.setAuthorName(zhiBoInfoTW.user.name);
                photoLiveCardData.setAuthorPortrait(zhiBoInfoTW.user.portrait);
                photoLiveCardData.setNickName(zhiBoInfoTW.user.fans_nickname);
                photoLiveCardData.setFansNum(zhiBoInfoTW.user.fans_num.intValue());
            }
            photoLiveCardData.setContent(zhiBoInfoTW.content);
            photoLiveCardData.setForumId(zhiBoInfoTW.forum_id.longValue());
            photoLiveCardData.setExpressionDatas(k(zhiBoInfoTW.labelInfo));
            photoLiveCardData.setDiscussNum(zhiBoInfoTW.reply_num.intValue());
            photoLiveCardData.setForumName(zhiBoInfoTW.forum_name);
            photoLiveCardData.setCover(zhiBoInfoTW.livecover_src);
            photoLiveCardData.setLastModifiedTime(zhiBoInfoTW.last_modified_time.longValue());
            photoLiveCardData.setPostNum(zhiBoInfoTW.post_num.intValue());
            photoLiveCardData.setTitle(zhiBoInfoTW.title);
            photoLiveCardData.setThreadId(zhiBoInfoTW.thread_id.longValue());
            photoLiveCardData.setHeadlive(zhiBoInfoTW.is_headline.intValue() == 1);
            photoLiveCardData.setShowStyle(photoLiveCardData.getRandom(3, i));
            photoLiveCardData.setShowExpressionViewIndexList(photoLiveCardData.getExpressionDatas());
            cn(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            bC(33);
            co(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.o> k(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.o oVar = new com.baidu.tbadk.coreExtra.view.o();
                oVar.dD(labelInfo.labelHot.intValue());
                oVar.setLabelId(labelInfo.labelId);
                oVar.setLabelName(labelInfo.labelContent);
                arrayList.add(oVar);
            }
        }
        return arrayList;
    }

    public PhotoLiveCardData sc() {
        return this.Vr;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vq;
    }
}
