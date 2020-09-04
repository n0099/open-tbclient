package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class am {
    public static int dYP = 1;
    private String dYQ;
    private String dYR;
    private int dYS = 0;
    private boolean dYT = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.dYQ = linkThreadContent.link_abstract;
                this.dYR = linkThreadContent.link_head_small_pic;
                this.dYS = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.dYQ)) {
                    this.dYT = true;
                    return;
                }
                return;
            }
            this.dYT = true;
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
                        this.dYQ = jSONObject2.optString("link_abstract");
                        this.dYR = jSONObject2.optString("link_head_small_pic");
                        this.dYS = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.dYQ)) {
                            this.dYT = true;
                        }
                    } else {
                        this.dYT = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.dYT = true;
                    return;
                }
            }
            this.dYT = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bcW() {
        return this.linkTitle;
    }

    public String bcX() {
        return this.dYQ;
    }

    public String bcY() {
        return this.dYR;
    }

    public int bcZ() {
        return this.dYS;
    }

    public boolean bda() {
        return this.dYT;
    }
}
