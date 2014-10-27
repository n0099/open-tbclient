package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class u {
    private String AQ;
    private String summary;

    public String kR() {
        return this.AQ;
    }

    public String kK() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.AQ = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.AQ = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
