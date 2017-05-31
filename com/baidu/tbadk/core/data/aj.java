package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class aj {
    public static int VS = 1;
    public static int VT = 2;
    private String VU;
    private String VV;
    private String VW;
    private int VX = 0;
    private boolean VY = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.x.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.VU = linkThreadContent.link_title;
                this.VV = linkThreadContent.link_abstract;
                this.VW = linkThreadContent.link_head_small_pic;
                this.VX = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.au.isEmpty(this.VU) && com.baidu.tbadk.core.util.au.isEmpty(this.VV)) {
                    this.VY = true;
                    return;
                }
                return;
            }
            this.VY = true;
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
                        this.VU = jSONObject2.optString("link_title");
                        this.VV = jSONObject2.optString("link_abstract");
                        this.VW = jSONObject2.optString("link_head_small_pic");
                        this.VX = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.au.isEmpty(this.VU) && com.baidu.tbadk.core.util.au.isEmpty(this.VV)) {
                            this.VY = true;
                        }
                    } else {
                        this.VY = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.VY = true;
                    return;
                }
            }
            this.VY = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qc() {
        return this.VU;
    }

    public String qd() {
        return this.VV;
    }

    public String qe() {
        return this.VW;
    }

    public int qf() {
        return this.VX;
    }

    public boolean qg() {
        return this.VY;
    }
}
