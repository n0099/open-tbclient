package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class m {
    private String class_name = null;
    private int VV = 0;

    public void cs(String str) {
        this.class_name = str;
    }

    public String rG() {
        return this.class_name;
    }

    public void bt(int i) {
        this.VV = i;
    }

    public int rH() {
        return this.VV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VV = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.VV = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
