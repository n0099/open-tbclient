package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes.dex */
public class bf {
    private int avU = 0;
    private int avV = 0;
    private String link = "";

    public int Bt() {
        return this.avU;
    }

    public String getLink() {
        return this.link;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.avU = jSONObject.optInt("is_lpost", 0);
                this.avV = jSONObject.optInt("topic_type", 0);
                this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK, "");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Topic topic) {
        if (topic != null) {
            this.avU = topic.is_lpost.intValue();
            this.avV = topic.topic_type.intValue();
            this.link = topic.link;
        }
    }
}
