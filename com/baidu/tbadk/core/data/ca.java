package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class ca extends PostData {
    public static final BdUniqueId dVl = BdUniqueId.gen();
    private String dPW;
    private int position = 0;
    private String summary;

    public String aYz() {
        return this.dPW;
    }

    public String getSummary() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.dPW = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dPW = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
                this.position = jSONObject.optInt("position", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dVl;
    }
}
