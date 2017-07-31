package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class aj {
    public static int XE = 1;
    public static int XF = 2;
    private String XG;
    private String XH;
    private String XI;
    private int XJ = 0;
    private boolean XK = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.u.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.XG = linkThreadContent.link_title;
                this.XH = linkThreadContent.link_abstract;
                this.XI = linkThreadContent.link_head_small_pic;
                this.XJ = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.al.isEmpty(this.XG) && com.baidu.tbadk.core.util.al.isEmpty(this.XH)) {
                    this.XK = true;
                    return;
                }
                return;
            }
            this.XK = true;
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
                        this.XG = jSONObject2.optString("link_title");
                        this.XH = jSONObject2.optString("link_abstract");
                        this.XI = jSONObject2.optString("link_head_small_pic");
                        this.XJ = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.al.isEmpty(this.XG) && com.baidu.tbadk.core.util.al.isEmpty(this.XH)) {
                            this.XK = true;
                        }
                    } else {
                        this.XK = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.XK = true;
                    return;
                }
            }
            this.XK = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qm() {
        return this.XG;
    }

    public String qn() {
        return this.XH;
    }

    public String qo() {
        return this.XI;
    }

    public int qp() {
        return this.XJ;
    }

    public boolean qq() {
        return this.XK;
    }
}
