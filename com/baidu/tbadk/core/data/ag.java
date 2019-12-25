package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ag {
    public static int cLb = 1;
    private String cLc;
    private String cLd;
    private int cLe = 0;
    private boolean cLf = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.cLc = linkThreadContent.link_abstract;
                this.cLd = linkThreadContent.link_head_small_pic;
                this.cLe = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cLc)) {
                    this.cLf = true;
                    return;
                }
                return;
            }
            this.cLf = true;
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
                        this.cLc = jSONObject2.optString("link_abstract");
                        this.cLd = jSONObject2.optString("link_head_small_pic");
                        this.cLe = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cLc)) {
                            this.cLf = true;
                        }
                    } else {
                        this.cLf = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.cLf = true;
                    return;
                }
            }
            this.cLf = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aye() {
        return this.linkTitle;
    }

    public String ayf() {
        return this.cLc;
    }

    public String ayg() {
        return this.cLd;
    }

    public int ayh() {
        return this.cLe;
    }

    public boolean ayi() {
        return this.cLf;
    }
}
