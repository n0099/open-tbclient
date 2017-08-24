package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class aj {
    public static int XH = 1;
    public static int XI = 2;
    private String XJ;
    private String XK;
    private String XL;
    private int XM = 0;
    private boolean XN = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.u.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.XJ = linkThreadContent.link_title;
                this.XK = linkThreadContent.link_abstract;
                this.XL = linkThreadContent.link_head_small_pic;
                this.XM = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.al.isEmpty(this.XJ) && com.baidu.tbadk.core.util.al.isEmpty(this.XK)) {
                    this.XN = true;
                    return;
                }
                return;
            }
            this.XN = true;
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
                        this.XJ = jSONObject2.optString("link_title");
                        this.XK = jSONObject2.optString("link_abstract");
                        this.XL = jSONObject2.optString("link_head_small_pic");
                        this.XM = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.al.isEmpty(this.XJ) && com.baidu.tbadk.core.util.al.isEmpty(this.XK)) {
                            this.XN = true;
                        }
                    } else {
                        this.XN = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.XN = true;
                    return;
                }
            }
            this.XN = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qn() {
        return this.XJ;
    }

    public String qo() {
        return this.XK;
    }

    public String qp() {
        return this.XL;
    }

    public int qq() {
        return this.XM;
    }

    public boolean qr() {
        return this.XN;
    }
}
