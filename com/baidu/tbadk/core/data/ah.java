package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ah {
    public static int WF = 1;
    public static int WG = 2;
    private String WH;
    private String WI;
    private String WJ;
    private int WK = 0;
    private boolean WL = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.WH = linkThreadContent.link_title;
                this.WI = linkThreadContent.link_abstract;
                this.WJ = linkThreadContent.link_head_small_pic;
                this.WK = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.WH) && com.baidu.tbadk.core.util.am.isEmpty(this.WI)) {
                    this.WL = true;
                    return;
                }
                return;
            }
            this.WL = true;
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
                        this.WH = jSONObject2.optString("link_title");
                        this.WI = jSONObject2.optString("link_abstract");
                        this.WJ = jSONObject2.optString("link_head_small_pic");
                        this.WK = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.WH) && com.baidu.tbadk.core.util.am.isEmpty(this.WI)) {
                            this.WL = true;
                        }
                    } else {
                        this.WL = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.WL = true;
                    return;
                }
            }
            this.WL = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String pV() {
        return this.WH;
    }

    public String pW() {
        return this.WI;
    }

    public String pX() {
        return this.WJ;
    }

    public int pY() {
        return this.WK;
    }

    public boolean pZ() {
        return this.WL;
    }
}
