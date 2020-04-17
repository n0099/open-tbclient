package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {
    private ArrayList<UserData> dpv = new ArrayList<>();
    private ArrayList<UserData> dpw = new ArrayList<>();
    private ap dpx = new ap();
    private int dpy = 0;
    private int dpz = 0;

    public void setPage(ap apVar) {
        this.dpx = apVar;
    }

    public ap getPage() {
        return this.dpx;
    }

    public ArrayList<UserData> aJD() {
        return this.dpv;
    }

    public ArrayList<UserData> aJE() {
        return this.dpw;
    }

    public int aJF() {
        return this.dpy;
    }

    public int aJG() {
        return this.dpz;
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
                        this.dpv.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.dpw.add(userData2);
                    }
                }
                this.dpx.parserJson(jSONObject.optJSONObject("page"));
                this.dpy = jSONObject.optInt("tafriendnum", 0);
                this.dpz = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
