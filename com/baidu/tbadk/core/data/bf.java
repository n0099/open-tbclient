package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bf {
    private int akf = 0;
    private int akg = 0;
    private String link = "";

    public int wS() {
        return this.akf;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akf = jSONObject.optInt("is_lpost", 0);
                this.akg = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.akf = topic.is_lpost.intValue();
            this.akg = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
