package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bl {
    private int Vd = 0;
    private int Ve = 0;
    private String link = "";

    public int sO() {
        return this.Vd;
    }

    public int sP() {
        return this.Ve;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vd = jSONObject.optInt("is_lpost", 0);
                this.Ve = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Vd = topic.is_lpost.intValue();
            this.Ve = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
