package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ag {
    public static int cPp = 1;
    private String cPq;
    private String cPr;
    private int cPs = 0;
    private boolean cPt = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.cPq = linkThreadContent.link_abstract;
                this.cPr = linkThreadContent.link_head_small_pic;
                this.cPs = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cPq)) {
                    this.cPt = true;
                    return;
                }
                return;
            }
            this.cPt = true;
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
                        this.cPq = jSONObject2.optString("link_abstract");
                        this.cPr = jSONObject2.optString("link_head_small_pic");
                        this.cPs = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.cPq)) {
                            this.cPt = true;
                        }
                    } else {
                        this.cPt = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.cPt = true;
                    return;
                }
            }
            this.cPt = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aAN() {
        return this.linkTitle;
    }

    public String aAO() {
        return this.cPq;
    }

    public String aAP() {
        return this.cPr;
    }

    public int aAQ() {
        return this.cPs;
    }

    public boolean aAR() {
        return this.cPt;
    }
}
