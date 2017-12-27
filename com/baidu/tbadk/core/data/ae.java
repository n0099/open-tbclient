package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ae {
    public static int aLL = 1;
    private String aLM;
    private String aLN;
    private String aLO;
    private int aLP = 0;
    private boolean aLQ = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.f(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aLM = linkThreadContent.link_title;
                this.aLN = linkThreadContent.link_abstract;
                this.aLO = linkThreadContent.link_head_small_pic;
                this.aLP = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.aLM) && com.baidu.tbadk.core.util.am.isEmpty(this.aLN)) {
                    this.aLQ = true;
                    return;
                }
                return;
            }
            this.aLQ = true;
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
                        this.aLM = jSONObject2.optString("link_title");
                        this.aLN = jSONObject2.optString("link_abstract");
                        this.aLO = jSONObject2.optString("link_head_small_pic");
                        this.aLP = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.aLM) && com.baidu.tbadk.core.util.am.isEmpty(this.aLN)) {
                            this.aLQ = true;
                        }
                    } else {
                        this.aLQ = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aLQ = true;
                    return;
                }
            }
            this.aLQ = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String xE() {
        return this.aLM;
    }

    public String xF() {
        return this.aLN;
    }

    public String xG() {
        return this.aLO;
    }

    public int xH() {
        return this.aLP;
    }

    public boolean xI() {
        return this.aLQ;
    }
}
