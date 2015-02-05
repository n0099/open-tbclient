package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class k {
    private String class_name = null;
    private int DU = 0;

    public void bK(String str) {
        this.class_name = str;
    }

    public String mG() {
        return this.class_name;
    }

    public void bn(int i) {
        this.DU = i;
    }

    public int mH() {
        return this.DU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.DU = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.DU = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
