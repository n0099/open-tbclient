package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class aj {
    public static int WQ = 1;
    public static int WR = 2;
    private String WS;
    private String WT;
    private String WU;
    private int WV = 0;
    private boolean WW = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.WS = linkThreadContent.link_title;
                this.WT = linkThreadContent.link_abstract;
                this.WU = linkThreadContent.link_head_small_pic;
                this.WV = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.WS) && com.baidu.tbadk.core.util.am.isEmpty(this.WT)) {
                    this.WW = true;
                    return;
                }
                return;
            }
            this.WW = true;
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
                        this.WS = jSONObject2.optString("link_title");
                        this.WT = jSONObject2.optString("link_abstract");
                        this.WU = jSONObject2.optString("link_head_small_pic");
                        this.WV = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.WS) && com.baidu.tbadk.core.util.am.isEmpty(this.WT)) {
                            this.WW = true;
                        }
                    } else {
                        this.WW = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.WW = true;
                    return;
                }
            }
            this.WW = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qi() {
        return this.WS;
    }

    public String qj() {
        return this.WT;
    }

    public String qk() {
        return this.WU;
    }

    public int ql() {
        return this.WV;
    }

    public boolean qm() {
        return this.WW;
    }
}
