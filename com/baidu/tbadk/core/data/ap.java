package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> aNz = new ArrayList<>();
    private ArrayList<UserData> aNA = new ArrayList<>();
    private al aNB = new al();
    private int aNC = 0;
    private int aND = 0;

    public void a(al alVar) {
        this.aNB = alVar;
    }

    public al yA() {
        return this.aNB;
    }

    public ArrayList<UserData> yB() {
        return this.aNz;
    }

    public ArrayList<UserData> yC() {
        return this.aNA;
    }

    public int yD() {
        return this.aNC;
    }

    public int yE() {
        return this.aND;
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
                        this.aNz.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.aNA.add(userData2);
                    }
                }
                this.aNB.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
                this.aNC = jSONObject.optInt("tafriendnum", 0);
                this.aND = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
