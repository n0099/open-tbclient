package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class ae {
    private String class_name = null;
    private int Wd = 0;

    public String qn() {
        return this.class_name;
    }

    public int qo() {
        return this.Wd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Wd = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.Wd = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
