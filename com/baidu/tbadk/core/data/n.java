package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> PO;
    private int smsCodeTime = 0;
    private UserData PM = new UserData();
    private AntiData PN = new AntiData();

    public n() {
        this.PO = null;
        this.PO = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.PM;
    }

    public AntiData qe() {
        return this.PN;
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
            this.PM.parserJson(jSONObject.optJSONObject("user"));
            this.PN.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.PO.add(optJSONArray.optString(i, null));
                }
            }
            setSmsCodeTime(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public ArrayList<String> qf() {
        return this.PO;
    }

    public void setSmsCodeTime(int i) {
        this.smsCodeTime = i;
    }

    public int getSmsCodeTime() {
        return this.smsCodeTime;
    }
}
