package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ao {
    public static int eGK = 1;
    private String eGL;
    private String eGM;
    private int eGN = 0;
    private boolean eGO = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.eGL = linkThreadContent.link_abstract;
                this.eGM = linkThreadContent.link_head_small_pic;
                this.eGN = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.au.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.au.isEmpty(this.eGL)) {
                    this.eGO = true;
                    return;
                }
                return;
            }
            this.eGO = true;
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
                        this.linkTitle = jSONObject2.optString("link_title");
                        this.eGL = jSONObject2.optString("link_abstract");
                        this.eGM = jSONObject2.optString("link_head_small_pic");
                        this.eGN = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.au.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.au.isEmpty(this.eGL)) {
                            this.eGO = true;
                        }
                    } else {
                        this.eGO = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.eGO = true;
                    return;
                }
            }
            this.eGO = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bnh() {
        return this.linkTitle;
    }

    public String bni() {
        return this.eGL;
    }

    public String bnj() {
        return this.eGM;
    }

    public int bnk() {
        return this.eGN;
    }

    public boolean bnl() {
        return this.eGO;
    }
}
