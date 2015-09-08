package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class aa {
    private int Wm = 0;
    private int Wn = 0;
    private String link = "";

    public int sO() {
        return this.Wm;
    }

    public int sP() {
        return this.Wn;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wm = jSONObject.optInt("is_lpost", 0);
                this.Wn = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Wm = topic.is_lpost.intValue();
            this.Wn = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
