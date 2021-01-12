package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ao {
    public static int eLP = 1;
    private String eLQ;
    private String eLR;
    private String eLS;
    private int eLT = 0;
    private boolean eLU = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.x.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.eLQ = linkThreadContent.link_title;
                this.eLR = linkThreadContent.link_abstract;
                this.eLS = linkThreadContent.link_head_small_pic;
                this.eLT = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.at.isEmpty(this.eLQ) && com.baidu.tbadk.core.util.at.isEmpty(this.eLR)) {
                    this.eLU = true;
                    return;
                }
                return;
            }
            this.eLU = true;
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
                        this.eLQ = jSONObject2.optString("link_title");
                        this.eLR = jSONObject2.optString("link_abstract");
                        this.eLS = jSONObject2.optString("link_head_small_pic");
                        this.eLT = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.at.isEmpty(this.eLQ) && com.baidu.tbadk.core.util.at.isEmpty(this.eLR)) {
                            this.eLU = true;
                        }
                    } else {
                        this.eLU = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.eLU = true;
                    return;
                }
            }
            this.eLU = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String blN() {
        return this.eLQ;
    }

    public String blO() {
        return this.eLR;
    }

    public String blP() {
        return this.eLS;
    }

    public int blQ() {
        return this.eLT;
    }

    public boolean blR() {
        return this.eLU;
    }
}
