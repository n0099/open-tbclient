package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int aMT = 1;
    private String aMU;
    private String aMV;
    private String aMW;
    private int aMX = 0;
    private boolean aMY = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.f(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aMU = linkThreadContent.link_title;
                this.aMV = linkThreadContent.link_abstract;
                this.aMW = linkThreadContent.link_head_small_pic;
                this.aMX = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.aMU) && com.baidu.tbadk.core.util.am.isEmpty(this.aMV)) {
                    this.aMY = true;
                    return;
                }
                return;
            }
            this.aMY = true;
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
                        this.aMU = jSONObject2.optString("link_title");
                        this.aMV = jSONObject2.optString("link_abstract");
                        this.aMW = jSONObject2.optString("link_head_small_pic");
                        this.aMX = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.aMU) && com.baidu.tbadk.core.util.am.isEmpty(this.aMV)) {
                            this.aMY = true;
                        }
                    } else {
                        this.aMY = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aMY = true;
                    return;
                }
            }
            this.aMY = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String yi() {
        return this.aMU;
    }

    public String yj() {
        return this.aMV;
    }

    public String yk() {
        return this.aMW;
    }

    public int yl() {
        return this.aMX;
    }

    public boolean ym() {
        return this.aMY;
    }
}
