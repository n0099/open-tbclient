package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int aNd = 1;
    private String aNe;
    private String aNf;
    private String aNg;
    private int aNh = 0;
    private boolean aNi = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.v.f(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.aNe = linkThreadContent.link_title;
                this.aNf = linkThreadContent.link_abstract;
                this.aNg = linkThreadContent.link_head_small_pic;
                this.aNh = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.am.isEmpty(this.aNe) && com.baidu.tbadk.core.util.am.isEmpty(this.aNf)) {
                    this.aNi = true;
                    return;
                }
                return;
            }
            this.aNi = true;
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
                        this.aNe = jSONObject2.optString("link_title");
                        this.aNf = jSONObject2.optString("link_abstract");
                        this.aNg = jSONObject2.optString("link_head_small_pic");
                        this.aNh = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.am.isEmpty(this.aNe) && com.baidu.tbadk.core.util.am.isEmpty(this.aNf)) {
                            this.aNi = true;
                        }
                    } else {
                        this.aNi = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.aNi = true;
                    return;
                }
            }
            this.aNi = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String yi() {
        return this.aNe;
    }

    public String yj() {
        return this.aNf;
    }

    public String yk() {
        return this.aNg;
    }

    public int yl() {
        return this.aNh;
    }

    public boolean ym() {
        return this.aNi;
    }
}
