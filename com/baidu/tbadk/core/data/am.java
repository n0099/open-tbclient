package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class am {
    private ArrayList<String> dPy;
    private int dPz = 0;
    private UserData dPx = new UserData();
    private AntiData anti = new AntiData();

    public am() {
        this.dPy = null;
        this.dPy = new ArrayList<>();
        kM(0);
    }

    public UserData getUser() {
        return this.dPx;
    }

    public AntiData getAnti() {
        return this.anti;
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
            this.dPx.parserJson(jSONObject.optJSONObject("user"));
            this.anti.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.dPy.add(optJSONArray.optString(i, null));
                }
            }
            kM(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void kM(int i) {
        this.dPz = i;
    }
}
