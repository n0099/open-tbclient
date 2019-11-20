package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<UserData> bZv = new ArrayList<>();
    private ArrayList<UserData> bZw = new ArrayList<>();
    private an bZx = new an();
    private int bZy = 0;
    private int bZz = 0;

    public void setPage(an anVar) {
        this.bZx = anVar;
    }

    public an getPage() {
        return this.bZx;
    }

    public ArrayList<UserData> ahB() {
        return this.bZv;
    }

    public ArrayList<UserData> ahC() {
        return this.bZw;
    }

    public int ahD() {
        return this.bZy;
    }

    public int ahE() {
        return this.bZz;
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
                        this.bZv.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.bZw.add(userData2);
                    }
                }
                this.bZx.parserJson(jSONObject.optJSONObject("page"));
                this.bZy = jSONObject.optInt("tafriendnum", 0);
                this.bZz = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
