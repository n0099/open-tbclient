package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class ab {
    private String Fi;
    private String summary;

    public String nU() {
        return this.Fi;
    }

    public String getSummary() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.Fi = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Fi = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
