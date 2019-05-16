package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bHf = new ArrayList<>();
    private ArrayList<UserData> bHg = new ArrayList<>();
    private an bHh = new an();
    private int bHi = 0;
    private int bHj = 0;

    public void setPage(an anVar) {
        this.bHh = anVar;
    }

    public an getPage() {
        return this.bHh;
    }

    public ArrayList<UserData> acs() {
        return this.bHf;
    }

    public ArrayList<UserData> act() {
        return this.bHg;
    }

    public int acu() {
        return this.bHi;
    }

    public int acv() {
        return this.bHj;
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
                        this.bHf.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bHg.add(userData2);
                    }
                }
                this.bHh.parserJson(jSONObject.optJSONObject("page"));
                this.bHi = jSONObject.optInt("tafriendnum", 0);
                this.bHj = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
