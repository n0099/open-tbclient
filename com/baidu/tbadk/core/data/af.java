package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bzl = 1;
    private String bzm;
    private String bzn;
    private String bzo;
    private int bzp = 0;
    private boolean bzq = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bzm = linkThreadContent.link_title;
                this.bzn = linkThreadContent.link_abstract;
                this.bzo = linkThreadContent.link_head_small_pic;
                this.bzp = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ap.isEmpty(this.bzm) && com.baidu.tbadk.core.util.ap.isEmpty(this.bzn)) {
                    this.bzq = true;
                    return;
                }
                return;
            }
            this.bzq = true;
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
                        this.bzm = jSONObject2.optString("link_title");
                        this.bzn = jSONObject2.optString("link_abstract");
                        this.bzo = jSONObject2.optString("link_head_small_pic");
                        this.bzp = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ap.isEmpty(this.bzm) && com.baidu.tbadk.core.util.ap.isEmpty(this.bzn)) {
                            this.bzq = true;
                        }
                    } else {
                        this.bzq = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bzq = true;
                    return;
                }
            }
            this.bzq = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String Xs() {
        return this.bzm;
    }

    public String Xt() {
        return this.bzn;
    }

    public String Xu() {
        return this.bzo;
    }

    public int Xv() {
        return this.bzp;
    }

    public boolean Xw() {
        return this.bzq;
    }
}
