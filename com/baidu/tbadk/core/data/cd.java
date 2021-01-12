package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class cd {
    private int eSe = 0;
    private int eSf = 0;
    private String link = "";

    public int bpR() {
        return this.eSe;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eSe = jSONObject.optInt("is_lpost", 0);
                this.eSf = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.eSe = topic.is_lpost.intValue();
            this.eSf = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
