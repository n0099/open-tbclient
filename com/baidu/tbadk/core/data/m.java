package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class m {
    private String class_name = null;
    private int Vv = 0;

    public void cp(String str) {
        this.class_name = str;
    }

    public String rX() {
        return this.class_name;
    }

    public void bA(int i) {
        this.Vv = i;
    }

    public int rY() {
        return this.Vv;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vv = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.Vv = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
