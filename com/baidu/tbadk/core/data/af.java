package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bGx = 1;
    private String bGA;
    private int bGB = 0;
    private boolean bGC = false;
    private String bGy;
    private String bGz;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bGy = linkThreadContent.link_title;
                this.bGz = linkThreadContent.link_abstract;
                this.bGA = linkThreadContent.link_head_small_pic;
                this.bGB = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ap.isEmpty(this.bGy) && com.baidu.tbadk.core.util.ap.isEmpty(this.bGz)) {
                    this.bGC = true;
                    return;
                }
                return;
            }
            this.bGC = true;
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
                        this.bGy = jSONObject2.optString("link_title");
                        this.bGz = jSONObject2.optString("link_abstract");
                        this.bGA = jSONObject2.optString("link_head_small_pic");
                        this.bGB = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ap.isEmpty(this.bGy) && com.baidu.tbadk.core.util.ap.isEmpty(this.bGz)) {
                            this.bGC = true;
                        }
                    } else {
                        this.bGC = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bGC = true;
                    return;
                }
            }
            this.bGC = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String abZ() {
        return this.bGy;
    }

    public String aca() {
        return this.bGz;
    }

    public String acb() {
        return this.bGA;
    }

    public int acc() {
        return this.bGB;
    }

    public boolean acd() {
        return this.bGC;
    }
}
