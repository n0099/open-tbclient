package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {
    private ArrayList<UserData> Yq = new ArrayList<>();
    private ArrayList<UserData> Yr = new ArrayList<>();
    private ar Ys = new ar();
    private int Yt = 0;
    private int Yu = 0;

    public void a(ar arVar) {
        this.Ys = arVar;
    }

    public ar qI() {
        return this.Ys;
    }

    public ArrayList<UserData> qJ() {
        return this.Yq;
    }

    public ArrayList<UserData> qK() {
        return this.Yr;
    }

    public int qL() {
        return this.Yt;
    }

    public int qM() {
        return this.Yu;
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
                        this.Yq.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Yr.add(userData2);
                    }
                }
                this.Ys.parserJson(jSONObject.optJSONObject("page"));
                this.Yt = jSONObject.optInt("tafriendnum", 0);
                this.Yu = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
