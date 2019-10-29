package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bZH = 1;
    private String bZI;
    private String bZJ;
    private String bZK;
    private int bZL = 0;
    private boolean bZM = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bZI = linkThreadContent.link_title;
                this.bZJ = linkThreadContent.link_abstract;
                this.bZK = linkThreadContent.link_head_small_pic;
                this.bZL = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.bZI) && com.baidu.tbadk.core.util.aq.isEmpty(this.bZJ)) {
                    this.bZM = true;
                    return;
                }
                return;
            }
            this.bZM = true;
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
                        this.bZI = jSONObject2.optString("link_title");
                        this.bZJ = jSONObject2.optString("link_abstract");
                        this.bZK = jSONObject2.optString("link_head_small_pic");
                        this.bZL = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.bZI) && com.baidu.tbadk.core.util.aq.isEmpty(this.bZJ)) {
                            this.bZM = true;
                        }
                    } else {
                        this.bZM = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bZM = true;
                    return;
                }
            }
            this.bZM = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String ahm() {
        return this.bZI;
    }

    public String ahn() {
        return this.bZJ;
    }

    public String aho() {
        return this.bZK;
    }

    public int ahp() {
        return this.bZL;
    }

    public boolean ahq() {
        return this.bZM;
    }
}
