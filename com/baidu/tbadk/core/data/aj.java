package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class aj {
    public static int XG = 1;
    public static int XH = 2;
    private String XI;
    private String XJ;
    private String XK;
    private int XL = 0;
    private boolean XM = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.u.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.XI = linkThreadContent.link_title;
                this.XJ = linkThreadContent.link_abstract;
                this.XK = linkThreadContent.link_head_small_pic;
                this.XL = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.al.isEmpty(this.XI) && com.baidu.tbadk.core.util.al.isEmpty(this.XJ)) {
                    this.XM = true;
                    return;
                }
                return;
            }
            this.XM = true;
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
                        this.XI = jSONObject2.optString("link_title");
                        this.XJ = jSONObject2.optString("link_abstract");
                        this.XK = jSONObject2.optString("link_head_small_pic");
                        this.XL = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.al.isEmpty(this.XI) && com.baidu.tbadk.core.util.al.isEmpty(this.XJ)) {
                            this.XM = true;
                        }
                    } else {
                        this.XM = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.XM = true;
                    return;
                }
            }
            this.XM = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qm() {
        return this.XI;
    }

    public String qn() {
        return this.XJ;
    }

    public String qo() {
        return this.XK;
    }

    public int qp() {
        return this.XL;
    }

    public boolean qq() {
        return this.XM;
    }
}
