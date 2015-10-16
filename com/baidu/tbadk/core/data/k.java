package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class k {
    private String class_name = null;
    private int UR = 0;

    public void cj(String str) {
        this.class_name = str;
    }

    public String rD() {
        return this.class_name;
    }

    public void bt(int i) {
        this.UR = i;
    }

    public int rE() {
        return this.UR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.UR = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.UR = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
