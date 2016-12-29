package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class s {
    private p QU;
    private long threadId;
    private long QO = 0;
    private String QP = "";
    private long QR = 0;
    private String QS = "";
    private String imgUrl = "";
    private String QT = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.QO = forumHeadlineImgInfo.thread_user_id.longValue();
            this.QP = forumHeadlineImgInfo.thread_user_name;
            this.QR = forumHeadlineImgInfo.img_user_id.longValue();
            this.QS = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.QT = forumHeadlineImgInfo.headline_url;
            this.QU = new p();
            ArrayList<r> arrayList = new ArrayList<>();
            r rVar = new r(this.imgUrl == null ? "" : this.imgUrl, this.QT == null ? "" : this.QT, null);
            rVar.an(true);
            arrayList.add(rVar);
            this.QU.g(arrayList);
        }
    }

    public boolean pN() {
        return pO() && pP();
    }

    public boolean pO() {
        return StringUtils.isNull(this.QP, true) || this.QO <= 0;
    }

    public boolean pP() {
        return StringUtils.isNull(this.QS, true) || this.QR <= 0;
    }

    public String pQ() {
        return this.QP;
    }

    public String pR() {
        return this.QS;
    }

    public String pS() {
        return this.imgUrl;
    }

    public String pT() {
        return this.QT;
    }

    public p pU() {
        return this.QU;
    }
}
