package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ao {
    private ArrayList<UserData> Sf = new ArrayList<>();
    private ArrayList<UserData> Sg = new ArrayList<>();
    private ak mPage = new ak();
    private int Sh = 0;
    private int Si = 0;

    public void a(ak akVar) {
        this.mPage = akVar;
    }

    public ak getPage() {
        return this.mPage;
    }

    public ArrayList<UserData> qu() {
        return this.Sf;
    }

    public ArrayList<UserData> qv() {
        return this.Sg;
    }

    public int qw() {
        return this.Sh;
    }

    public int qx() {
        return this.Si;
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
                        this.Sf.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Sg.add(userData2);
                    }
                }
                this.mPage.parserJson(jSONObject.optJSONObject("page"));
                this.Sh = jSONObject.optInt("tafriendnum", 0);
                this.Si = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
