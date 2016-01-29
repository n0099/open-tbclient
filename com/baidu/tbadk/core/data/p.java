package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class p {
    private String class_name = null;
    private int VI = 0;

    public void cr(String str) {
        this.class_name = str;
    }

    public String sk() {
        return this.class_name;
    }

    public void bJ(int i) {
        this.VI = i;
    }

    public int sl() {
        return this.VI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.VI = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.VI = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
