package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bi {
    private int aPm = 0;
    private int aPn = 0;
    private String link = "";

    public int Aw() {
        return this.aPm;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPm = jSONObject.optInt("is_lpost", 0);
                this.aPn = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aPm = topic.is_lpost.intValue();
            this.aPn = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
