package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int Xq = 1;
    private String Xr;
    private String Xs;
    private String Xt;
    private int Xu = 0;
    private boolean Xv = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.Xr = linkThreadContent.link_title;
                this.Xs = linkThreadContent.link_abstract;
                this.Xt = linkThreadContent.link_head_small_pic;
                this.Xu = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.Xr) && com.baidu.tbadk.core.util.am.isEmpty(this.Xs)) {
                    this.Xv = true;
                    return;
                }
                return;
            }
            this.Xv = true;
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
                        this.Xr = jSONObject2.optString("link_title");
                        this.Xs = jSONObject2.optString("link_abstract");
                        this.Xt = jSONObject2.optString("link_head_small_pic");
                        this.Xu = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.Xr) && com.baidu.tbadk.core.util.am.isEmpty(this.Xs)) {
                            this.Xv = true;
                        }
                    } else {
                        this.Xv = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.Xv = true;
                    return;
                }
            }
            this.Xv = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qd() {
        return this.Xr;
    }

    public String qe() {
        return this.Xs;
    }

    public String qf() {
        return this.Xt;
    }

    public int qg() {
        return this.Xu;
    }

    public boolean qh() {
        return this.Xv;
    }
}
