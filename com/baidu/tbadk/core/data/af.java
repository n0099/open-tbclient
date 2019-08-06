package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bHy = 1;
    private String bHA;
    private String bHB;
    private int bHC = 0;
    private boolean bHD = false;
    private String bHz;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bHz = linkThreadContent.link_title;
                this.bHA = linkThreadContent.link_abstract;
                this.bHB = linkThreadContent.link_head_small_pic;
                this.bHC = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.bHz) && com.baidu.tbadk.core.util.aq.isEmpty(this.bHA)) {
                    this.bHD = true;
                    return;
                }
                return;
            }
            this.bHD = true;
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
                        this.bHz = jSONObject2.optString("link_title");
                        this.bHA = jSONObject2.optString("link_abstract");
                        this.bHB = jSONObject2.optString("link_head_small_pic");
                        this.bHC = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.bHz) && com.baidu.tbadk.core.util.aq.isEmpty(this.bHA)) {
                            this.bHD = true;
                        }
                    } else {
                        this.bHD = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bHD = true;
                    return;
                }
            }
            this.bHD = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String adc() {
        return this.bHz;
    }

    public String add() {
        return this.bHA;
    }

    public String ade() {
        return this.bHB;
    }

    public int adf() {
        return this.bHC;
    }

    public boolean adg() {
        return this.bHD;
    }
}
