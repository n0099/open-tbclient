package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bc {
    private ArrayList<UserData> bxr = new ArrayList<>();
    private ArrayList<UserData> eAz = new ArrayList<>();
    private aw eAA = new aw();
    private int eAB = 0;
    private int eAC = 0;

    public void setPage(aw awVar) {
        this.eAA = awVar;
    }

    public aw getPage() {
        return this.eAA;
    }

    public ArrayList<UserData> bkv() {
        return this.bxr;
    }

    public ArrayList<UserData> bkw() {
        return this.eAz;
    }

    public int bkx() {
        return this.eAB;
    }

    public int bky() {
        return this.eAC;
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
                        this.bxr.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.eAz.add(userData2);
                    }
                }
                this.eAA.parserJson(jSONObject.optJSONObject("page"));
                this.eAB = jSONObject.optInt("tafriendnum", 0);
                this.eAC = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
