package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.ai;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class aa implements ai {
    public static final BdUniqueId Rq = BdUniqueId.gen();
    private String Rr;
    private int position = 0;
    private String summary;

    public String rH() {
        return this.Rr;
    }

    public String getSummary() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.Rr = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.Rr = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Rr = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
                this.position = jSONObject.optInt("position", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return Rq;
    }
}
