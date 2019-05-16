package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bGw = 1;
    private int bGA = 0;
    private boolean bGB = false;
    private String bGx;
    private String bGy;
    private String bGz;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bGx = linkThreadContent.link_title;
                this.bGy = linkThreadContent.link_abstract;
                this.bGz = linkThreadContent.link_head_small_pic;
                this.bGA = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ap.isEmpty(this.bGx) && com.baidu.tbadk.core.util.ap.isEmpty(this.bGy)) {
                    this.bGB = true;
                    return;
                }
                return;
            }
            this.bGB = true;
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
                        this.bGx = jSONObject2.optString("link_title");
                        this.bGy = jSONObject2.optString("link_abstract");
                        this.bGz = jSONObject2.optString("link_head_small_pic");
                        this.bGA = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ap.isEmpty(this.bGx) && com.baidu.tbadk.core.util.ap.isEmpty(this.bGy)) {
                            this.bGB = true;
                        }
                    } else {
                        this.bGB = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bGB = true;
                    return;
                }
            }
            this.bGB = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String abZ() {
        return this.bGx;
    }

    public String aca() {
        return this.bGy;
    }

    public String acb() {
        return this.bGz;
    }

    public int acc() {
        return this.bGA;
    }

    public boolean acd() {
        return this.bGB;
    }
}
