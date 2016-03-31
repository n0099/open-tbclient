package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class av {
    private int VZ = 0;
    private int Wa = 0;
    private String link = "";

    public int ud() {
        return this.VZ;
    }

    public int ue() {
        return this.Wa;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VZ = jSONObject.optInt("is_lpost", 0);
                this.Wa = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.VZ = topic.is_lpost.intValue();
            this.Wa = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
