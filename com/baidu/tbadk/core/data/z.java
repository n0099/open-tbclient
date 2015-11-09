package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class z {
    private int Wj = 0;
    private int Wk = 0;
    private String link = "";

    public int sL() {
        return this.Wj;
    }

    public int sM() {
        return this.Wk;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wj = jSONObject.optInt("is_lpost", 0);
                this.Wk = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Wj = topic.is_lpost.intValue();
            this.Wk = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
