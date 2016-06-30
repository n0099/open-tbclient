package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class be extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId RE = BdUniqueId.gen();
    private String OV;
    private int position = 0;
    private String summary;

    public String rI() {
        return this.OV;
    }

    public String getSummary() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.OV = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.OV = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
                this.position = jSONObject.optInt("position", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RE;
    }
}
