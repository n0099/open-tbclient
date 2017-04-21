package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r VK;
    private long threadId;
    private long VF = 0;
    private String VG = "";
    private long VH = 0;
    private String VI = "";
    private String imgUrl = "";
    private String VJ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.VF = forumHeadlineImgInfo.thread_user_id.longValue();
            this.VG = forumHeadlineImgInfo.thread_user_name;
            this.VH = forumHeadlineImgInfo.img_user_id.longValue();
            this.VI = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.VJ = forumHeadlineImgInfo.headline_url;
            this.VK = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.VJ == null ? "" : this.VJ, null);
            tVar.ao(true);
            arrayList.add(tVar);
            this.VK.f(arrayList);
        }
    }

    public boolean qw() {
        return qx() && qy();
    }

    public boolean qx() {
        return StringUtils.isNull(this.VG, true) || this.VF <= 0;
    }

    public boolean qy() {
        return StringUtils.isNull(this.VI, true) || this.VH <= 0;
    }

    public String qz() {
        return this.VG;
    }

    public String qA() {
        return this.VI;
    }

    public String qB() {
        return this.imgUrl;
    }

    public String qC() {
        return this.VJ;
    }

    public r qD() {
        return this.VK;
    }
}
