package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class am {
    public static int enb = 1;
    private String enc;
    private String ene;
    private int enf = 0;
    private boolean eng = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.enc = linkThreadContent.link_abstract;
                this.ene = linkThreadContent.link_head_small_pic;
                this.enf = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.enc)) {
                    this.eng = true;
                    return;
                }
                return;
            }
            this.eng = true;
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
                        this.enc = jSONObject2.optString("link_abstract");
                        this.ene = jSONObject2.optString("link_head_small_pic");
                        this.enf = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.enc)) {
                            this.eng = true;
                        }
                    } else {
                        this.eng = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.eng = true;
                    return;
                }
            }
            this.eng = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bgz() {
        return this.linkTitle;
    }

    public String bgA() {
        return this.enc;
    }

    public String bgB() {
        return this.ene;
    }

    public int bgC() {
        return this.enf;
    }

    public boolean bgD() {
        return this.eng;
    }
}
