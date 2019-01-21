package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private int asA = 0;
    private UserData asx = new UserData();
    private AntiData asy = new AntiData();
    private ArrayList<String> asz;

    public ae() {
        this.asz = null;
        this.asz = new ArrayList<>();
        cD(0);
    }

    public UserData getUser() {
        return this.asx;
    }

    public AntiData yR() {
        return this.asy;
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
            this.asx.parserJson(jSONObject.optJSONObject("user"));
            this.asy.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.asz.add(optJSONArray.optString(i, null));
                }
            }
            cD(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cD(int i) {
        this.asA = i;
    }
}
