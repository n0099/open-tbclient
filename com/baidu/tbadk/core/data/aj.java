package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class aj {
    private String class_name = null;
    private int eBs = 0;

    public String bkO() {
        return this.class_name;
    }

    public int bkP() {
        return this.eBs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eBs = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.eBs = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
