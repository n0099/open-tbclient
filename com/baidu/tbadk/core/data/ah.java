package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ah {
    public static int WR = 1;
    public static int WS = 2;
    private String WT;
    private String WU;
    private String WV;
    private int WW = 0;
    private boolean WX = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.WT = linkThreadContent.link_title;
                this.WU = linkThreadContent.link_abstract;
                this.WV = linkThreadContent.link_head_small_pic;
                this.WW = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.WT) && com.baidu.tbadk.core.util.am.isEmpty(this.WU)) {
                    this.WX = true;
                    return;
                }
                return;
            }
            this.WX = true;
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
                        this.WT = jSONObject2.optString("link_title");
                        this.WU = jSONObject2.optString("link_abstract");
                        this.WV = jSONObject2.optString("link_head_small_pic");
                        this.WW = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.WT) && com.baidu.tbadk.core.util.am.isEmpty(this.WU)) {
                            this.WX = true;
                        }
                    } else {
                        this.WX = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.WX = true;
                    return;
                }
            }
            this.WX = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qc() {
        return this.WT;
    }

    public String qd() {
        return this.WU;
    }

    public String qe() {
        return this.WV;
    }

    public int qf() {
        return this.WW;
    }

    public boolean qg() {
        return this.WX;
    }
}
