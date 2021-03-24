package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes3.dex */
public class RecommendForumData implements Serializable {
    public static final long serialVersionUID = 1;
    public String mForumImageUrl;
    public String mForumLink;
    public String mForumName;
    public int mMemberNum;
    public String mParam;
    public int mThreadNum;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mForumName = jSONObject.optString("name");
        this.mForumImageUrl = jSONObject.optString("avatar");
        this.mForumLink = jSONObject.optString("link");
        this.mParam = jSONObject.optString("st_param");
        this.mMemberNum = jSONObject.optInt("member_num");
        this.mThreadNum = jSONObject.optInt("thread_num");
    }

    public void parserProtobuf(RecommendForum recommendForum) {
        if (recommendForum == null) {
            return;
        }
        this.mForumName = recommendForum.name;
        this.mForumImageUrl = recommendForum.avatar;
        this.mForumLink = recommendForum.link;
        this.mParam = recommendForum.st_param;
        this.mMemberNum = recommendForum.member_num.intValue();
        this.mThreadNum = recommendForum.thread_num.intValue();
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
