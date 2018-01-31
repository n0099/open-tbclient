package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bh {
    private int aPo = 0;
    private int aPp = 0;
    private String link = "";

    public int Ap() {
        return this.aPo;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPo = jSONObject.optInt("is_lpost", 0);
                this.aPp = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.aPo = topic.is_lpost.intValue();
            this.aPp = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
