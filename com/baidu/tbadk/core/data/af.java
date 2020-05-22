package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int dCM = 1;
    private String dCN;
    private String dCO;
    private int dCP = 0;
    private boolean dCQ = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.dCN = linkThreadContent.link_abstract;
                this.dCO = linkThreadContent.link_head_small_pic;
                this.dCP = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.dCN)) {
                    this.dCQ = true;
                    return;
                }
                return;
            }
            this.dCQ = true;
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
                        this.dCN = jSONObject2.optString("link_abstract");
                        this.dCO = jSONObject2.optString("link_head_small_pic");
                        this.dCP = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.dCN)) {
                            this.dCQ = true;
                        }
                    } else {
                        this.dCQ = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.dCQ = true;
                    return;
                }
            }
            this.dCQ = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aOW() {
        return this.linkTitle;
    }

    public String aOX() {
        return this.dCN;
    }

    public String aOY() {
        return this.dCO;
    }

    public int aOZ() {
        return this.dCP;
    }

    public boolean aPa() {
        return this.dCQ;
    }
}
