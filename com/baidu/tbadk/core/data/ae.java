package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private ArrayList<String> aNl;
    private int aNm = 0;
    private UserData aNj = new UserData();
    private AntiData aNk = new AntiData();

    public ae() {
        this.aNl = null;
        this.aNl = new ArrayList<>();
        eD(0);
    }

    public UserData getUser() {
        return this.aNj;
    }

    public AntiData yn() {
        return this.aNk;
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
            this.aNj.parserJson(jSONObject.optJSONObject("user"));
            this.aNk.parserJson(jSONObject.optJSONObject("anti"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.aNl.add(optJSONArray.optString(i, null));
                }
            }
            eD(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void eD(int i) {
        this.aNm = i;
    }
}
