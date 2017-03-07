package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bo {
    private int ZE = 0;
    private int ZF = 0;
    private String link = "";

    public int tf() {
        return this.ZE;
    }

    public int tg() {
        return this.ZF;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ZE = jSONObject.optInt("is_lpost", 0);
                this.ZF = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.ZE = topic.is_lpost.intValue();
            this.ZF = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
