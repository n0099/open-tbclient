package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> aok = new ArrayList<>();
    private ArrayList<UserData> aol = new ArrayList<>();
    private al aom = new al();
    private int aon = 0;
    private int aoo = 0;

    public void a(al alVar) {
        this.aom = alVar;
    }

    public al xH() {
        return this.aom;
    }

    public ArrayList<UserData> xI() {
        return this.aok;
    }

    public ArrayList<UserData> xJ() {
        return this.aol;
    }

    public int xK() {
        return this.aon;
    }

    public int xL() {
        return this.aoo;
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
                        this.aok.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.aol.add(userData2);
                    }
                }
                this.aom.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
                this.aon = jSONObject.optInt("tafriendnum", 0);
                this.aoo = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
