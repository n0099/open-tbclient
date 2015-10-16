package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private ArrayList<String> UU;
    private int smsCodeTime = 0;
    private UserData US = new UserData();
    private AntiData UT = new AntiData();

    public l() {
        this.UU = null;
        this.UU = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.US;
    }

    public AntiData rF() {
        return this.UT;
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
            this.US.parserJson(jSONObject.optJSONObject("user"));
            this.UT.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.UU.add(optJSONArray.optString(i, null));
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
