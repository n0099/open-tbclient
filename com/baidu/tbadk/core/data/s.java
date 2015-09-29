package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class s extends v {
    public static final BdUniqueId Vo = BdUniqueId.gen();
    private PhotoLiveCardData Vp;

    public PhotoLiveCardData a(v vVar, int i) {
        if (this.Vp == null) {
            if (vVar == null) {
                return null;
            }
            this.Vp = new PhotoLiveCardData();
            MetaData author = vVar.getAuthor();
            if (author != null) {
                this.Vp.setAuthorName(author.getUserName());
                this.Vp.setAuthorPortrait(author.getPortrait());
                this.Vp.setFansNum(author.getFansNum());
                this.Vp.setNickName(author.getFansNickName());
                this.Vp.setAuthorId(author.getUserId());
            }
            PraiseData praise = vVar.getPraise();
            if (praise != null) {
                this.Vp.setPraiseNum((int) praise.getNum());
            }
            this.Vp.setDiscussNum(vVar.getReply_num());
            this.Vp.setPostNum(vVar.getPost_num());
            this.Vp.setTitle(vVar.getTitle());
            this.Vp.setLastModifiedTime(vVar.getLast_time_int());
            this.Vp.setPhotoLiveCover(vVar.getPhotoLiveCover());
            this.Vp.setContent(vVar.sm());
            this.Vp.setThreadId(com.baidu.adp.lib.g.b.c(vVar.getTid(), 0L));
            this.Vp.setHeadlive(vVar.isHeadLive());
            this.Vp.setExpressionDatas(vVar.su());
            if (this.Vp.getShowStyle() < 0) {
                this.Vp.setShowStyle(this.Vp.getRandom(3, i));
            }
            this.Vp.setShowExpressionViewIndexList(this.Vp.getExpressionDatas());
        }
        cm(vVar.getTid());
        setId(vVar.getId());
        bC(vVar.sq());
        cn(vVar.sj());
        return this.Vp;
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            this.Vp = new PhotoLiveCardData();
            PhotoLiveCardData photoLiveCardData = this.Vp;
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
            cm(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            bC(33);
            cn(zhiBoInfoTW.forum_name);
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
        return this.Vp;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vo;
    }
}
