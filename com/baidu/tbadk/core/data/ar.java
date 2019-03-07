package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bzN = new ArrayList<>();
    private ArrayList<UserData> bzO = new ArrayList<>();
    private an bzP = new an();
    private int bzQ = 0;
    private int bzR = 0;

    public void setPage(an anVar) {
        this.bzP = anVar;
    }

    public an getPage() {
        return this.bzP;
    }

    public ArrayList<UserData> XN() {
        return this.bzN;
    }

    public ArrayList<UserData> XO() {
        return this.bzO;
    }

    public int XP() {
        return this.bzQ;
    }

    public int XQ() {
        return this.bzR;
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
                        this.bzN.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bzO.add(userData2);
                    }
                }
                this.bzP.parserJson(jSONObject.optJSONObject("page"));
                this.bzQ = jSONObject.optInt("tafriendnum", 0);
                this.bzR = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
