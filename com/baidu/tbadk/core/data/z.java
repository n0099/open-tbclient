package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class z {
    private int Fb = 0;
    private int Fc = 0;
    private String link = "";

    public int nP() {
        return this.Fb;
    }

    public int nQ() {
        return this.Fc;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Fb = jSONObject.optInt("is_lpost", 0);
                this.Fc = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Fb = topic.is_lpost.intValue();
            this.Fc = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
