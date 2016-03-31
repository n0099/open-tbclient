package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class am extends as {
    public static final BdUniqueId UI = BdUniqueId.gen();
    private PhotoLiveCardData UJ;

    public PhotoLiveCardData a(as asVar, int i) {
        if (this.UJ == null) {
            if (asVar == null) {
                return null;
            }
            this.UJ = new PhotoLiveCardData();
            MetaData author = asVar.getAuthor();
            if (author != null) {
                this.UJ.setAuthorName(author.getUserName());
                this.UJ.setAuthorPortrait(author.getPortrait());
                this.UJ.setFansNum(author.getFansNum());
                this.UJ.setNickName(author.getFansNickName());
                this.UJ.setAuthorId(author.getUserId());
                this.UJ.setGodInfo(author.getGodInfo());
            }
            PraiseData praise = asVar.getPraise();
            if (praise != null) {
                this.UJ.setPraiseNum((int) praise.getNum());
            }
            this.UJ.setDiscussNum(asVar.getReply_num());
            this.UJ.setPostNum(asVar.getPost_num());
            this.UJ.setTitle(asVar.getTitle());
            this.UJ.setLastModifiedTime(asVar.getLast_time_int());
            this.UJ.setPhotoLiveCover(asVar.getPhotoLiveCover());
            this.UJ.setContent(asVar.tu());
            this.UJ.setThreadId(com.baidu.adp.lib.h.b.c(asVar.getTid(), 0L));
            this.UJ.setHeadlive(asVar.isHeadLive());
            this.UJ.setExpressionDatas(asVar.tD());
            if (this.UJ.getShowStyle() < 0) {
                this.UJ.setShowStyle(this.UJ.getRandom(3, i));
            }
            this.UJ.setShowExpressionViewIndexList(this.UJ.getExpressionDatas());
        }
        cu(asVar.getTid());
        setId(asVar.getId());
        setThreadType(asVar.getThreadType());
        cv(asVar.tr());
        return this.UJ;
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            this.UJ = new PhotoLiveCardData();
            PhotoLiveCardData photoLiveCardData = this.UJ;
            if (zhiBoInfoTW.user != null) {
                photoLiveCardData.setAuthorId(String.valueOf(zhiBoInfoTW.user.id));
                photoLiveCardData.setAuthorName(zhiBoInfoTW.user.name);
                photoLiveCardData.setAuthorPortrait(zhiBoInfoTW.user.portrait);
                photoLiveCardData.setNickName(zhiBoInfoTW.user.fans_nickname);
                photoLiveCardData.setFansNum(zhiBoInfoTW.user.fans_num.intValue());
            }
            photoLiveCardData.setContent(zhiBoInfoTW.content);
            photoLiveCardData.setForumId(zhiBoInfoTW.forum_id.longValue());
            photoLiveCardData.setExpressionDatas(n(zhiBoInfoTW.labelInfo));
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
            cu(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            cv(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.n> n(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                nVar.ek(labelInfo.labelHot.intValue());
                nVar.setLabelId(labelInfo.labelId);
                nVar.setLabelName(labelInfo.labelContent);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    public PhotoLiveCardData sT() {
        return this.UJ;
    }

    @Override // com.baidu.tbadk.core.data.as, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return UI;
    }
}
