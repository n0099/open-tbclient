package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bIg = new ArrayList<>();
    private ArrayList<UserData> bIh = new ArrayList<>();
    private an bIi = new an();
    private int bIj = 0;
    private int bIk = 0;

    public void setPage(an anVar) {
        this.bIi = anVar;
    }

    public an getPage() {
        return this.bIi;
    }

    public ArrayList<UserData> adu() {
        return this.bIg;
    }

    public ArrayList<UserData> adv() {
        return this.bIh;
    }

    public int adw() {
        return this.bIj;
    }

    public int adx() {
        return this.bIk;
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
                        this.bIg.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bIh.add(userData2);
                    }
                }
                this.bIi.parserJson(jSONObject.optJSONObject("page"));
                this.bIj = jSONObject.optInt("tafriendnum", 0);
                this.bIk = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
