package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class ad {
    private String class_name = null;
    private int Ws = 0;

    public String qK() {
        return this.class_name;
    }

    public int qL() {
        return this.Ws;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ws = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.Ws = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
