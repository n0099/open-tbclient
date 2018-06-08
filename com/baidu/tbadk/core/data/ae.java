package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ae {
    public static int agw = 1;
    private int agA = 0;
    private boolean agB = false;
    private String agx;
    private String agy;
    private String agz;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.w.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.agx = linkThreadContent.link_title;
                this.agy = linkThreadContent.link_abstract;
                this.agz = linkThreadContent.link_head_small_pic;
                this.agA = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ao.isEmpty(this.agx) && com.baidu.tbadk.core.util.ao.isEmpty(this.agy)) {
                    this.agB = true;
                    return;
                }
                return;
            }
            this.agB = true;
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
                        this.agx = jSONObject2.optString("link_title");
                        this.agy = jSONObject2.optString("link_abstract");
                        this.agz = jSONObject2.optString("link_head_small_pic");
                        this.agA = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ao.isEmpty(this.agx) && com.baidu.tbadk.core.util.ao.isEmpty(this.agy)) {
                            this.agB = true;
                        }
                    } else {
                        this.agB = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.agB = true;
                    return;
                }
            }
            this.agB = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String uj() {
        return this.agx;
    }

    public String uk() {
        return this.agy;
    }

    public String ul() {
        return this.agz;
    }

    public int um() {
        return this.agA;
    }

    public boolean un() {
        return this.agB;
    }
}
