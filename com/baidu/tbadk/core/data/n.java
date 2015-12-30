package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> VY;
    private int smsCodeTime = 0;
    private UserData VW = new UserData();
    private AntiData VX = new AntiData();

    public n() {
        this.VY = null;
        this.VY = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.VW;
    }

    public AntiData rI() {
        return this.VX;
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
            this.VW.parserJson(jSONObject.optJSONObject("user"));
            this.VX.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.VY.add(optJSONArray.optString(i, null));
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
