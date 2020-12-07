package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<String> eGQ;
    private int eGR = 0;
    private UserData eGP = new UserData();
    private AntiData anti = new AntiData();

    public ap() {
        this.eGQ = null;
        this.eGQ = new ArrayList<>();
        op(0);
    }

    public UserData getUser() {
        return this.eGP;
    }

    public AntiData getAnti() {
        return this.anti;
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
            this.eGP.parserJson(jSONObject.optJSONObject("user"));
            this.anti.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.eGQ.add(optJSONArray.optString(i, null));
                }
            }
            op(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void op(int i) {
        this.eGR = i;
    }
}
