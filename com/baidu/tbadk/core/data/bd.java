package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bd {
    private ArrayList<UserData> bCA = new ArrayList<>();
    private ArrayList<UserData> eME = new ArrayList<>();
    private ax eMF = new ax();
    private int eMG = 0;
    private int eMH = 0;

    public void setPage(ax axVar) {
        this.eMF = axVar;
    }

    public ax getPage() {
        return this.eMF;
    }

    public ArrayList<UserData> bmp() {
        return this.bCA;
    }

    public ArrayList<UserData> bmq() {
        return this.eME;
    }

    public int bmr() {
        return this.eMG;
    }

    public int bms() {
        return this.eMH;
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
                        this.bCA.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.eME.add(userData2);
                    }
                }
                this.eMF.parserJson(jSONObject.optJSONObject("page"));
                this.eMG = jSONObject.optInt("tafriendnum", 0);
                this.eMH = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
