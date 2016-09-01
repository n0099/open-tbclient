package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bm {
    private int Vc = 0;
    private int Vd = 0;
    private String link = "";

    public int sK() {
        return this.Vc;
    }

    public int sL() {
        return this.Vd;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vc = jSONObject.optInt("is_lpost", 0);
                this.Vd = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Vc = topic.is_lpost.intValue();
            this.Vd = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
