package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class z {
    private v emv;
    private long threadId;
    private long emq = 0;
    private String emr = "";
    private long ems = 0;
    private String emt = "";
    private String imgUrl = "";
    private String emu = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.emq = forumHeadlineImgInfo.thread_user_id.longValue();
            this.emr = forumHeadlineImgInfo.thread_user_name;
            this.ems = forumHeadlineImgInfo.img_user_id.longValue();
            this.emt = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.emu = forumHeadlineImgInfo.headline_url;
            this.emv = new v();
            ArrayList<y> arrayList = new ArrayList<>();
            y yVar = new y(this.imgUrl == null ? "" : this.imgUrl, this.emu == null ? "" : this.emu, null);
            yVar.io(true);
            arrayList.add(yVar);
            this.emv.C(arrayList);
        }
    }

    public String bgd() {
        return this.imgUrl;
    }
}
