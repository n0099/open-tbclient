package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ap {
    public static int ePB = 1;
    private String ePC;
    private String ePD;
    private String ePE;
    private int ePF = 0;
    private boolean ePG = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.ePC = linkThreadContent.link_title;
                this.ePD = linkThreadContent.link_abstract;
                this.ePE = linkThreadContent.link_head_small_pic;
                this.ePF = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.au.isEmpty(this.ePC) && com.baidu.tbadk.core.util.au.isEmpty(this.ePD)) {
                    this.ePG = true;
                    return;
                }
                return;
            }
            this.ePG = true;
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
                        this.ePC = jSONObject2.optString("link_title");
                        this.ePD = jSONObject2.optString("link_abstract");
                        this.ePE = jSONObject2.optString("link_head_small_pic");
                        this.ePF = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.au.isEmpty(this.ePC) && com.baidu.tbadk.core.util.au.isEmpty(this.ePD)) {
                            this.ePG = true;
                        }
                    } else {
                        this.ePG = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.ePG = true;
                    return;
                }
            }
            this.ePG = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bmh() {
        return this.ePC;
    }

    public String bmi() {
        return this.ePD;
    }

    public String bmj() {
        return this.ePE;
    }

    public int bmk() {
        return this.ePF;
    }

    public boolean bml() {
        return this.ePG;
    }
}
