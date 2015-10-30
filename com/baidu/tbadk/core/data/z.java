package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class z {
    private int Wg = 0;
    private int Wh = 0;
    private String link = "";

    public int sI() {
        return this.Wg;
    }

    public int sJ() {
        return this.Wh;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wg = jSONObject.optInt("is_lpost", 0);
                this.Wh = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Wg = topic.is_lpost.intValue();
            this.Wh = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
