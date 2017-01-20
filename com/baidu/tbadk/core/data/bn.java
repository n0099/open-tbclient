package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class bn extends com.baidu.tieba.tbadkCore.data.p {
    public static final BdUniqueId Ut = BdUniqueId.gen();
    private String RA;
    private int position = 0;
    private String summary;

    public String sK() {
        return this.RA;
    }

    public String sB() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.RA = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.RA = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
                this.position = jSONObject.optInt("position", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ut;
    }
}
