package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class v {
    private s UO;
    private long threadId;
    private long UJ = 0;
    private String UK = "";
    private long UL = 0;
    private String UM = "";
    private String imgUrl = "";
    private String UN = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.UJ = forumHeadlineImgInfo.thread_user_id.longValue();
            this.UK = forumHeadlineImgInfo.thread_user_name;
            this.UL = forumHeadlineImgInfo.img_user_id.longValue();
            this.UM = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.UN = forumHeadlineImgInfo.headline_url;
            this.UO = new s();
            ArrayList<u> arrayList = new ArrayList<>();
            u uVar = new u(this.imgUrl == null ? "" : this.imgUrl, this.UN == null ? "" : this.UN, null);
            uVar.am(true);
            arrayList.add(uVar);
            this.UO.f(arrayList);
        }
    }

    public String pI() {
        return this.imgUrl;
    }
}
