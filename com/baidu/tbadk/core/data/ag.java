package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ag {
    public static int doN = 1;
    private String doO;
    private String doP;
    private int doQ = 0;
    private boolean doR = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.doO = linkThreadContent.link_abstract;
                this.doP = linkThreadContent.link_head_small_pic;
                this.doQ = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.doO)) {
                    this.doR = true;
                    return;
                }
                return;
            }
            this.doR = true;
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
                        this.doO = jSONObject2.optString("link_abstract");
                        this.doP = jSONObject2.optString("link_head_small_pic");
                        this.doQ = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.doO)) {
                            this.doR = true;
                        }
                    } else {
                        this.doR = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.doR = true;
                    return;
                }
            }
            this.doR = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aJb() {
        return this.linkTitle;
    }

    public String aJc() {
        return this.doO;
    }

    public String aJd() {
        return this.doP;
    }

    public int aJe() {
        return this.doQ;
    }

    public boolean aJf() {
        return this.doR;
    }
}
