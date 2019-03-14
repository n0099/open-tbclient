package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bzh = 1;
    private String bzi;
    private String bzj;
    private String bzk;
    private int bzl = 0;
    private boolean bzm = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bzi = linkThreadContent.link_title;
                this.bzj = linkThreadContent.link_abstract;
                this.bzk = linkThreadContent.link_head_small_pic;
                this.bzl = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ap.isEmpty(this.bzi) && com.baidu.tbadk.core.util.ap.isEmpty(this.bzj)) {
                    this.bzm = true;
                    return;
                }
                return;
            }
            this.bzm = true;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.linkUrl = jSONObject.optString("link_url");
            JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                    if (jSONObject2 != null) {
                        this.bzi = jSONObject2.optString("link_title");
                        this.bzj = jSONObject2.optString("link_abstract");
                        this.bzk = jSONObject2.optString("link_head_small_pic");
                        this.bzl = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ap.isEmpty(this.bzi) && com.baidu.tbadk.core.util.ap.isEmpty(this.bzj)) {
                            this.bzm = true;
                        }
                    } else {
                        this.bzm = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bzm = true;
                    return;
                }
            }
            this.bzm = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String Xv() {
        return this.bzi;
    }

    public String Xw() {
        return this.bzj;
    }

    public String Xx() {
        return this.bzk;
    }

    public int Xy() {
        return this.bzl;
    }

    public boolean Xz() {
        return this.bzm;
    }
}
