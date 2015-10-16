package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class aa implements com.baidu.adp.widget.ListView.u {
    public static final BdUniqueId Wi = BdUniqueId.gen();
    private String Wj;
    private int position = 0;
    private String summary;

    public String sN() {
        return this.Wj;
    }

    public String getSummary() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.Wj = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.Wj = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wj = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
                this.position = jSONObject.optInt("position", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Wi;
    }
}
