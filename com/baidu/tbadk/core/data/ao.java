package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ao {
    public static int eQA = 1;
    private String eQB;
    private String eQC;
    private String eQD;
    private int eQE = 0;
    private boolean eQF = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.x.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.eQB = linkThreadContent.link_title;
                this.eQC = linkThreadContent.link_abstract;
                this.eQD = linkThreadContent.link_head_small_pic;
                this.eQE = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.at.isEmpty(this.eQB) && com.baidu.tbadk.core.util.at.isEmpty(this.eQC)) {
                    this.eQF = true;
                    return;
                }
                return;
            }
            this.eQF = true;
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
                        this.eQB = jSONObject2.optString("link_title");
                        this.eQC = jSONObject2.optString("link_abstract");
                        this.eQD = jSONObject2.optString("link_head_small_pic");
                        this.eQE = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.at.isEmpty(this.eQB) && com.baidu.tbadk.core.util.at.isEmpty(this.eQC)) {
                            this.eQF = true;
                        }
                    } else {
                        this.eQF = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.eQF = true;
                    return;
                }
            }
            this.eQF = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bpH() {
        return this.eQB;
    }

    public String bpI() {
        return this.eQC;
    }

    public String bpJ() {
        return this.eQD;
    }

    public int bpK() {
        return this.eQE;
    }

    public boolean bpL() {
        return this.eQF;
    }
}
