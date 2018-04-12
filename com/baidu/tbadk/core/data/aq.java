package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private ArrayList<UserData> Zb = new ArrayList<>();
    private ArrayList<UserData> Zc = new ArrayList<>();
    private am Zd = new am();
    private int Ze = 0;
    private int Zf = 0;

    public void a(am amVar) {
        this.Zd = amVar;
    }

    public am rg() {
        return this.Zd;
    }

    public ArrayList<UserData> rh() {
        return this.Zb;
    }

    public ArrayList<UserData> ri() {
        return this.Zc;
    }

    public int rj() {
        return this.Ze;
    }

    public int rk() {
        return this.Zf;
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
                        this.Zb.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Zc.add(userData2);
                    }
                }
                this.Zd.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
                this.Ze = jSONObject.optInt("tafriendnum", 0);
                this.Zf = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
