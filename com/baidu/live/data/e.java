package com.baidu.live.data;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public String aGh;
    public String aGi;
    public boolean aGj;
    public long aGk;
    public String cuid;
    public int level;
    public String mCustomRoomId;
    public List<AlaLiveMarkInfoData> mLiveMarkInfo;
    public String mPortrait;
    public int mPos;
    public String mRoomId;
    public int mSex;
    public String mUserName;
    public int phone_order;
    public String uk;

    public void parseJson(JSONObject jSONObject) {
        this.mRoomId = jSONObject.optString("room_id", "");
        this.mCustomRoomId = jSONObject.optString(UbcStatConstant.KEY_CUSTOM_ROOM_ID, "");
        this.aGh = jSONObject.optString("apply_user_id", "");
        this.uk = jSONObject.optString("uk", "");
        this.mUserName = jSONObject.optString("user_nickname", "");
        this.mPortrait = jSONObject.optString("portrait", "");
        this.mSex = jSONObject.optInt("sex", 0);
        this.mPos = jSONObject.optInt("pos", 0);
        this.phone_order = jSONObject.optInt("phone_order", 0);
        this.level = jSONObject.optInt("level", 0);
        this.cuid = jSONObject.optString("cuid", "");
        this.aGi = jSONObject.optString("client_version", "0");
        this.aGk = jSONObject.optLong("app_id", 0L);
        this.aGj = jSONObject.optInt("forbidden_status", 0) == 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.mLiveMarkInfo = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    AlaLiveMarkInfoData alaLiveMarkInfoData = new AlaLiveMarkInfoData();
                    alaLiveMarkInfoData.parseJson((JSONObject) optJSONArray.get(i));
                    this.mLiveMarkInfo.add(alaLiveMarkInfoData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isApplyRedTeam() {
        return this.phone_order < 5;
    }
}
