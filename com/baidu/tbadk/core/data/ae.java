package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ae {
    public static int Yu = 1;
    private String Yv;
    private String Yw;
    private String Yx;
    private int Yy = 0;
    private boolean Yz = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.c(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.Yv = linkThreadContent.link_title;
                this.Yw = linkThreadContent.link_abstract;
                this.Yx = linkThreadContent.link_head_small_pic;
                this.Yy = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.an.isEmpty(this.Yv) && com.baidu.tbadk.core.util.an.isEmpty(this.Yw)) {
                    this.Yz = true;
                    return;
                }
                return;
            }
            this.Yz = true;
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
                        this.Yv = jSONObject2.optString("link_title");
                        this.Yw = jSONObject2.optString("link_abstract");
                        this.Yx = jSONObject2.optString("link_head_small_pic");
                        this.Yy = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.an.isEmpty(this.Yv) && com.baidu.tbadk.core.util.an.isEmpty(this.Yw)) {
                            this.Yz = true;
                        }
                    } else {
                        this.Yz = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.Yz = true;
                    return;
                }
            }
            this.Yz = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String qO() {
        return this.Yv;
    }

    public String qP() {
        return this.Yw;
    }

    public String qQ() {
        return this.Yx;
    }

    public int qR() {
        return this.Yy;
    }

    public boolean qS() {
        return this.Yz;
    }
}
