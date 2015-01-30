package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class s {
    public String En;
    public String Eo;
    public String Ep;
    public String mForumName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mForumName = jSONObject.optString("name");
            this.En = jSONObject.optString("avatar");
            this.Eo = jSONObject.optString("link");
            this.Ep = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.mForumName = recommendForum.name;
            this.En = recommendForum.avatar;
            this.Eo = recommendForum.link;
            this.Ep = recommendForum.st_param;
        }
    }
}
