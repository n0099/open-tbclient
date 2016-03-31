package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private ArrayList<String> TR;
    private int smsCodeTime = 0;
    private UserData TP = new UserData();
    private AntiData TQ = new AntiData();

    public x() {
        this.TR = null;
        this.TR = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.TP;
    }

    public AntiData sf() {
        return this.TQ;
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
            this.TP.parserJson(jSONObject.optJSONObject("user"));
            this.TQ.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.TR.add(optJSONArray.optString(i, null));
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
