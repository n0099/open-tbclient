package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r VO;
    private long threadId;
    private long VJ = 0;
    private String VK = "";
    private long VL = 0;
    private String VM = "";
    private String imgUrl = "";
    private String VN = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.VJ = forumHeadlineImgInfo.thread_user_id.longValue();
            this.VK = forumHeadlineImgInfo.thread_user_name;
            this.VL = forumHeadlineImgInfo.img_user_id.longValue();
            this.VM = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.VN = forumHeadlineImgInfo.headline_url;
            this.VO = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.VN == null ? "" : this.VN, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.VO.f(arrayList);
        }
    }

    public String pL() {
        return this.imgUrl;
    }
}
