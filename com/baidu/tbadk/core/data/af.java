package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bHx = 1;
    private String bHA;
    private int bHB = 0;
    private boolean bHC = false;
    private String bHy;
    private String bHz;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bHy = linkThreadContent.link_title;
                this.bHz = linkThreadContent.link_abstract;
                this.bHA = linkThreadContent.link_head_small_pic;
                this.bHB = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.bHy) && com.baidu.tbadk.core.util.aq.isEmpty(this.bHz)) {
                    this.bHC = true;
                    return;
                }
                return;
            }
            this.bHC = true;
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
                        this.bHy = jSONObject2.optString("link_title");
                        this.bHz = jSONObject2.optString("link_abstract");
                        this.bHA = jSONObject2.optString("link_head_small_pic");
                        this.bHB = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.bHy) && com.baidu.tbadk.core.util.aq.isEmpty(this.bHz)) {
                            this.bHC = true;
                        }
                    } else {
                        this.bHC = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bHC = true;
                    return;
                }
            }
            this.bHC = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String adb() {
        return this.bHy;
    }

    public String adc() {
        return this.bHz;
    }

    public String add() {
        return this.bHA;
    }

    public int ade() {
        return this.bHB;
    }

    public boolean adf() {
        return this.bHC;
    }
}
