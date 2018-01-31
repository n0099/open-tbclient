package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int aLK = 1;
    private String aLL;
    private String aLM;
    private String aLN;
    private int aLO = 0;
    private boolean aLP = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.f(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aLL = linkThreadContent.link_title;
                this.aLM = linkThreadContent.link_abstract;
                this.aLN = linkThreadContent.link_head_small_pic;
                this.aLO = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.aLL) && com.baidu.tbadk.core.util.am.isEmpty(this.aLM)) {
                    this.aLP = true;
                    return;
                }
                return;
            }
            this.aLP = true;
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
                        this.aLL = jSONObject2.optString("link_title");
                        this.aLM = jSONObject2.optString("link_abstract");
                        this.aLN = jSONObject2.optString("link_head_small_pic");
                        this.aLO = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.aLL) && com.baidu.tbadk.core.util.am.isEmpty(this.aLM)) {
                            this.aLP = true;
                        }
                    } else {
                        this.aLP = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aLP = true;
                    return;
                }
            }
            this.aLP = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String xC() {
        return this.aLL;
    }

    public String xD() {
        return this.aLM;
    }

    public String xE() {
        return this.aLN;
    }

    public int xF() {
        return this.aLO;
    }

    public boolean xG() {
        return this.aLP;
    }
}
