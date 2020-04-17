package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bn {
    private int dui = 0;
    private int duj = 0;
    private String link = "";

    public int aML() {
        return this.dui;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dui = jSONObject.optInt("is_lpost", 0);
                this.duj = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.dui = topic.is_lpost.intValue();
            this.duj = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
