package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class k {
    private String class_name = null;
    private int UZ = 0;

    public void ce(String str) {
        this.class_name = str;
    }

    public String rJ() {
        return this.class_name;
    }

    public void bs(int i) {
        this.UZ = i;
    }

    public int rK() {
        return this.UZ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.UZ = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.UZ = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
