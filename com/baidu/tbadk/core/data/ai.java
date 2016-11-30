package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private ArrayList<String> Si;
    private int smsCodeTime = 0;
    private UserData Sg = new UserData();
    private AntiData Sh = new AntiData();

    public ai() {
        this.Si = null;
        this.Si = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.Sg;
    }

    public AntiData qs() {
        return this.Sh;
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
            this.Sg.parserJson(jSONObject.optJSONObject("user"));
            this.Sh.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Si.add(optJSONArray.optString(i, null));
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
