package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class s {
    private p QE;
    private long threadId;
    private long Qz = 0;
    private String QA = "";
    private long QB = 0;
    private String QC = "";
    private String imgUrl = "";
    private String QD = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Qz = forumHeadlineImgInfo.thread_user_id.longValue();
            this.QA = forumHeadlineImgInfo.thread_user_name;
            this.QB = forumHeadlineImgInfo.img_user_id.longValue();
            this.QC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.QD = forumHeadlineImgInfo.headline_url;
            this.QE = new p();
            ArrayList<r> arrayList = new ArrayList<>();
            r rVar = new r(this.imgUrl == null ? "" : this.imgUrl, this.QD == null ? "" : this.QD, null);
            rVar.al(true);
            arrayList.add(rVar);
            this.QE.g(arrayList);
        }
    }

    public boolean pJ() {
        return pK() && pL();
    }

    public boolean pK() {
        return StringUtils.isNull(this.QA, true) || this.Qz <= 0;
    }

    public boolean pL() {
        return StringUtils.isNull(this.QC, true) || this.QB <= 0;
    }

    public String pM() {
        return this.QA;
    }

    public String pN() {
        return this.QC;
    }

    public String pO() {
        return this.imgUrl;
    }

    public String pP() {
        return this.QD;
    }

    public p pQ() {
        return this.QE;
    }
}
