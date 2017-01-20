package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bm {
    private int Ur = 0;
    private int Us = 0;
    private String link = "";

    public int sI() {
        return this.Ur;
    }

    public int sJ() {
        return this.Us;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ur = jSONObject.optInt("is_lpost", 0);
                this.Us = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Ur = topic.is_lpost.intValue();
            this.Us = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
