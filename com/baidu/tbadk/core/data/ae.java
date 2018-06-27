package com.baidu.tbadk.core.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes.dex */
public class ae {
    public static int agL = 1;
    private String agM;
    private String agN;
    private String agO;
    private int agP = 0;
    private boolean agQ = false;
    private String linkUrl;

    public void a(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo != null) {
            this.linkUrl = linkThreadInfo.link_url;
            LinkThreadContent linkThreadContent = (LinkThreadContent) com.baidu.tbadk.core.util.w.d(linkThreadInfo.link_content, 0);
            if (linkThreadContent != null) {
                this.agM = linkThreadContent.link_title;
                this.agN = linkThreadContent.link_abstract;
                this.agO = linkThreadContent.link_head_small_pic;
                this.agP = linkThreadContent.link_type.intValue();
                if (com.baidu.tbadk.core.util.ap.isEmpty(this.agM) && com.baidu.tbadk.core.util.ap.isEmpty(this.agN)) {
                    this.agQ = true;
                    return;
                }
                return;
            }
            this.agQ = true;
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
                        this.agM = jSONObject2.optString("link_title");
                        this.agN = jSONObject2.optString("link_abstract");
                        this.agO = jSONObject2.optString("link_head_small_pic");
                        this.agP = jSONObject2.optInt("link_type");
                        if (com.baidu.tbadk.core.util.ap.isEmpty(this.agM) && com.baidu.tbadk.core.util.ap.isEmpty(this.agN)) {
                            this.agQ = true;
                        }
                    } else {
                        this.agQ = true;
                    }
                    return;
                } catch (JSONException e) {
                    this.agQ = true;
                    return;
                }
            }
            this.agQ = true;
        }
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String up() {
        return this.agM;
    }

    public String uq() {
        return this.agN;
    }

    public String ur() {
        return this.agO;
    }

    public int us() {
        return this.agP;
    }

    public boolean ut() {
        return this.agQ;
    }
}
