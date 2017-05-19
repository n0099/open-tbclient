package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bp {
    private int Zq = 0;
    private int Zr = 0;
    private String link = "";

    public int sQ() {
        return this.Zq;
    }

    public int sR() {
        return this.Zr;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Zq = jSONObject.optInt("is_lpost", 0);
                this.Zr = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Zq = topic.is_lpost.intValue();
            this.Zr = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
