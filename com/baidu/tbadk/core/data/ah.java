package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private ArrayList<String> cLr;
    private int cLs = 0;
    private UserData cLq = new UserData();
    private AntiData anti = new AntiData();

    public ah() {
        this.cLr = null;
        this.cLr = new ArrayList<>();
        jf(0);
    }

    public UserData getUser() {
        return this.cLq;
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
            this.cLq.parserJson(jSONObject.optJSONObject("user"));
            this.anti.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.cLr.add(optJSONArray.optString(i, null));
                }
            }
            jf(jSONObject.optInt("retrytime"));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jf(int i) {
        this.cLs = i;
    }
}
