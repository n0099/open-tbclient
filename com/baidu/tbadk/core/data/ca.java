package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes2.dex */
public class ca {
    private int eeJ = 0;
    private int eeK = 0;
    private String link = "";

    public int bgT() {
        return this.eeJ;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eeJ = jSONObject.optInt("is_lpost", 0);
                this.eeK = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.eeJ = topic.is_lpost.intValue();
            this.eeK = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
