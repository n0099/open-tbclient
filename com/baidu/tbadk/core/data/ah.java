package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ah {
    public static int WX = 1;
    private String WY;
    private String WZ;
    private String Xa;
    private int Xb = 0;
    private boolean Xc = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.WY = linkThreadContent.link_title;
                this.WZ = linkThreadContent.link_abstract;
                this.Xa = linkThreadContent.link_head_small_pic;
                this.Xb = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.WY) && com.baidu.tbadk.core.util.am.isEmpty(this.WZ)) {
                    this.Xc = true;
                    return;
                }
                return;
            }
            this.Xc = true;
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
                        this.WY = jSONObject2.optString("link_title");
                        this.WZ = jSONObject2.optString("link_abstract");
                        this.Xa = jSONObject2.optString("link_head_small_pic");
                        this.Xb = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.WY) && com.baidu.tbadk.core.util.am.isEmpty(this.WZ)) {
                            this.Xc = true;
                        }
                    } else {
                        this.Xc = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.Xc = true;
                    return;
                }
            }
            this.Xc = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qa() {
        return this.WY;
    }

    public String qb() {
        return this.WZ;
    }

    public String qc() {
        return this.Xa;
    }

    public int qd() {
        return this.Xb;
    }

    public boolean qe() {
        return this.Xc;
    }
}
