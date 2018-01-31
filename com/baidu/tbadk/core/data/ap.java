package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> aMr = new ArrayList<>();
    private ArrayList<UserData> aMs = new ArrayList<>();
    private al aMt = new al();
    private int aMu = 0;
    private int aMv = 0;

    public void a(al alVar) {
        this.aMt = alVar;
    }

    public al xZ() {
        return this.aMt;
    }

    public ArrayList<UserData> ya() {
        return this.aMr;
    }

    public ArrayList<UserData> yb() {
        return this.aMs;
    }

    public int yc() {
        return this.aMu;
    }

    public int yd() {
        return this.aMv;
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
                        this.aMr.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.aMs.add(userData2);
                    }
                }
                this.aMt.parserJson(jSONObject.optJSONObject("page"));
                this.aMu = jSONObject.optInt("tafriendnum", 0);
                this.aMv = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
