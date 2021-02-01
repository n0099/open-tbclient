package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ap {
    public static int eOa = 1;
    private String eOb;
    private String eOc;
    private String eOd;
    private int eOe = 0;
    private boolean eOf = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.eOb = linkThreadContent.link_title;
                this.eOc = linkThreadContent.link_abstract;
                this.eOd = linkThreadContent.link_head_small_pic;
                this.eOe = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.au.isEmpty(this.eOb) && com.baidu.tbadk.core.util.au.isEmpty(this.eOc)) {
                    this.eOf = true;
                    return;
                }
                return;
            }
            this.eOf = true;
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
                        this.eOb = jSONObject2.optString("link_title");
                        this.eOc = jSONObject2.optString("link_abstract");
                        this.eOd = jSONObject2.optString("link_head_small_pic");
                        this.eOe = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.au.isEmpty(this.eOb) && com.baidu.tbadk.core.util.au.isEmpty(this.eOc)) {
                            this.eOf = true;
                        }
                    } else {
                        this.eOf = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.eOf = true;
                    return;
                }
            }
            this.eOf = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bmf() {
        return this.eOb;
    }

    public String bmg() {
        return this.eOc;
    }

    public String bmh() {
        return this.eOd;
    }

    public int bmi() {
        return this.eOe;
    }

    public boolean bmj() {
        return this.eOf;
    }
}
