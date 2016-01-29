package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class ab extends ah {
    public static final BdUniqueId Wt = BdUniqueId.gen();
    private PhotoLiveCardData Wu;

    public PhotoLiveCardData a(ah ahVar, int i) {
        if (this.Wu == null) {
            if (ahVar == null) {
                return null;
            }
            this.Wu = new PhotoLiveCardData();
            MetaData author = ahVar.getAuthor();
            if (author != null) {
                this.Wu.setAuthorName(author.getUserName());
                this.Wu.setAuthorPortrait(author.getPortrait());
                this.Wu.setFansNum(author.getFansNum());
                this.Wu.setNickName(author.getFansNickName());
                this.Wu.setAuthorId(author.getUserId());
                this.Wu.setGodInfo(author.getGodInfo());
            }
            PraiseData praise = ahVar.getPraise();
            if (praise != null) {
                this.Wu.setPraiseNum((int) praise.getNum());
            }
            this.Wu.setDiscussNum(ahVar.getReply_num());
            this.Wu.setPostNum(ahVar.getPost_num());
            this.Wu.setTitle(ahVar.getTitle());
            this.Wu.setLastModifiedTime(ahVar.getLast_time_int());
            this.Wu.setPhotoLiveCover(ahVar.getPhotoLiveCover());
            this.Wu.setContent(ahVar.tr());
            this.Wu.setThreadId(com.baidu.adp.lib.h.b.c(ahVar.getTid(), 0L));
            this.Wu.setHeadlive(ahVar.isHeadLive());
            this.Wu.setExpressionDatas(ahVar.tA());
            if (this.Wu.getShowStyle() < 0) {
                this.Wu.setShowStyle(this.Wu.getRandom(3, i));
            }
            this.Wu.setShowExpressionViewIndexList(this.Wu.getExpressionDatas());
        }
        cw(ahVar.getTid());
        setId(ahVar.getId());
        setThreadType(ahVar.getThreadType());
        cx(ahVar.tn());
        return this.Wu;
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            this.Wu = new PhotoLiveCardData();
            PhotoLiveCardData photoLiveCardData = this.Wu;
            if (zhiBoInfoTW.user != null) {
                photoLiveCardData.setAuthorId(String.valueOf(zhiBoInfoTW.user.id));
                photoLiveCardData.setAuthorName(zhiBoInfoTW.user.name);
                photoLiveCardData.setAuthorPortrait(zhiBoInfoTW.user.portrait);
                photoLiveCardData.setNickName(zhiBoInfoTW.user.fans_nickname);
                photoLiveCardData.setFansNum(zhiBoInfoTW.user.fans_num.intValue());
            }
            photoLiveCardData.setContent(zhiBoInfoTW.content);
            photoLiveCardData.setForumId(zhiBoInfoTW.forum_id.longValue());
            photoLiveCardData.setExpressionDatas(m(zhiBoInfoTW.labelInfo));
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
            cw(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            cx(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.n> m(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                nVar.eh(labelInfo.labelHot.intValue());
                nVar.setLabelId(labelInfo.labelId);
                nVar.setLabelName(labelInfo.labelContent);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    public PhotoLiveCardData sS() {
        return this.Wu;
    }

    @Override // com.baidu.tbadk.core.data.ah, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Wt;
    }
}
