package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private ArrayList<String> Rm;
    private int smsCodeTime = 0;
    private UserData Rk = new UserData();
    private AntiData Rl = new AntiData();

    public ai() {
        this.Rm = null;
        this.Rm = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.Rk;
    }

    public AntiData qm() {
        return this.Rl;
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
            this.Rk.parserJson(jSONObject.optJSONObject("user"));
            this.Rl.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Rm.add(optJSONArray.optString(i, null));
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
