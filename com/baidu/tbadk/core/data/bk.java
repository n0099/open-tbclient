package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bk {
    private int aab = 0;
    private int aac = 0;
    private String link = "";

    public int sO() {
        return this.aab;
    }

    public int sP() {
        return this.aac;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aab = jSONObject.optInt("is_lpost", 0);
                this.aac = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aab = topic.is_lpost.intValue();
            this.aac = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
