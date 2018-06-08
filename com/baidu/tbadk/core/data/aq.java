package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private ArrayList<UserData> ahd = new ArrayList<>();
    private ArrayList<UserData> ahe = new ArrayList<>();
    private am ahf = new am();
    private int ahg = 0;
    private int ahh = 0;

    public void a(am amVar) {
        this.ahf = amVar;
    }

    public am uB() {
        return this.ahf;
    }

    public ArrayList<UserData> uC() {
        return this.ahd;
    }

    public ArrayList<UserData> uD() {
        return this.ahe;
    }

    public int uE() {
        return this.ahg;
    }

    public int uF() {
        return this.ahh;
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
                        this.ahd.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.ahe.add(userData2);
                    }
                }
                this.ahf.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
                this.ahg = jSONObject.optInt("tafriendnum", 0);
                this.ahh = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
