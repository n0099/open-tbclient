package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class an {
    public static int ezL = 1;
    private String ezM;
    private String ezN;
    private int ezO = 0;
    private boolean ezP = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.ezM = linkThreadContent.link_abstract;
                this.ezN = linkThreadContent.link_head_small_pic;
                this.ezO = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.au.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.au.isEmpty(this.ezM)) {
                    this.ezP = true;
                    return;
                }
                return;
            }
            this.ezP = true;
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
                        this.ezM = jSONObject2.optString("link_abstract");
                        this.ezN = jSONObject2.optString("link_head_small_pic");
                        this.ezO = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.au.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.au.isEmpty(this.ezM)) {
                            this.ezP = true;
                        }
                    } else {
                        this.ezP = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.ezP = true;
                    return;
                }
            }
            this.ezP = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bjU() {
        return this.linkTitle;
    }

    public String bjV() {
        return this.ezM;
    }

    public String bjW() {
        return this.ezN;
    }

    public int bjX() {
        return this.ezO;
    }

    public boolean bjY() {
        return this.ezP;
    }
}
