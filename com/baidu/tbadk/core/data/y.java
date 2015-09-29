package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class y {
    private int We = 0;
    private int Wf = 0;
    private String link = "";

    public int sL() {
        return this.We;
    }

    public int sM() {
        return this.Wf;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.We = jSONObject.optInt("is_lpost", 0);
                this.Wf = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.We = topic.is_lpost.intValue();
            this.Wf = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
