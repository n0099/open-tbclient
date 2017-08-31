package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes.dex */
public class bn extends PostData {
    public static final BdUniqueId aar = BdUniqueId.gen();
    private String Xo;
    private int position = 0;
    private String summary;

    public String td() {
        return this.Xo;
    }

    public String sU() {
        return this.summary;
    }

    public void a(TopNews topNews) {
        if (topNews != null) {
            this.Xo = topNews.news_link;
            this.summary = topNews.summary;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Xo = jSONObject.optString("news_link");
                this.summary = jSONObject.optString("summary");
                this.position = jSONObject.optInt("position", 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aar;
    }
}
