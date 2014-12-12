package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class j {
    private String class_name = null;
    private int DS = 0;

    public void bP(String str) {
        this.class_name = str;
    }

    public String mL() {
        return this.class_name;
    }

    public void bi(int i) {
        this.DS = i;
    }

    public int mM() {
        return this.DS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.DS = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.DS = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
