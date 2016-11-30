package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class t {
    private q QX;
    private long threadId;
    private long QS = 0;
    private String QT = "";
    private long QU = 0;
    private String QV = "";
    private String imgUrl = "";
    private String QW = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.QS = forumHeadlineImgInfo.thread_user_id.longValue();
            this.QT = forumHeadlineImgInfo.thread_user_name;
            this.QU = forumHeadlineImgInfo.img_user_id.longValue();
            this.QV = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.QW = forumHeadlineImgInfo.headline_url;
            this.QX = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.QW == null ? "" : this.QW, null);
            sVar.an(true);
            arrayList.add(sVar);
            this.QX.g(arrayList);
        }
    }

    public boolean pM() {
        return pN() && pO();
    }

    public boolean pN() {
        return StringUtils.isNull(this.QT, true) || this.QS <= 0;
    }

    public boolean pO() {
        return StringUtils.isNull(this.QV, true) || this.QU <= 0;
    }

    public String pP() {
        return this.QT;
    }

    public String pQ() {
        return this.QV;
    }

    public String pR() {
        return this.imgUrl;
    }

    public String pS() {
        return this.QW;
    }

    public q pT() {
        return this.QX;
    }
}
