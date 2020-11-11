package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class am {
    public static int eBu = 1;
    private String eBv;
    private String eBw;
    private int eBx = 0;
    private boolean eBy = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.y.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.eBv = linkThreadContent.link_abstract;
                this.eBw = linkThreadContent.link_head_small_pic;
                this.eBx = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.eBv)) {
                    this.eBy = true;
                    return;
                }
                return;
            }
            this.eBy = true;
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
                        this.eBv = jSONObject2.optString("link_abstract");
                        this.eBw = jSONObject2.optString("link_head_small_pic");
                        this.eBx = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.at.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.at.isEmpty(this.eBv)) {
                            this.eBy = true;
                        }
                    } else {
                        this.eBy = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.eBy = true;
                    return;
                }
            }
            this.eBy = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String bkS() {
        return this.linkTitle;
    }

    public String bkT() {
        return this.eBv;
    }

    public String bkU() {
        return this.eBw;
    }

    public int bkV() {
        return this.eBx;
    }

    public boolean bkW() {
        return this.eBy;
    }
}
