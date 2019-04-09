package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private ArrayList<String> bzs;
    private int bzt = 0;
    private UserData bzr = new UserData();
    private AntiData anti = new AntiData();

    public ag() {
        this.bzs = null;
        this.bzs = new ArrayList<>();
        ge(0);
    }

    public UserData getUser() {
        return this.bzr;
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
            this.bzr.parserJson(jSONObject.optJSONObject("user"));
            this.anti.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.bzs.add(optJSONArray.optString(i, null));
                }
            }
            ge(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ge(int i) {
        this.bzt = i;
    }
}
