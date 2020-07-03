package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ak {
    public static int dJh = 1;
    private String dJi;
    private String dJj;
    private int dJk = 0;
    private boolean dJl = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.w.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.dJi = linkThreadContent.link_abstract;
                this.dJj = linkThreadContent.link_head_small_pic;
                this.dJk = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ar.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.ar.isEmpty(this.dJi)) {
                    this.dJl = true;
                    return;
                }
                return;
            }
            this.dJl = true;
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
                        this.linkTitle = jSONObject2.optString("link_title");
                        this.dJi = jSONObject2.optString("link_abstract");
                        this.dJj = jSONObject2.optString("link_head_small_pic");
                        this.dJk = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ar.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.ar.isEmpty(this.dJi)) {
                            this.dJl = true;
                        }
                    } else {
                        this.dJl = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.dJl = true;
                    return;
                }
            }
            this.dJl = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aQH() {
        return this.linkTitle;
    }

    public String aQI() {
        return this.dJi;
    }

    public String aQJ() {
        return this.dJj;
    }

    public int aQK() {
        return this.dJk;
    }

    public boolean aQL() {
        return this.dJl;
    }
}
