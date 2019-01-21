package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ArrayList<UserData> atb = new ArrayList<>();
    private ArrayList<UserData> atc = new ArrayList<>();
    private al atd = new al();
    private int ate = 0;
    private int atf = 0;

    public void a(al alVar) {
        this.atd = alVar;
    }

    public al zf() {
        return this.atd;
    }

    public ArrayList<UserData> zg() {
        return this.atb;
    }

    public ArrayList<UserData> zh() {
        return this.atc;
    }

    public int zi() {
        return this.ate;
    }

    public int zj() {
        return this.atf;
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
                        this.atb.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.atc.add(userData2);
                    }
                }
                this.atd.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
                this.ate = jSONObject.optInt("tafriendnum", 0);
                this.atf = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
