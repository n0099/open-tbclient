package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class z {
    private v dYj;
    private long threadId;
    private long dYe = 0;
    private String dYf = "";
    private long dYg = 0;
    private String dYh = "";
    private String imgUrl = "";
    private String dYi = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.dYe = forumHeadlineImgInfo.thread_user_id.longValue();
            this.dYf = forumHeadlineImgInfo.thread_user_name;
            this.dYg = forumHeadlineImgInfo.img_user_id.longValue();
            this.dYh = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dYi = forumHeadlineImgInfo.headline_url;
            this.dYj = new v();
            ArrayList<y> arrayList = new ArrayList<>();
            y yVar = new y(this.imgUrl == null ? "" : this.imgUrl, this.dYi == null ? "" : this.dYi, null);
            yVar.hV(true);
            arrayList.add(yVar);
            this.dYj.C(arrayList);
        }
    }

    public String bcA() {
        return this.imgUrl;
    }
}
