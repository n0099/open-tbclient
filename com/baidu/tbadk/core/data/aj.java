package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class aj {
    public static int Wi = 1;
    public static int Wj = 2;
    private String Wk;
    private String Wl;
    private String Wm;
    private int Wn = 0;
    private boolean Wo = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.u.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.Wk = linkThreadContent.link_title;
                this.Wl = linkThreadContent.link_abstract;
                this.Wm = linkThreadContent.link_head_small_pic;
                this.Wn = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.al.isEmpty(this.Wk) && com.baidu.tbadk.core.util.al.isEmpty(this.Wl)) {
                    this.Wo = true;
                    return;
                }
                return;
            }
            this.Wo = true;
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
                        this.Wk = jSONObject2.optString("link_title");
                        this.Wl = jSONObject2.optString("link_abstract");
                        this.Wm = jSONObject2.optString("link_head_small_pic");
                        this.Wn = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.al.isEmpty(this.Wk) && com.baidu.tbadk.core.util.al.isEmpty(this.Wl)) {
                            this.Wo = true;
                        }
                    } else {
                        this.Wo = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.Wo = true;
                    return;
                }
            }
            this.Wo = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qc() {
        return this.Wk;
    }

    public String qd() {
        return this.Wl;
    }

    public String qe() {
        return this.Wm;
    }

    public int qf() {
        return this.Wn;
    }

    public boolean qg() {
        return this.Wo;
    }
}
