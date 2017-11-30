package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> Xy;
    private int Xz = 0;
    private UserData Xw = new UserData();
    private AntiData Xx = new AntiData();

    public ae() {
        this.Xy = null;
        this.Xy = new ArrayList<>();
        bE(0);
    }

    public UserData getUser() {
        return this.Xw;
    }

    public AntiData qi() {
        return this.Xx;
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
            this.Xw.parserJson(jSONObject.optJSONObject("user"));
            this.Xx.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Xy.add(optJSONArray.optString(i, null));
                }
            }
            bE(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bE(int i) {
        this.Xz = i;
    }
}
