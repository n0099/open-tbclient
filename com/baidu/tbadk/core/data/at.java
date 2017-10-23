package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {
    private ArrayList<UserData> Xn = new ArrayList<>();
    private ArrayList<UserData> Xo = new ArrayList<>();
    private ap Xp = new ap();
    private int Xq = 0;
    private int Xr = 0;

    public void a(ap apVar) {
        this.Xp = apVar;
    }

    public ap qq() {
        return this.Xp;
    }

    public ArrayList<UserData> qr() {
        return this.Xn;
    }

    public ArrayList<UserData> qs() {
        return this.Xo;
    }

    public int qt() {
        return this.Xq;
    }

    public int qu() {
        return this.Xr;
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
                JSONArray optJSONArray = jSONObject.optJSONArray(StoryPageActivityConfig.USER_LIST);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        userData.mAttentionType = 2;
                        this.Xn.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Xo.add(userData2);
                    }
                }
                this.Xp.parserJson(jSONObject.optJSONObject("page"));
                this.Xq = jSONObject.optInt("tafriendnum", 0);
                this.Xr = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
