package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bzk = 1;
    private String bzl;
    private String bzm;
    private String bzn;
    private int bzo = 0;
    private boolean bzp = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bzl = linkThreadContent.link_title;
                this.bzm = linkThreadContent.link_abstract;
                this.bzn = linkThreadContent.link_head_small_pic;
                this.bzo = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ap.isEmpty(this.bzl) && com.baidu.tbadk.core.util.ap.isEmpty(this.bzm)) {
                    this.bzp = true;
                    return;
                }
                return;
            }
            this.bzp = true;
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
                        this.bzl = jSONObject2.optString("link_title");
                        this.bzm = jSONObject2.optString("link_abstract");
                        this.bzn = jSONObject2.optString("link_head_small_pic");
                        this.bzo = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ap.isEmpty(this.bzl) && com.baidu.tbadk.core.util.ap.isEmpty(this.bzm)) {
                            this.bzp = true;
                        }
                    } else {
                        this.bzp = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bzp = true;
                    return;
                }
            }
            this.bzp = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String Xs() {
        return this.bzl;
    }

    public String Xt() {
        return this.bzm;
    }

    public String Xu() {
        return this.bzn;
    }

    public int Xv() {
        return this.bzo;
    }

    public boolean Xw() {
        return this.bzp;
    }
}
