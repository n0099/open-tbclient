package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> aov;
    private int aow = 0;
    private UserData aot = new UserData();
    private AntiData aou = new AntiData();

    public ae() {
        this.aov = null;
        this.aov = new ArrayList<>();
        cp(0);
    }

    public UserData getUser() {
        return this.aot;
    }

    public AntiData xA() {
        return this.aou;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.aot.parserJson(jSONObject.optJSONObject("user"));
            this.aou.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aov.add(optJSONArray.optString(i, null));
                }
            }
            cp(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cp(int i) {
        this.aow = i;
    }
}
