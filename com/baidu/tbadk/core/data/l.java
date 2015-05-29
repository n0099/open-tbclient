package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class l {
    private String class_name = null;
    private int Qh = 0;

    public void ce(String str) {
        this.class_name = str;
    }

    public String qH() {
        return this.class_name;
    }

    public void bj(int i) {
        this.Qh = i;
    }

    public int qI() {
        return this.Qh;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Qh = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.Qh = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
