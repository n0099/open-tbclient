package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bIh = new ArrayList<>();
    private ArrayList<UserData> bIi = new ArrayList<>();
    private an bIj = new an();
    private int bIk = 0;
    private int bIl = 0;

    public void setPage(an anVar) {
        this.bIj = anVar;
    }

    public an getPage() {
        return this.bIj;
    }

    public ArrayList<UserData> adv() {
        return this.bIh;
    }

    public ArrayList<UserData> adw() {
        return this.bIi;
    }

    public int adx() {
        return this.bIk;
    }

    public int ady() {
        return this.bIl;
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
                        this.bIh.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bIi.add(userData2);
                    }
                }
                this.bIj.parserJson(jSONObject.optJSONObject("page"));
                this.bIk = jSONObject.optInt("tafriendnum", 0);
                this.bIl = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
