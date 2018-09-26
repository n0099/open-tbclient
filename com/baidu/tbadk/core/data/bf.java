package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bf {
    private int amL = 0;
    private int amM = 0;
    private String link = "";

    public int xZ() {
        return this.amL;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.amL = jSONObject.optInt("is_lpost", 0);
                this.amM = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.amL = topic.is_lpost.intValue();
            this.amM = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
