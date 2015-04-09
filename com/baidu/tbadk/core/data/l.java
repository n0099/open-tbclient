package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class l {
    private String class_name = null;
    private int PL = 0;

    public void bR(String str) {
        this.class_name = str;
    }

    public String qb() {
        return this.class_name;
    }

    public void bm(int i) {
        this.PL = i;
    }

    public int qc() {
        return this.PL;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PL = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.PL = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
