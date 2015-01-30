package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes.dex */
public class k {
    private String class_name = null;
    private int DX = 0;

    public void bN(String str) {
        this.class_name = str;
    }

    public String mN() {
        return this.class_name;
    }

    public void bn(int i) {
        this.DX = i;
    }

    public int mO() {
        return this.DX;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.DX = jSONObject.optInt("class_id", 0);
                this.class_name = jSONObject.optString("class_name");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(Classify classify) {
        if (classify != null) {
            this.DX = classify.class_id.intValue();
            this.class_name = classify.class_name;
        }
    }
}
