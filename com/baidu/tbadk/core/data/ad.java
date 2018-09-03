package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ad {
    public static int agf = 1;
    private String agg;
    private String agh;
    private String agi;
    private int agj = 0;
    private boolean agk = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.w.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.agg = linkThreadContent.link_title;
                this.agh = linkThreadContent.link_abstract;
                this.agi = linkThreadContent.link_head_small_pic;
                this.agj = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ap.isEmpty(this.agg) && com.baidu.tbadk.core.util.ap.isEmpty(this.agh)) {
                    this.agk = true;
                    return;
                }
                return;
            }
            this.agk = true;
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
                        this.agg = jSONObject2.optString("link_title");
                        this.agh = jSONObject2.optString("link_abstract");
                        this.agi = jSONObject2.optString("link_head_small_pic");
                        this.agj = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ap.isEmpty(this.agg) && com.baidu.tbadk.core.util.ap.isEmpty(this.agh)) {
                            this.agk = true;
                        }
                    } else {
                        this.agk = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.agk = true;
                    return;
                }
            }
            this.agk = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String ub() {
        return this.agg;
    }

    public String uc() {
        return this.agh;
    }

    public String ud() {
        return this.agi;
    }

    public int ue() {
        return this.agj;
    }

    public boolean uf() {
        return this.agk;
    }
}
