package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class w extends z {
    public static final BdUniqueId Wx = BdUniqueId.gen();
    private PhotoLiveCardData Wy;

    public PhotoLiveCardData a(z zVar, int i) {
        if (this.Wy == null) {
            if (zVar == null) {
                return null;
            }
            this.Wy = new PhotoLiveCardData();
            MetaData author = zVar.getAuthor();
            if (author != null) {
                this.Wy.setAuthorName(author.getUserName());
                this.Wy.setAuthorPortrait(author.getPortrait());
                this.Wy.setFansNum(author.getFansNum());
                this.Wy.setNickName(author.getFansNickName());
                this.Wy.setAuthorId(author.getUserId());
                this.Wy.setGodInfo(author.getGodInfo());
            }
            PraiseData praise = zVar.getPraise();
            if (praise != null) {
                this.Wy.setPraiseNum((int) praise.getNum());
            }
            this.Wy.setDiscussNum(zVar.getReply_num());
            this.Wy.setPostNum(zVar.getPost_num());
            this.Wy.setTitle(zVar.getTitle());
            this.Wy.setLastModifiedTime(zVar.getLast_time_int());
            this.Wy.setPhotoLiveCover(zVar.getPhotoLiveCover());
            this.Wy.setContent(zVar.sy());
            this.Wy.setThreadId(com.baidu.adp.lib.h.b.c(zVar.getTid(), 0L));
            this.Wy.setHeadlive(zVar.isHeadLive());
            this.Wy.setExpressionDatas(zVar.sF());
            if (this.Wy.getShowStyle() < 0) {
                this.Wy.setShowStyle(this.Wy.getRandom(3, i));
            }
            this.Wy.setShowExpressionViewIndexList(this.Wy.getExpressionDatas());
        }
        cx(zVar.getTid());
        setId(zVar.getId());
        setThreadType(zVar.getThreadType());
        cy(zVar.sv());
        return this.Wy;
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            this.Wy = new PhotoLiveCardData();
            PhotoLiveCardData photoLiveCardData = this.Wy;
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
            cx(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            cy(zhiBoInfoTW.forum_name);
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
                oVar.dM(labelInfo.labelHot.intValue());
                oVar.setLabelId(labelInfo.labelId);
                oVar.setLabelName(labelInfo.labelContent);
                arrayList.add(oVar);
            }
        }
        return arrayList;
    }

    public PhotoLiveCardData sh() {
        return this.Wy;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Wx;
    }
}
