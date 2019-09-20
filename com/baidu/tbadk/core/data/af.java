package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class af {
    public static int bHW = 1;
    private String bHX;
    private String bHY;
    private String bHZ;
    private int bIa = 0;
    private boolean bIb = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.bHX = linkThreadContent.link_title;
                this.bHY = linkThreadContent.link_abstract;
                this.bHZ = linkThreadContent.link_head_small_pic;
                this.bIa = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.bHX) && com.baidu.tbadk.core.util.aq.isEmpty(this.bHY)) {
                    this.bIb = true;
                    return;
                }
                return;
            }
            this.bIb = true;
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
                        this.bHX = jSONObject2.optString("link_title");
                        this.bHY = jSONObject2.optString("link_abstract");
                        this.bHZ = jSONObject2.optString("link_head_small_pic");
                        this.bIa = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.bHX) && com.baidu.tbadk.core.util.aq.isEmpty(this.bHY)) {
                            this.bIb = true;
                        }
                    } else {
                        this.bIb = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.bIb = true;
                    return;
                }
            }
            this.bIb = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String adg() {
        return this.bHX;
    }

    public String adh() {
        return this.bHY;
    }

    public String adi() {
        return this.bHZ;
    }

    public int adj() {
        return this.bIa;
    }

    public boolean adk() {
        return this.bIb;
    }
}
