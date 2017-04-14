package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r VI;
    private long threadId;
    private long VD = 0;
    private String VE = "";
    private long VF = 0;
    private String VG = "";
    private String imgUrl = "";
    private String VH = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.VD = forumHeadlineImgInfo.thread_user_id.longValue();
            this.VE = forumHeadlineImgInfo.thread_user_name;
            this.VF = forumHeadlineImgInfo.img_user_id.longValue();
            this.VG = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.VH = forumHeadlineImgInfo.headline_url;
            this.VI = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.VH == null ? "" : this.VH, null);
            tVar.ao(true);
            arrayList.add(tVar);
            this.VI.f(arrayList);
        }
    }

    public boolean qw() {
        return qx() && qy();
    }

    public boolean qx() {
        return StringUtils.isNull(this.VE, true) || this.VD <= 0;
    }

    public boolean qy() {
        return StringUtils.isNull(this.VG, true) || this.VF <= 0;
    }

    public String qz() {
        return this.VE;
    }

    public String qA() {
        return this.VG;
    }

    public String qB() {
        return this.imgUrl;
    }

    public String qC() {
        return this.VH;
    }

    public r qD() {
        return this.VI;
    }
}
