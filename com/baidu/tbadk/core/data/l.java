package com.baidu.tbadk.core.data;

import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes.dex */
public class l {
    public String a;
    public String b;
    public String c;
    public String d;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("name");
            this.b = jSONObject.optString("avatar");
            this.c = jSONObject.optString("link");
            this.d = jSONObject.optString("st_param");
        }
    }

    public void a(RecommendForum recommendForum) {
        if (recommendForum != null) {
            this.a = recommendForum.name;
            this.b = recommendForum.avatar;
            this.c = recommendForum.link;
            this.d = recommendForum.st_param;
        }
    }
}
