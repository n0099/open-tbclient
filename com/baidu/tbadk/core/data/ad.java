package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int aiF = 1;
    private String aiG;
    private String aiH;
    private String aiI;
    private int aiJ = 0;
    private boolean aiK = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aiG = linkThreadContent.link_title;
                this.aiH = linkThreadContent.link_abstract;
                this.aiI = linkThreadContent.link_head_small_pic;
                this.aiJ = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ao.isEmpty(this.aiG) && com.baidu.tbadk.core.util.ao.isEmpty(this.aiH)) {
                    this.aiK = true;
                    return;
                }
                return;
            }
            this.aiK = true;
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
                        this.aiG = jSONObject2.optString("link_title");
                        this.aiH = jSONObject2.optString("link_abstract");
                        this.aiI = jSONObject2.optString("link_head_small_pic");
                        this.aiJ = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ao.isEmpty(this.aiG) && com.baidu.tbadk.core.util.ao.isEmpty(this.aiH)) {
                            this.aiK = true;
                        }
                    } else {
                        this.aiK = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aiK = true;
                    return;
                }
            }
            this.aiK = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String ve() {
        return this.aiG;
    }

    public String vf() {
        return this.aiH;
    }

    public String vg() {
        return this.aiI;
    }

    public int vh() {
        return this.aiJ;
    }

    public boolean vi() {
        return this.aiK;
    }
}
