package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {
    public int ahA;
    public String ahB;
    private ArrayList<UserData> ahv = new ArrayList<>();
    private ArrayList<UserData> ahw = new ArrayList<>();
    private am ahx = new am();
    private int ahy = 0;
    private int ahz = 0;
    public boolean hasMore;
    public int pageNum;
    public int type;

    public ArrayList<UserData> uK() {
        return this.ahv;
    }

    public ArrayList<UserData> uL() {
        return this.ahw;
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
                            this.ahv.add(userData);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            UserData userData2 = new UserData();
                            userData2.parserJson(optJSONArray2.getJSONObject(i2));
                            userData2.mAttentionType = 1;
                            this.ahw.add(userData2);
                        }
                    }
                    this.ahx.parserJson(jSONObject.optJSONObject("page"));
                    if (this.ahx != null) {
                        this.pageNum = this.ahx.uD();
                        this.ahA = this.ahx.uB();
                        this.hasMore = this.ahx.uF() == 1;
                    }
                    this.ahy = jSONObject.optInt("tafriendnum", 0);
                    this.ahz = jSONObject.optInt("commonfriendnum", 0);
                } else {
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                    if (optJSONArray3 != null) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            UserData userData3 = new UserData();
                            userData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.ahv.add(userData3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            UserData userData4 = new UserData();
                            userData4.parserJson(optJSONArray4.getJSONObject(i4));
                            userData4.mAttentionType = 1;
                            userData4.setHave_attention(1);
                            this.ahw.add(userData4);
                        }
                    }
                    this.pageNum = jSONObject.optInt("pn");
                    this.ahA = jSONObject.optInt("total_follow_num", 0);
                    this.hasMore = jSONObject.optInt("has_more", 0) == 1;
                }
                this.type = jSONObject.optInt("type", 0);
                this.ahB = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
