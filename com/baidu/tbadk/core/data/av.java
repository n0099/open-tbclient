package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {
    private ArrayList<UserData> Yp = new ArrayList<>();
    private ArrayList<UserData> Yq = new ArrayList<>();
    private ar Yr = new ar();
    private int Ys = 0;
    private int Yt = 0;

    public void a(ar arVar) {
        this.Yr = arVar;
    }

    public ar qH() {
        return this.Yr;
    }

    public ArrayList<UserData> qI() {
        return this.Yp;
    }

    public ArrayList<UserData> qJ() {
        return this.Yq;
    }

    public int qK() {
        return this.Ys;
    }

    public int qL() {
        return this.Yt;
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
                        this.Yp.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.Yq.add(userData2);
                    }
                }
                this.Yr.parserJson(jSONObject.optJSONObject("page"));
                this.Ys = jSONObject.optInt("tafriendnum", 0);
                this.Yt = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
