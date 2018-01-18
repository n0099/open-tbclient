package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> aMo = new ArrayList<>();
    private ArrayList<UserData> aMp = new ArrayList<>();
    private al aMq = new al();
    private int aMr = 0;
    private int aMs = 0;

    public void a(al alVar) {
        this.aMq = alVar;
    }

    public al xY() {
        return this.aMq;
    }

    public ArrayList<UserData> xZ() {
        return this.aMo;
    }

    public ArrayList<UserData> ya() {
        return this.aMp;
    }

    public int yb() {
        return this.aMr;
    }

    public int yc() {
        return this.aMs;
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
                        this.aMo.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.aMp.add(userData2);
                    }
                }
                this.aMq.parserJson(jSONObject.optJSONObject("page"));
                this.aMr = jSONObject.optInt("tafriendnum", 0);
                this.aMs = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
