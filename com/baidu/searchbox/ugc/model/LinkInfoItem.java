package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.a.c;
/* loaded from: classes5.dex */
public class LinkInfoItem implements NoProGuard {
    @c("key")
    public String linkKey;
    @c("nid")
    public String linkNID;
    @c("restype")
    public String linkResType;
    @c("title")
    public String linkTitle;
    @c("url")
    public String linkUrl;

    public LinkInfoItem(String str, String str2, String str3, String str4, String str5) {
        this.linkKey = str;
        this.linkTitle = str2;
        this.linkUrl = str3;
        this.linkResType = str4;
        this.linkNID = str5;
    }
}
