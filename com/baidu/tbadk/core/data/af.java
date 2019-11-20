package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bYQ = 1;
    private String bYR;
    private String bYS;
    private String bYT;
    private int bYU = 0;
    private boolean bYV = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bYR = linkThreadContent.link_title;
                this.bYS = linkThreadContent.link_abstract;
                this.bYT = linkThreadContent.link_head_small_pic;
                this.bYU = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.bYR) && com.baidu.tbadk.core.util.aq.isEmpty(this.bYS)) {
                    this.bYV = true;
                    return;
                }
                return;
            }
            this.bYV = true;
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
                        this.bYR = jSONObject2.optString("link_title");
                        this.bYS = jSONObject2.optString("link_abstract");
                        this.bYT = jSONObject2.optString("link_head_small_pic");
                        this.bYU = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.bYR) && com.baidu.tbadk.core.util.aq.isEmpty(this.bYS)) {
                            this.bYV = true;
                        }
                    } else {
                        this.bYV = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bYV = true;
                    return;
                }
            }
            this.bYV = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String ahk() {
        return this.bYR;
    }

    public String ahl() {
        return this.bYS;
    }

    public String ahm() {
        return this.bYT;
    }

    public int ahn() {
        return this.bYU;
    }

    public boolean aho() {
        return this.bYV;
    }
}
