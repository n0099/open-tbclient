package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> RF;
    private int smsCodeTime = 0;
    private UserData RD = new UserData();
    private AntiData RE = new AntiData();

    public ae() {
        this.RF = null;
        this.RF = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.RD;
    }

    public AntiData qf() {
        return this.RE;
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
            this.RD.parserJson(jSONObject.optJSONObject("user"));
            this.RE.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.RF.add(optJSONArray.optString(i, null));
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
