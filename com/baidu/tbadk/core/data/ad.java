package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int asq = 1;
    private String asr;
    private String ass;
    private String ast;
    private int asu = 0;
    private boolean asv = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.asr = linkThreadContent.link_title;
                this.ass = linkThreadContent.link_abstract;
                this.ast = linkThreadContent.link_head_small_pic;
                this.asu = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ao.isEmpty(this.asr) && com.baidu.tbadk.core.util.ao.isEmpty(this.ass)) {
                    this.asv = true;
                    return;
                }
                return;
            }
            this.asv = true;
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
                        this.asr = jSONObject2.optString("link_title");
                        this.ass = jSONObject2.optString("link_abstract");
                        this.ast = jSONObject2.optString("link_head_small_pic");
                        this.asu = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ao.isEmpty(this.asr) && com.baidu.tbadk.core.util.ao.isEmpty(this.ass)) {
                            this.asv = true;
                        }
                    } else {
                        this.asv = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.asv = true;
                    return;
                }
            }
            this.asv = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String yM() {
        return this.asr;
    }

    public String yN() {
        return this.ass;
    }

    public String yO() {
        return this.ast;
    }

    public int yP() {
        return this.asu;
    }

    public boolean yQ() {
        return this.asv;
    }
}
