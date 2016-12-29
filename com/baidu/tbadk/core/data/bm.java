package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class bm extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId Vf = BdUniqueId.gen();
    private String Sr;
    private int position = 0;
    private String summary;

    public String sQ() {
        return this.Sr;
    }

    public String sH() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.Sr = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Sr = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
                this.position = jSONObject.optInt("position", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Vf;
    }
}
