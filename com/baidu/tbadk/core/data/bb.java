package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private ArrayList<UserData> enR = new ArrayList<>();
    private ArrayList<UserData> enS = new ArrayList<>();
    private av enT = new av();
    private int enU = 0;
    private int enV = 0;

    public void setPage(av avVar) {
        this.enT = avVar;
    }

    public av getPage() {
        return this.enT;
    }

    public ArrayList<UserData> bha() {
        return this.enR;
    }

    public ArrayList<UserData> bhb() {
        return this.enS;
    }

    public int bhc() {
        return this.enU;
    }

    public int bhd() {
        return this.enV;
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
                        this.enR.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.enS.add(userData2);
                    }
                }
                this.enT.parserJson(jSONObject.optJSONObject("page"));
                this.enU = jSONObject.optInt("tafriendnum", 0);
                this.enV = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
