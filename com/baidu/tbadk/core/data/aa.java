package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class aa {
    private int Fd = 0;
    private int Fe = 0;
    private String link = "";

    public int nL() {
        return this.Fd;
    }

    public int nM() {
        return this.Fe;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Fd = jSONObject.optInt("is_lpost", 0);
                this.Fe = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Fd = topic.is_lpost.intValue();
            this.Fe = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
