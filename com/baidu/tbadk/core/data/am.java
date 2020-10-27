package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class am {
    public static int evB = 1;
    private String evC;
    private String evD;
    private int evE = 0;
    private boolean evF = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.evC = linkThreadContent.link_abstract;
                this.evD = linkThreadContent.link_head_small_pic;
                this.evE = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.evC)) {
                    this.evF = true;
                    return;
                }
                return;
            }
            this.evF = true;
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
                        this.evC = jSONObject2.optString("link_abstract");
                        this.evD = jSONObject2.optString("link_head_small_pic");
                        this.evE = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.evC)) {
                            this.evF = true;
                        }
                    } else {
                        this.evF = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.evF = true;
                    return;
                }
            }
            this.evF = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bis() {
        return this.linkTitle;
    }

    public String bit() {
        return this.evC;
    }

    public String biu() {
        return this.evD;
    }

    public int biv() {
        return this.evE;
    }

    public boolean biw() {
        return this.evF;
    }
}
