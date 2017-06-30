package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private ArrayList<String> Wb;
    private int smsCodeTime = 0;
    private UserData VZ = new UserData();
    private AntiData Wa = new AntiData();

    public al() {
        this.Wb = null;
        this.Wb = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.VZ;
    }

    public AntiData qe() {
        return this.Wa;
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
            this.VZ.parserJson(jSONObject.optJSONObject("user"));
            this.Wa.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Wb.add(optJSONArray.optString(i, null));
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
