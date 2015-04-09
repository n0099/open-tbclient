package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class z {
    private int QT = 0;
    private int QU = 0;
    private String link = "";

    public int qZ() {
        return this.QT;
    }

    public int ra() {
        return this.QU;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.QT = jSONObject.optInt("is_lpost", 0);
                this.QU = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString("link", "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.QT = topic.is_lpost.intValue();
            this.QU = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
