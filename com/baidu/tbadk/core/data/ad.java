package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int aon = 1;
    private String aoo;
    private String aop;
    private String aoq;
    private int aor = 0;
    private boolean aos = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aoo = linkThreadContent.link_title;
                this.aop = linkThreadContent.link_abstract;
                this.aoq = linkThreadContent.link_head_small_pic;
                this.aor = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ao.isEmpty(this.aoo) && com.baidu.tbadk.core.util.ao.isEmpty(this.aop)) {
                    this.aos = true;
                    return;
                }
                return;
            }
            this.aos = true;
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
                        this.aoo = jSONObject2.optString("link_title");
                        this.aop = jSONObject2.optString("link_abstract");
                        this.aoq = jSONObject2.optString("link_head_small_pic");
                        this.aor = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ao.isEmpty(this.aoo) && com.baidu.tbadk.core.util.ao.isEmpty(this.aop)) {
                            this.aos = true;
                        }
                    } else {
                        this.aos = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aos = true;
                    return;
                }
            }
            this.aos = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String xv() {
        return this.aoo;
    }

    public String xw() {
        return this.aop;
    }

    public String xx() {
        return this.aoq;
    }

    public int xy() {
        return this.aor;
    }

    public boolean xz() {
        return this.aos;
    }
}
