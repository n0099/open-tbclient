package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class r {
    public String PY;
    public String PZ;
    public String Qa;
    public String mForumName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("name");
            this.PY = jSONObject.optString("avatar");
            this.PZ = jSONObject.optString("link");
            this.Qa = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.mForumName = recommendForum.name;
            this.PY = recommendForum.avatar;
            this.PZ = recommendForum.link;
            this.Qa = recommendForum.st_param;
        }
    }
}
