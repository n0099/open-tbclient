package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class ac {
    private int Xx = 0;
    private int Xy = 0;
    private String link = "";

    public int sZ() {
        return this.Xx;
    }

    public int ta() {
        return this.Xy;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Xx = jSONObject.optInt("is_lpost", 0);
                this.Xy = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Xx = topic.is_lpost.intValue();
            this.Xy = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
