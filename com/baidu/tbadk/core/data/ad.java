package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int Xn = 1;
    private String Xo;
    private String Xp;
    private String Xq;
    private int Xr = 0;
    private boolean Xs = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.Xo = linkThreadContent.link_title;
                this.Xp = linkThreadContent.link_abstract;
                this.Xq = linkThreadContent.link_head_small_pic;
                this.Xr = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.Xo) && com.baidu.tbadk.core.util.am.isEmpty(this.Xp)) {
                    this.Xs = true;
                    return;
                }
                return;
            }
            this.Xs = true;
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
                        this.Xo = jSONObject2.optString("link_title");
                        this.Xp = jSONObject2.optString("link_abstract");
                        this.Xq = jSONObject2.optString("link_head_small_pic");
                        this.Xr = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.Xo) && com.baidu.tbadk.core.util.am.isEmpty(this.Xp)) {
                            this.Xs = true;
                        }
                    } else {
                        this.Xs = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.Xs = true;
                    return;
                }
            }
            this.Xs = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qb() {
        return this.Xo;
    }

    public String qc() {
        return this.Xp;
    }

    public String qd() {
        return this.Xq;
    }

    public int qe() {
        return this.Xr;
    }

    public boolean qf() {
        return this.Xs;
    }
}
