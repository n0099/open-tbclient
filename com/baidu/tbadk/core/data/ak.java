package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private ArrayList<String> XQ;
    private int smsCodeTime = 0;
    private UserData XO = new UserData();
    private AntiData XP = new AntiData();

    public ak() {
        this.XQ = null;
        this.XQ = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.XO;
    }

    public AntiData qs() {
        return this.XP;
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
            this.XO.parserJson(jSONObject.optJSONObject("user"));
            this.XP.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.XQ.add(optJSONArray.optString(i, null));
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
