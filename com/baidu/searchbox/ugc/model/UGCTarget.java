package com.baidu.searchbox.ugc.model;

import com.google.gson.JsonObject;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class UGCTarget {
    @c("ext")
    public JsonObject extInfo;
    @c("topics")
    public List<TopicItem> mTopicList = new ArrayList();
    @c("at")
    public List<AtUserInfoItem> mUserInfoList = new ArrayList();
    @c("link")
    public List<LinkInfoItem> mLinkInfoList = new ArrayList();
    @c(UgcConstant.UGC_PK)
    public UgcPKInfo mUgcPKInfo = new UgcPKInfo();
    @c("tag")
    public List<UgcTagItem> tagList = new ArrayList();
    @c("vote")
    public UgcVoteInfo mUgcVoteInfo = new UgcVoteInfo();
    @c(UgcConstant.UGC_QUANZI)
    public UgcQuanInfo quanInfo = new UgcQuanInfo();
}
