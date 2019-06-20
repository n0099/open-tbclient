package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bHg = new ArrayList<>();
    private ArrayList<UserData> bHh = new ArrayList<>();
    private an bHi = new an();
    private int bHj = 0;
    private int bHk = 0;

    public void setPage(an anVar) {
        this.bHi = anVar;
    }

    public an getPage() {
        return this.bHi;
    }

    public ArrayList<UserData> acs() {
        return this.bHg;
    }

    public ArrayList<UserData> act() {
        return this.bHh;
    }

    public int acu() {
        return this.bHj;
    }

    public int acv() {
        return this.bHk;
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
                        this.bHg.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bHh.add(userData2);
                    }
                }
                this.bHi.parserJson(jSONObject.optJSONObject("page"));
                this.bHj = jSONObject.optInt("tafriendnum", 0);
                this.bHk = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
