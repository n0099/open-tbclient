package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class r {
    public String Ej;
    public String Ek;
    public String El;
    public String mForumName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("name");
            this.Ej = jSONObject.optString("avatar");
            this.Ek = jSONObject.optString("link");
            this.El = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.mForumName = recommendForum.name;
            this.Ej = recommendForum.avatar;
            this.Ek = recommendForum.link;
            this.El = recommendForum.st_param;
        }
    }
}
