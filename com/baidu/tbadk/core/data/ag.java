package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ag {
    public static int cLl = 1;
    private String cLm;
    private String cLn;
    private int cLo = 0;
    private boolean cLp = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.cLm = linkThreadContent.link_abstract;
                this.cLn = linkThreadContent.link_head_small_pic;
                this.cLo = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cLm)) {
                    this.cLp = true;
                    return;
                }
                return;
            }
            this.cLp = true;
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
                        this.cLm = jSONObject2.optString("link_abstract");
                        this.cLn = jSONObject2.optString("link_head_small_pic");
                        this.cLo = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cLm)) {
                            this.cLp = true;
                        }
                    } else {
                        this.cLp = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.cLp = true;
                    return;
                }
            }
            this.cLp = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String ayx() {
        return this.linkTitle;
    }

    public String ayy() {
        return this.cLm;
    }

    public String ayz() {
        return this.cLn;
    }

    public int ayA() {
        return this.cLo;
    }

    public boolean ayB() {
        return this.cLp;
    }
}
