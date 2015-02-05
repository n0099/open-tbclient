package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class s {
    public String Ek;
    public String El;
    public String Em;
    public String mForumName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("name");
            this.Ek = jSONObject.optString("avatar");
            this.El = jSONObject.optString("link");
            this.Em = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.mForumName = recommendForum.name;
            this.Ek = recommendForum.avatar;
            this.El = recommendForum.link;
            this.Em = recommendForum.st_param;
        }
    }
}
