package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private ArrayList<String> DY;
    private int smsCodeTime = 0;
    private UserData DW = new UserData();
    private AntiData DX = new AntiData();

    public m() {
        this.DY = null;
        this.DY = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.DW;
    }

    public AntiData mP() {
        return this.DX;
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
            this.DW.parserJson(jSONObject.optJSONObject("user"));
            this.DX.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.DY.add(optJSONArray.optString(i, null));
                }
            }
            setSmsCodeTime(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public ArrayList<String> mQ() {
        return this.DY;
    }

    public void setSmsCodeTime(int i) {
        this.smsCodeTime = i;
    }

    public int getSmsCodeTime() {
        return this.smsCodeTime;
    }
}
