package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bf {
    private ArrayList<UserData> bHK = new ArrayList<>();
    private ArrayList<UserData> eQr = new ArrayList<>();
    private az eQs = new az();
    private int eQt = 0;
    private int eQu = 0;

    public void setPage(az azVar) {
        this.eQs = azVar;
    }

    public az getPage() {
        return this.eQs;
    }

    public ArrayList<UserData> bmK() {
        return this.bHK;
    }

    public ArrayList<UserData> bmL() {
        return this.eQr;
    }

    public int bmM() {
        return this.eQt;
    }

    public int bmN() {
        return this.eQu;
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
                        this.bHK.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.eQr.add(userData2);
                    }
                }
                this.eQs.parserJson(jSONObject.optJSONObject("page"));
                this.eQt = jSONObject.optInt("tafriendnum", 0);
                this.eQu = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
