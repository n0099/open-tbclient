package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bzS = new ArrayList<>();
    private ArrayList<UserData> bzT = new ArrayList<>();
    private an bzU = new an();
    private int bzV = 0;
    private int bzW = 0;

    public void setPage(an anVar) {
        this.bzU = anVar;
    }

    public an getPage() {
        return this.bzU;
    }

    public ArrayList<UserData> XK() {
        return this.bzS;
    }

    public ArrayList<UserData> XL() {
        return this.bzT;
    }

    public int XM() {
        return this.bzV;
    }

    public int XN() {
        return this.bzW;
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
                        this.bzS.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bzT.add(userData2);
                    }
                }
                this.bzU.parserJson(jSONObject.optJSONObject("page"));
                this.bzV = jSONObject.optInt("tafriendnum", 0);
                this.bzW = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
