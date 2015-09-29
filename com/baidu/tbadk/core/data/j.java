package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class j {
    private String class_name = null;
    private int UO = 0;

    public void ci(String str) {
        this.class_name = str;
    }

    public String rD() {
        return this.class_name;
    }

    public void bt(int i) {
        this.UO = i;
    }

    public int rE() {
        return this.UO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.UO = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.UO = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
