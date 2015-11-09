package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private ArrayList<String> UW;
    private int smsCodeTime = 0;
    private UserData UU = new UserData();
    private AntiData UV = new AntiData();

    public l() {
        this.UW = null;
        this.UW = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.UU;
    }

    public AntiData rE() {
        return this.UV;
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
            this.UU.parserJson(jSONObject.optJSONObject("user"));
            this.UV.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.UW.add(optJSONArray.optString(i, null));
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
