package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.a.c;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class UgcTagItem implements NoProGuard, Serializable {
    @c("post_id")
    public String postId;
    @c("post_type")
    public String postType;
    @c("id")
    public String tagID;
    @c("name")
    public String tagName;
    @c(UgcConstant.UGC_TAG_OPTION)
    public String tagOption;
    @c("type")
    public String tagType;

    public UgcTagItem(String str, String str2, String str3, String str4) {
        this.tagID = str;
        this.tagName = str2;
        this.tagType = str3;
        this.tagOption = str4;
    }
}
