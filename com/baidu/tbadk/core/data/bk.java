package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bk {
    private int aay = 0;
    private int aaz = 0;
    private String link = "";

    public int sV() {
        return this.aay;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aay = jSONObject.optInt("is_lpost", 0);
                this.aaz = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aay = topic.is_lpost.intValue();
            this.aaz = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
