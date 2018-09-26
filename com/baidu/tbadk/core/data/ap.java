package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> ajp = new ArrayList<>();
    private ArrayList<UserData> ajq = new ArrayList<>();
    private al ajr = new al();
    private int ajs = 0;
    private int ajt = 0;

    public void a(al alVar) {
        this.ajr = alVar;
    }

    public al vy() {
        return this.ajr;
    }

    public ArrayList<UserData> vz() {
        return this.ajp;
    }

    public ArrayList<UserData> vA() {
        return this.ajq;
    }

    public int vB() {
        return this.ajs;
    }

    public int vC() {
        return this.ajt;
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
                        this.ajp.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.ajq.add(userData2);
                    }
                }
                this.ajr.parserJson(jSONObject.optJSONObject("page"));
                this.ajs = jSONObject.optInt("tafriendnum", 0);
                this.ajt = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
