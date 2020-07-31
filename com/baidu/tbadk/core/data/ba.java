package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ba {
    private ArrayList<UserData> dQg = new ArrayList<>();
    private ArrayList<UserData> dQh = new ArrayList<>();
    private au dQi = new au();
    private int dQj = 0;
    private int dQk = 0;

    public void setPage(au auVar) {
        this.dQi = auVar;
    }

    public au getPage() {
        return this.dQi;
    }

    public ArrayList<UserData> aVe() {
        return this.dQg;
    }

    public ArrayList<UserData> aVf() {
        return this.dQh;
    }

    public int aVg() {
        return this.dQj;
    }

    public int aVh() {
        return this.dQk;
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
                        this.dQg.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.dQh.add(userData2);
                    }
                }
                this.dQi.parserJson(jSONObject.optJSONObject("page"));
                this.dQj = jSONObject.optInt("tafriendnum", 0);
                this.dQk = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
