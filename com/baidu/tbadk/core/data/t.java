package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class t {
    private q Qd;
    private long threadId;
    private long PY = 0;
    private String PZ = "";
    private long Qa = 0;
    private String Qb = "";
    private String imgUrl = "";
    private String Qc = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.PY = forumHeadlineImgInfo.thread_user_id.longValue();
            this.PZ = forumHeadlineImgInfo.thread_user_name;
            this.Qa = forumHeadlineImgInfo.img_user_id.longValue();
            this.Qb = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.Qc = forumHeadlineImgInfo.headline_url;
            this.Qd = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.Qc == null ? "" : this.Qc, null);
            sVar.an(true);
            arrayList.add(sVar);
            this.Qd.g(arrayList);
        }
    }

    public boolean pG() {
        return pH() && pI();
    }

    public boolean pH() {
        return StringUtils.isNull(this.PZ, true) || this.PY <= 0;
    }

    public boolean pI() {
        return StringUtils.isNull(this.Qb, true) || this.Qa <= 0;
    }

    public String pJ() {
        return this.PZ;
    }

    public String pK() {
        return this.Qb;
    }

    public String pL() {
        return this.imgUrl;
    }

    public String pM() {
        return this.Qc;
    }

    public q pN() {
        return this.Qd;
    }
}
