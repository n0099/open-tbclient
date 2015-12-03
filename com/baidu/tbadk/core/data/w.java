package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class w extends z {
    public static final BdUniqueId VX = BdUniqueId.gen();
    private PhotoLiveCardData VY;

    public PhotoLiveCardData a(z zVar, int i) {
        if (this.VY == null) {
            if (zVar == null) {
                return null;
            }
            this.VY = new PhotoLiveCardData();
            MetaData author = zVar.getAuthor();
            if (author != null) {
                this.VY.setAuthorName(author.getUserName());
                this.VY.setAuthorPortrait(author.getPortrait());
                this.VY.setFansNum(author.getFansNum());
                this.VY.setNickName(author.getFansNickName());
                this.VY.setAuthorId(author.getUserId());
                this.VY.setGodInfo(author.getGodInfo());
            }
            PraiseData praise = zVar.getPraise();
            if (praise != null) {
                this.VY.setPraiseNum((int) praise.getNum());
            }
            this.VY.setDiscussNum(zVar.getReply_num());
            this.VY.setPostNum(zVar.getPost_num());
            this.VY.setTitle(zVar.getTitle());
            this.VY.setLastModifiedTime(zVar.getLast_time_int());
            this.VY.setPhotoLiveCover(zVar.getPhotoLiveCover());
            this.VY.setContent(zVar.sO());
            this.VY.setThreadId(com.baidu.adp.lib.h.b.c(zVar.getTid(), 0L));
            this.VY.setHeadlive(zVar.isHeadLive());
            this.VY.setExpressionDatas(zVar.sV());
            if (this.VY.getShowStyle() < 0) {
                this.VY.setShowStyle(this.VY.getRandom(3, i));
            }
            this.VY.setShowExpressionViewIndexList(this.VY.getExpressionDatas());
        }
        cu(zVar.getTid());
        setId(zVar.getId());
        setThreadType(zVar.getThreadType());
        cv(zVar.sL());
        return this.VY;
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            this.VY = new PhotoLiveCardData();
            PhotoLiveCardData photoLiveCardData = this.VY;
            if (zhiBoInfoTW.user != null) {
                photoLiveCardData.setAuthorId(String.valueOf(zhiBoInfoTW.user.id));
                photoLiveCardData.setAuthorName(zhiBoInfoTW.user.name);
                photoLiveCardData.setAuthorPortrait(zhiBoInfoTW.user.portrait);
                photoLiveCardData.setNickName(zhiBoInfoTW.user.fans_nickname);
                photoLiveCardData.setFansNum(zhiBoInfoTW.user.fans_num.intValue());
            }
            photoLiveCardData.setContent(zhiBoInfoTW.content);
            photoLiveCardData.setForumId(zhiBoInfoTW.forum_id.longValue());
            photoLiveCardData.setExpressionDatas(j(zhiBoInfoTW.labelInfo));
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

    private ArrayList<com.baidu.tbadk.coreExtra.view.o> j(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.o oVar = new com.baidu.tbadk.coreExtra.view.o();
                oVar.dS(labelInfo.labelHot.intValue());
                oVar.setLabelId(labelInfo.labelId);
                oVar.setLabelName(labelInfo.labelContent);
                arrayList.add(oVar);
            }
        }
        return arrayList;
    }

    public PhotoLiveCardData sy() {
        return this.VY;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return VX;
    }
}
