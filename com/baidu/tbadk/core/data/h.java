package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class h {
    private String class_name = null;
    private int zM = 0;

    public void aY(String str) {
        this.class_name = str;
    }

    public String jW() {
        return this.class_name;
    }

    public void aM(int i) {
        this.zM = i;
    }

    public int jX() {
        return this.zM;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.zM = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.zM = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
