package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class l {
    private String class_name = null;
    private int PJ = 0;

    public void bR(String str) {
        this.class_name = str;
    }

    public String qb() {
        return this.class_name;
    }

    public void bm(int i) {
        this.PJ = i;
    }

    public int qc() {
        return this.PJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.PJ = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.PJ = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
