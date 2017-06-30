package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aw {
    private ArrayList<UserData> WB = new ArrayList<>();
    private ArrayList<UserData> WC = new ArrayList<>();
    private as WD = new as();
    private int WE = 0;
    private int WF = 0;

    public void a(as asVar) {
        this.WD = asVar;
    }

    public as qu() {
        return this.WD;
    }

    public ArrayList<UserData> qv() {
        return this.WB;
    }

    public ArrayList<UserData> qw() {
        return this.WC;
    }

    public int qx() {
        return this.WE;
    }

    public int qy() {
        return this.WF;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        userData.mAttentionType = 2;
                        this.WB.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.WC.add(userData2);
                    }
                }
                this.WD.parserJson(jSONObject.optJSONObject("page"));
                this.WE = jSONObject.optInt("tafriendnum", 0);
                this.WF = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
