package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int Xk = 1;
    private String Xl;
    private String Xm;
    private String Xn;
    private int Xo = 0;
    private boolean Xp = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.Xl = linkThreadContent.link_title;
                this.Xm = linkThreadContent.link_abstract;
                this.Xn = linkThreadContent.link_head_small_pic;
                this.Xo = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.Xl) && com.baidu.tbadk.core.util.am.isEmpty(this.Xm)) {
                    this.Xp = true;
                    return;
                }
                return;
            }
            this.Xp = true;
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
                        this.Xl = jSONObject2.optString("link_title");
                        this.Xm = jSONObject2.optString("link_abstract");
                        this.Xn = jSONObject2.optString("link_head_small_pic");
                        this.Xo = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.Xl) && com.baidu.tbadk.core.util.am.isEmpty(this.Xm)) {
                            this.Xp = true;
                        }
                    } else {
                        this.Xp = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.Xp = true;
                    return;
                }
            }
            this.Xp = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qb() {
        return this.Xl;
    }

    public String qc() {
        return this.Xm;
    }

    public String qd() {
        return this.Xn;
    }

    public int qe() {
        return this.Xo;
    }

    public boolean qf() {
        return this.Xp;
    }
}
