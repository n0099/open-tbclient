package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class r {
    public String Qt;
    public String Qu;
    public String Qv;
    public String mForumName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("name");
            this.Qt = jSONObject.optString("avatar");
            this.Qu = jSONObject.optString("link");
            this.Qv = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.mForumName = recommendForum.name;
            this.Qt = recommendForum.avatar;
            this.Qu = recommendForum.link;
            this.Qv = recommendForum.st_param;
        }
    }
}
