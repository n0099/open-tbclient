package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ag {
    public static int doJ = 1;
    private String doK;
    private String doL;
    private int doM = 0;
    private boolean doN = false;
    private String linkTitle;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.getItem(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.linkTitle = linkThreadContent.link_title;
                this.doK = linkThreadContent.link_abstract;
                this.doL = linkThreadContent.link_head_small_pic;
                this.doM = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.doK)) {
                    this.doN = true;
                    return;
                }
                return;
            }
            this.doN = true;
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
                        this.doK = jSONObject2.optString("link_abstract");
                        this.doL = jSONObject2.optString("link_head_small_pic");
                        this.doM = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.aq.isEmpty(this.linkTitle) && com.baidu.tbadk.core.util.aq.isEmpty(this.doK)) {
                            this.doN = true;
                        }
                    } else {
                        this.doN = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.doN = true;
                    return;
                }
            }
            this.doN = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String aJd() {
        return this.linkTitle;
    }

    public String aJe() {
        return this.doK;
    }

    public String aJf() {
        return this.doL;
    }

    public int aJg() {
        return this.doM;
    }

    public boolean aJh() {
        return this.doN;
    }
}
