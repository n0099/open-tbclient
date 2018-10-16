package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int anA = 1;
    private String anB;
    private String anC;
    private String anD;
    private int anE = 0;
    private boolean anF = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.anB = linkThreadContent.link_title;
                this.anC = linkThreadContent.link_abstract;
                this.anD = linkThreadContent.link_head_small_pic;
                this.anE = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ao.isEmpty(this.anB) && com.baidu.tbadk.core.util.ao.isEmpty(this.anC)) {
                    this.anF = true;
                    return;
                }
                return;
            }
            this.anF = true;
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
                        this.anB = jSONObject2.optString("link_title");
                        this.anC = jSONObject2.optString("link_abstract");
                        this.anD = jSONObject2.optString("link_head_small_pic");
                        this.anE = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ao.isEmpty(this.anB) && com.baidu.tbadk.core.util.ao.isEmpty(this.anC)) {
                            this.anF = true;
                        }
                    } else {
                        this.anF = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.anF = true;
                    return;
                }
            }
            this.anF = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String xn() {
        return this.anB;
    }

    public String xo() {
        return this.anC;
    }

    public String xp() {
        return this.anD;
    }

    public int xq() {
        return this.anE;
    }

    public boolean xr() {
        return this.anF;
    }
}
