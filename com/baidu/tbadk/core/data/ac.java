package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class ac {
    private String class_name = null;
    private int bzc = 0;

    public String Xr() {
        return this.class_name;
    }

    public int Xs() {
        return this.bzc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bzc = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.bzc = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
