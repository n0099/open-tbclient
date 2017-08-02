package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private ArrayList<String> Wr;
    private int smsCodeTime = 0;
    private UserData Wp = new UserData();
    private AntiData Wq = new AntiData();

    public ak() {
        this.Wr = null;
        this.Wr = new ArrayList<>();
        setSmsCodeTime(0);
    }

    public UserData getUser() {
        return this.Wp;
    }

    public AntiData qh() {
        return this.Wq;
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
            this.Wp.parserJson(jSONObject.optJSONObject("user"));
            this.Wq.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Wr.add(optJSONArray.optString(i, null));
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
