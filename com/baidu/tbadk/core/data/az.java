package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {
    private ArrayList<UserData> dJU = new ArrayList<>();
    private ArrayList<UserData> dJV = new ArrayList<>();
    private at dJW = new at();
    private int dJX = 0;
    private int dJY = 0;

    public void setPage(at atVar) {
        this.dJW = atVar;
    }

    public at getPage() {
        return this.dJW;
    }

    public ArrayList<UserData> aRi() {
        return this.dJU;
    }

    public ArrayList<UserData> aRj() {
        return this.dJV;
    }

    public int aRk() {
        return this.dJX;
    }

    public int aRl() {
        return this.dJY;
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
                        this.dJU.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.dJV.add(userData2);
                    }
                }
                this.dJW.parserJson(jSONObject.optJSONObject("page"));
                this.dJX = jSONObject.optInt("tafriendnum", 0);
                this.dJY = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
