package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private ArrayList<String> RL;
    private int smsCodeTime = 0;
    private UserData RJ = new UserData();
    private AntiData RK = new AntiData();

    public ag() {
        this.RL = null;
        this.RL = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.RJ;
    }

    public AntiData qq() {
        return this.RK;
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
            this.RJ.parserJson(jSONObject.optJSONObject("user"));
            this.RK.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.RL.add(optJSONArray.optString(i, null));
                }
            }
            setSmsCodeTime(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setSmsCodeTime(int i) {
        this.smsCodeTime = i;
    }
}
