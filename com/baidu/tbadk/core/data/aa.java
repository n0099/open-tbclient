package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class aa {
    private String class_name = null;
    private int aLG = 0;

    public String xy() {
        return this.class_name;
    }

    public int xz() {
        return this.aLG;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLG = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.aLG = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
