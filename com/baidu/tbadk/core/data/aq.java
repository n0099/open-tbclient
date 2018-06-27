package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private ArrayList<UserData> ahv = new ArrayList<>();
    private ArrayList<UserData> ahw = new ArrayList<>();
    private am ahx = new am();
    private int ahy = 0;
    private int ahz = 0;

    public void a(am amVar) {
        this.ahx = amVar;
    }

    public am uJ() {
        return this.ahx;
    }

    public ArrayList<UserData> uK() {
        return this.ahv;
    }

    public ArrayList<UserData> uL() {
        return this.ahw;
    }

    public int uM() {
        return this.ahy;
    }

    public int uN() {
        return this.ahz;
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
                        this.ahv.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.ahw.add(userData2);
                    }
                }
                this.ahx.parserJson(jSONObject.optJSONObject("page"));
                this.ahy = jSONObject.optInt("tafriendnum", 0);
                this.ahz = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
