package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r WD;
    private long threadId;
    private long Wy = 0;
    private String Wz = "";
    private long WA = 0;
    private String WB = "";
    private String imgUrl = "";
    private String WC = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Wy = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Wz = forumHeadlineImgInfo.thread_user_name;
            this.WA = forumHeadlineImgInfo.img_user_id.longValue();
            this.WB = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.WC = forumHeadlineImgInfo.headline_url;
            this.WD = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.WC == null ? "" : this.WC, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.WD.f(arrayList);
        }
    }

    public String pV() {
        return this.imgUrl;
    }
}
