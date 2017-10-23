package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private ArrayList<String> WO;
    private int smsCodeTime = 0;
    private UserData WM = new UserData();
    private AntiData WN = new AntiData();

    public ai() {
        this.WO = null;
        this.WO = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.WM;
    }

    public AntiData qa() {
        return this.WN;
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
            this.WM.parserJson(jSONObject.optJSONObject("user"));
            this.WN.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.WO.add(optJSONArray.optString(i, null));
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
