package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private ArrayList<UserData> aNK = new ArrayList<>();
    private ArrayList<UserData> aNL = new ArrayList<>();
    private al aNM = new al();
    private int aNN = 0;
    private int aNO = 0;
    public int aNP;
    public boolean hasMore;
    public int pageNum;

    public ArrayList<UserData> yB() {
        return this.aNK;
    }

    public ArrayList<UserData> yC() {
        return this.aNL;
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
                if (jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE) != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            UserData userData = new UserData();
                            userData.parserJson(optJSONArray.getJSONObject(i));
                            this.aNK.add(userData);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            UserData userData2 = new UserData();
                            userData2.parserJson(optJSONArray2.getJSONObject(i2));
                            userData2.mAttentionType = 1;
                            this.aNL.add(userData2);
                        }
                    }
                    this.aNM.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
                    if (this.aNM != null) {
                        this.pageNum = this.aNM.yu();
                        this.aNP = this.aNM.ys();
                        this.hasMore = this.aNM.yw() == 1;
                    }
                    this.aNN = jSONObject.optInt("tafriendnum", 0);
                    this.aNO = jSONObject.optInt("commonfriendnum", 0);
                    return;
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        UserData userData3 = new UserData();
                        userData3.parserJson(optJSONArray3.getJSONObject(i3));
                        this.aNK.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i4));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.aNL.add(userData4);
                    }
                }
                this.pageNum = jSONObject.optInt("pn");
                this.aNP = jSONObject.optInt("total_follow_num", 0);
                this.hasMore = jSONObject.optInt("has_more", 0) == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
