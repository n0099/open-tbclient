package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> DZ;
    private int smsCodeTime = 0;
    private UserData DX = new UserData();
    private AntiData DY = new AntiData();

    public n() {
        this.DZ = null;
        this.DZ = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.DX;
    }

    public AntiData mK() {
        return this.DY;
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
            this.DX.parserJson(jSONObject.optJSONObject("user"));
            this.DY.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.DZ.add(optJSONArray.optString(i, null));
                }
            }
            setSmsCodeTime(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public ArrayList<String> mL() {
        return this.DZ;
    }

    public void setSmsCodeTime(int i) {
        this.smsCodeTime = i;
    }

    public int getSmsCodeTime() {
        return this.smsCodeTime;
    }
}
