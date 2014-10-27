package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class n {
    public String Aa;
    public String mForumName;
    public String zY;
    public String zZ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("name");
            this.zY = jSONObject.optString("avatar");
            this.zZ = jSONObject.optString("link");
            this.Aa = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.mForumName = recommendForum.name;
            this.zY = recommendForum.avatar;
            this.zZ = recommendForum.link;
            this.Aa = recommendForum.st_param;
        }
    }
}
