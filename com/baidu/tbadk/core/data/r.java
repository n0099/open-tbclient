package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class r {
    public String PW;
    public String PX;
    public String PY;
    public String mForumName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("name");
            this.PW = jSONObject.optString("avatar");
            this.PX = jSONObject.optString("link");
            this.PY = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.mForumName = recommendForum.name;
            this.PW = recommendForum.avatar;
            this.PX = recommendForum.link;
            this.PY = recommendForum.st_param;
        }
    }
}
