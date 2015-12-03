package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> Vy;
    private int smsCodeTime = 0;
    private UserData Vw = new UserData();
    private AntiData Vx = new AntiData();

    public n() {
        this.Vy = null;
        this.Vy = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.Vw;
    }

    public AntiData rZ() {
        return this.Vx;
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
            this.Vw.parserJson(jSONObject.optJSONObject("user"));
            this.Vx.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Vy.add(optJSONArray.optString(i, null));
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
