package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bzT = new ArrayList<>();
    private ArrayList<UserData> bzU = new ArrayList<>();
    private an bzV = new an();
    private int bzW = 0;
    private int bzX = 0;

    public void setPage(an anVar) {
        this.bzV = anVar;
    }

    public an getPage() {
        return this.bzV;
    }

    public ArrayList<UserData> XK() {
        return this.bzT;
    }

    public ArrayList<UserData> XL() {
        return this.bzU;
    }

    public int XM() {
        return this.bzW;
    }

    public int XN() {
        return this.bzX;
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
                        this.bzT.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bzU.add(userData2);
                    }
                }
                this.bzV.parserJson(jSONObject.optJSONObject("page"));
                this.bzW = jSONObject.optInt("tafriendnum", 0);
                this.bzX = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
