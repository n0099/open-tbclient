package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int asr = 1;
    private String ass;
    private String ast;
    private String asu;
    private int asv = 0;
    private boolean asw = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.ass = linkThreadContent.link_title;
                this.ast = linkThreadContent.link_abstract;
                this.asu = linkThreadContent.link_head_small_pic;
                this.asv = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ao.isEmpty(this.ass) && com.baidu.tbadk.core.util.ao.isEmpty(this.ast)) {
                    this.asw = true;
                    return;
                }
                return;
            }
            this.asw = true;
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
                        this.ass = jSONObject2.optString("link_title");
                        this.ast = jSONObject2.optString("link_abstract");
                        this.asu = jSONObject2.optString("link_head_small_pic");
                        this.asv = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ao.isEmpty(this.ass) && com.baidu.tbadk.core.util.ao.isEmpty(this.ast)) {
                            this.asw = true;
                        }
                    } else {
                        this.asw = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.asw = true;
                    return;
                }
            }
            this.asw = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String yM() {
        return this.ass;
    }

    public String yN() {
        return this.ast;
    }

    public String yO() {
        return this.asu;
    }

    public int yP() {
        return this.asv;
    }

    public boolean yQ() {
        return this.asw;
    }
}
