package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private ArrayList<String> OU;
    private int smsCodeTime = 0;
    private UserData OS = new UserData();
    private AntiData OT = new AntiData();

    public ad() {
        this.OU = null;
        this.OU = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.OS;
    }

    public AntiData pc() {
        return this.OT;
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
            this.OS.parserJson(jSONObject.optJSONObject("user"));
            this.OT.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.OU.add(optJSONArray.optString(i, null));
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
