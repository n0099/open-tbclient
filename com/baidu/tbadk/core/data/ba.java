package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ba {
    private ArrayList<UserData> dJU = new ArrayList<>();
    private ArrayList<UserData> dJV = new ArrayList<>();
    private at dJW = new at();
    private int dJX = 0;
    private int dJY = 0;
    public int dJZ;
    public String dKa;
    public boolean hasMore;
    public int pageNum;
    public int type;

    public ArrayList<UserData> aRi() {
        return this.dJU;
    }

    public ArrayList<UserData> aRj() {
        return this.dJV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optJSONObject("page") != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            UserData userData = new UserData();
                            userData.parserJson(optJSONArray.getJSONObject(i));
                            this.dJU.add(userData);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            UserData userData2 = new UserData();
                            userData2.parserJson(optJSONArray2.getJSONObject(i2));
                            userData2.mAttentionType = 1;
                            this.dJV.add(userData2);
                        }
                    }
                    this.dJW.parserJson(jSONObject.optJSONObject("page"));
                    if (this.dJW != null) {
                        this.pageNum = this.dJW.aRd();
                        this.dJZ = this.dJW.aRb();
                        this.hasMore = this.dJW.aRf() == 1;
                    }
                    this.dJX = jSONObject.optInt("tafriendnum", 0);
                    this.dJY = jSONObject.optInt("commonfriendnum", 0);
                } else {
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            UserData userData3 = new UserData();
                            userData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.dJU.add(userData3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            UserData userData4 = new UserData();
                            userData4.parserJson(optJSONArray4.getJSONObject(i4));
                            userData4.mAttentionType = 1;
                            userData4.setHave_attention(1);
                            this.dJV.add(userData4);
                        }
                    }
                    this.pageNum = jSONObject.optInt(Config.PACKAGE_NAME);
                    this.dJZ = jSONObject.optInt(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
                    this.hasMore = jSONObject.optInt("has_more", 0) == 1;
                }
                this.type = jSONObject.optInt("type", 0);
                this.dKa = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
