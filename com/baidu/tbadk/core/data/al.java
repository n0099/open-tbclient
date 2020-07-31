package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class al {
    public static int dPs = 1;
    private String dPt;
    private String dPu;
    private int dPv = 0;
    private boolean dPw = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.x.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.dPt = linkThreadContent.link_abstract;
                this.dPu = linkThreadContent.link_head_small_pic;
                this.dPv = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.as.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.as.isEmpty(this.dPt)) {
                    this.dPw = true;
                    return;
                }
                return;
            }
            this.dPw = true;
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
                        this.dPt = jSONObject2.optString("link_abstract");
                        this.dPu = jSONObject2.optString("link_head_small_pic");
                        this.dPv = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.as.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.as.isEmpty(this.dPt)) {
                            this.dPw = true;
                        }
                    } else {
                        this.dPw = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.dPw = true;
                    return;
                }
            }
            this.dPw = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aUD() {
        return this.linkTitle;
    }

    public String aUE() {
        return this.dPt;
    }

    public String aUF() {
        return this.dPu;
    }

    public int aUG() {
        return this.dPv;
    }

    public boolean aUH() {
        return this.dPw;
    }
}
