package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int aMS = 1;
    private String aMT;
    private String aMU;
    private String aMV;
    private int aMW = 0;
    private boolean aMX = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.f(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aMT = linkThreadContent.link_title;
                this.aMU = linkThreadContent.link_abstract;
                this.aMV = linkThreadContent.link_head_small_pic;
                this.aMW = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.aMT) && com.baidu.tbadk.core.util.am.isEmpty(this.aMU)) {
                    this.aMX = true;
                    return;
                }
                return;
            }
            this.aMX = true;
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
                        this.aMT = jSONObject2.optString("link_title");
                        this.aMU = jSONObject2.optString("link_abstract");
                        this.aMV = jSONObject2.optString("link_head_small_pic");
                        this.aMW = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.aMT) && com.baidu.tbadk.core.util.am.isEmpty(this.aMU)) {
                            this.aMX = true;
                        }
                    } else {
                        this.aMX = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aMX = true;
                    return;
                }
            }
            this.aMX = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String yi() {
        return this.aMT;
    }

    public String yj() {
        return this.aMU;
    }

    public String yk() {
        return this.aMV;
    }

    public int yl() {
        return this.aMW;
    }

    public boolean ym() {
        return this.aMX;
    }
}
