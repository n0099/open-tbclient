package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private ArrayList<String> Xa;
    private int smsCodeTime = 0;
    private UserData WY = new UserData();
    private AntiData WZ = new AntiData();

    public ai() {
        this.Xa = null;
        this.Xa = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.WY;
    }

    public AntiData qh() {
        return this.WZ;
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
            this.WY.parserJson(jSONObject.optJSONObject("user"));
            this.WZ.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Xa.add(optJSONArray.optString(i, null));
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
