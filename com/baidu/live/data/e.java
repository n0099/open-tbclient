package com.baidu.live.data;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public String aGX;
    public String aGY;
    public long aGZ;
    public String cuid;
    public int level;
    public String mCustomRoomId;
    public List<AlaLiveMarkInfoData> mLiveMarkInfo;
    public String mPortrait;
    public int mPos;
    public String mRoomId;
    public int mSex;
    public String mUserName;
    public String uk;

    public void parseJson(JSONObject jSONObject) {
        int i = 0;
        this.mRoomId = jSONObject.optString("room_id", "");
        this.mCustomRoomId = jSONObject.optString(UbcStatConstant.KEY_CUSTOM_ROOM_ID, "");
        this.aGX = jSONObject.optString("apply_user_id", "");
        this.uk = jSONObject.optString("uk", "");
        this.mUserName = jSONObject.optString("user_nickname", "");
        this.mPortrait = jSONObject.optString("portrait", "");
        this.mSex = jSONObject.optInt("sex", 0);
        this.mPos = jSONObject.optInt("pos", 0);
        this.level = jSONObject.optInt("level", 0);
        this.cuid = jSONObject.optString("cuid", "");
        this.aGY = jSONObject.optString("client_version", "0");
        this.aGZ = jSONObject.optLong("app_id", 0L);
        JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.mLiveMarkInfo = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    try {
                        AlaLiveMarkInfoData alaLiveMarkInfoData = new AlaLiveMarkInfoData();
                        alaLiveMarkInfoData.parseJson((JSONObject) optJSONArray.get(i2));
                        this.mLiveMarkInfo.add(alaLiveMarkInfoData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
