package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class ab {
    private String Ff;
    private String summary;

    public String nN() {
        return this.Ff;
    }

    public String getSummary() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.Ff = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ff = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
