package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ba {
    private String uid = "";
    private String uname = "";
    private String portrait = "";
    private String institute = "";
    private int isLike = -1;

    public void a(SchoolRecomUserInfo schoolRecomUserInfo) {
        if (schoolRecomUserInfo != null) {
            this.uid = StringUtils.string(schoolRecomUserInfo.uid);
            this.uname = schoolRecomUserInfo.uname;
            this.portrait = schoolRecomUserInfo.portrait;
            this.institute = schoolRecomUserInfo.institute;
            this.isLike = schoolRecomUserInfo.is_liked.intValue();
        }
    }

    public String getUid() {
        return this.uid;
    }

    public String qB() {
        return this.uname;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String qC() {
        return this.institute;
    }

    public int getIsLike() {
        return this.isLike;
    }
}
