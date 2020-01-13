package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> cLX = new ArrayList<>();
    private ArrayList<UserData> cLY = new ArrayList<>();
    private ap cLZ = new ap();
    private int cMa = 0;
    private int cMb = 0;

    public void setPage(ap apVar) {
        this.cLZ = apVar;
    }

    public ap getPage() {
        return this.cLZ;
    }

    public ArrayList<UserData> ayU() {
        return this.cLX;
    }

    public ArrayList<UserData> ayV() {
        return this.cLY;
    }

    public int ayW() {
        return this.cMa;
    }

    public int ayX() {
        return this.cMb;
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
                        this.cLX.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.cLY.add(userData2);
                    }
                }
                this.cLZ.parserJson(jSONObject.optJSONObject("page"));
                this.cMa = jSONObject.optInt("tafriendnum", 0);
                this.cMb = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
