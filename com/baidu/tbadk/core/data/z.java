package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class z {
    private v eat;
    private long threadId;
    private long eao = 0;
    private String eap = "";
    private long eaq = 0;
    private String ear = "";
    private String imgUrl = "";
    private String eas = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.eao = forumHeadlineImgInfo.thread_user_id.longValue();
            this.eap = forumHeadlineImgInfo.thread_user_name;
            this.eaq = forumHeadlineImgInfo.img_user_id.longValue();
            this.ear = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eas = forumHeadlineImgInfo.headline_url;
            this.eat = new v();
            ArrayList<y> arrayList = new ArrayList<>();
            y yVar = new y(this.imgUrl == null ? "" : this.imgUrl, this.eas == null ? "" : this.eas, null);
            yVar.hS(true);
            arrayList.add(yVar);
            this.eat.C(arrayList);
        }
    }

    public String bdu() {
        return this.imgUrl;
    }
}
