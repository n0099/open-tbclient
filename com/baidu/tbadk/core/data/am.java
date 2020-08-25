package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes2.dex */
public class am {
    public static int dYL = 1;
    private String dYM;
    private String dYN;
    private int dYO = 0;
    private boolean dYP = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.dYM = linkThreadContent.link_abstract;
                this.dYN = linkThreadContent.link_head_small_pic;
                this.dYO = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.dYM)) {
                    this.dYP = true;
                    return;
                }
                return;
            }
            this.dYP = true;
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
                        this.dYM = jSONObject2.optString("link_abstract");
                        this.dYN = jSONObject2.optString("link_head_small_pic");
                        this.dYO = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.dYM)) {
                            this.dYP = true;
                        }
                    } else {
                        this.dYP = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.dYP = true;
                    return;
                }
            }
            this.dYP = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bcW() {
        return this.linkTitle;
    }

    public String bcX() {
        return this.dYM;
    }

    public String bcY() {
        return this.dYN;
    }

    public int bcZ() {
        return this.dYO;
    }

    public boolean bda() {
        return this.dYP;
    }
}
