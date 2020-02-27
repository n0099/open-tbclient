package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ag {
    public static int cPo = 1;
    private String cPp;
    private String cPq;
    private int cPr = 0;
    private boolean cPs = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.cPp = linkThreadContent.link_abstract;
                this.cPq = linkThreadContent.link_head_small_pic;
                this.cPr = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cPp)) {
                    this.cPs = true;
                    return;
                }
                return;
            }
            this.cPs = true;
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
                        this.cPp = jSONObject2.optString("link_abstract");
                        this.cPq = jSONObject2.optString("link_head_small_pic");
                        this.cPr = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cPp)) {
                            this.cPs = true;
                        }
                    } else {
                        this.cPs = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.cPs = true;
                    return;
                }
            }
            this.cPs = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aAL() {
        return this.linkTitle;
    }

    public String aAM() {
        return this.cPp;
    }

    public String aAN() {
        return this.cPq;
    }

    public int aAO() {
        return this.cPr;
    }

    public boolean aAP() {
        return this.cPs;
    }
}
