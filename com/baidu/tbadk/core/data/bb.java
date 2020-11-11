package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private ArrayList<UserData> bzc = new ArrayList<>();
    private ArrayList<UserData> eCi = new ArrayList<>();
    private av eCj = new av();
    private int eCk = 0;
    private int eCl = 0;

    public void setPage(av avVar) {
        this.eCj = avVar;
    }

    public av getPage() {
        return this.eCj;
    }

    public ArrayList<UserData> blt() {
        return this.bzc;
    }

    public ArrayList<UserData> blu() {
        return this.eCi;
    }

    public int blv() {
        return this.eCk;
    }

    public int blw() {
        return this.eCl;
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
                        this.bzc.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.eCi.add(userData2);
                    }
                }
                this.eCj.parserJson(jSONObject.optJSONObject("page"));
                this.eCk = jSONObject.optInt("tafriendnum", 0);
                this.eCl = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
