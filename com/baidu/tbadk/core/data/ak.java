package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class ak {
    private String class_name = null;
    private int eLN = 0;

    public String blJ() {
        return this.class_name;
    }

    public int blK() {
        return this.eLN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eLN = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.eLN = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
