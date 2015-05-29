package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> Qm;
    private int smsCodeTime = 0;
    private UserData Qk = new UserData();
    private AntiData Ql = new AntiData();

    public n() {
        this.Qm = null;
        this.Qm = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.Qk;
    }

    public AntiData qK() {
        return this.Ql;
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
            this.Qk.parserJson(jSONObject.optJSONObject("user"));
            this.Ql.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Qm.add(optJSONArray.optString(i, null));
                }
            }
            setSmsCodeTime(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public ArrayList<String> qL() {
        return this.Qm;
    }

    public void setSmsCodeTime(int i) {
        this.smsCodeTime = i;
    }

    public int getSmsCodeTime() {
        return this.smsCodeTime;
    }
}
