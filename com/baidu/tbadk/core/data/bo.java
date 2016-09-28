package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bo {
    private int Vm = 0;
    private int Vn = 0;
    private String link = "";

    public int sZ() {
        return this.Vm;
    }

    public int ta() {
        return this.Vn;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vm = jSONObject.optInt("is_lpost", 0);
                this.Vn = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.Vm = topic.is_lpost.intValue();
            this.Vn = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
