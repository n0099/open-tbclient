package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int aLH = 1;
    private String aLI;
    private String aLJ;
    private String aLK;
    private int aLL = 0;
    private boolean aLM = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.f(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aLI = linkThreadContent.link_title;
                this.aLJ = linkThreadContent.link_abstract;
                this.aLK = linkThreadContent.link_head_small_pic;
                this.aLL = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.aLI) && com.baidu.tbadk.core.util.am.isEmpty(this.aLJ)) {
                    this.aLM = true;
                    return;
                }
                return;
            }
            this.aLM = true;
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
                        this.aLI = jSONObject2.optString("link_title");
                        this.aLJ = jSONObject2.optString("link_abstract");
                        this.aLK = jSONObject2.optString("link_head_small_pic");
                        this.aLL = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.aLI) && com.baidu.tbadk.core.util.am.isEmpty(this.aLJ)) {
                            this.aLM = true;
                        }
                    } else {
                        this.aLM = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aLM = true;
                    return;
                }
            }
            this.aLM = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String xB() {
        return this.aLI;
    }

    public String xC() {
        return this.aLJ;
    }

    public String xD() {
        return this.aLK;
    }

    public int xE() {
        return this.aLL;
    }

    public boolean xF() {
        return this.aLM;
    }
}
