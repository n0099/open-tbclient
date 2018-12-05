package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int arO = 1;
    private String arP;
    private String arQ;
    private String arR;
    private int arS = 0;
    private boolean arT = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.arP = linkThreadContent.link_title;
                this.arQ = linkThreadContent.link_abstract;
                this.arR = linkThreadContent.link_head_small_pic;
                this.arS = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ao.isEmpty(this.arP) && com.baidu.tbadk.core.util.ao.isEmpty(this.arQ)) {
                    this.arT = true;
                    return;
                }
                return;
            }
            this.arT = true;
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
                        this.arP = jSONObject2.optString("link_title");
                        this.arQ = jSONObject2.optString("link_abstract");
                        this.arR = jSONObject2.optString("link_head_small_pic");
                        this.arS = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ao.isEmpty(this.arP) && com.baidu.tbadk.core.util.ao.isEmpty(this.arQ)) {
                            this.arT = true;
                        }
                    } else {
                        this.arT = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.arT = true;
                    return;
                }
            }
            this.arT = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String yz() {
        return this.arP;
    }

    public String yA() {
        return this.arQ;
    }

    public String yB() {
        return this.arR;
    }

    public int yC() {
        return this.arS;
    }

    public boolean yD() {
        return this.arT;
    }
}
