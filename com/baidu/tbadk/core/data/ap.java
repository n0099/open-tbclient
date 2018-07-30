package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> agP = new ArrayList<>();
    private ArrayList<UserData> agQ = new ArrayList<>();
    private al agR = new al();
    private int agS = 0;
    private int agT = 0;

    public void a(al alVar) {
        this.agR = alVar;
    }

    public al uw() {
        return this.agR;
    }

    public ArrayList<UserData> ux() {
        return this.agP;
    }

    public ArrayList<UserData> uy() {
        return this.agQ;
    }

    public int uz() {
        return this.agS;
    }

    public int uA() {
        return this.agT;
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
                        this.agP.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.agQ.add(userData2);
                    }
                }
                this.agR.parserJson(jSONObject.optJSONObject("page"));
                this.agS = jSONObject.optInt("tafriendnum", 0);
                this.agT = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
