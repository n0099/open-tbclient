package com.baidu.live.data;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m {
    public String aHO;
    public long aHQ;
    public int aIw;
    public int aIx;
    public boolean aIy;
    public String cuid;
    public String customRoomId;
    public int level;
    public List<AlaLiveMarkInfoData> mLiveMarkInfo;
    public String portrait;
    public String roomId;
    public int sex;
    public String subappType;
    public String uk;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        this.roomId = jSONObject.optString("room_id", "");
        this.customRoomId = jSONObject.optString(UbcStatConstant.KEY_CUSTOM_ROOM_ID, "");
        this.subappType = jSONObject.optString("subapp_type", "");
        this.uk = jSONObject.optString("uk", "");
        this.userName = jSONObject.optString("user_nickname", "");
        this.portrait = jSONObject.optString("portrait", "");
        this.sex = jSONObject.optInt("sex", 0);
        this.level = jSONObject.optInt("level", 0);
        this.cuid = jSONObject.optString("cuid", "");
        this.aHO = jSONObject.optString("client_version", "0");
        this.aIw = jSONObject.optInt("link_status", 0);
        this.aIx = jSONObject.optInt("living_status", 0);
        this.aHQ = jSONObject.optLong("app_id", 0L);
        this.aIy = jSONObject.optInt("forbidden_status", 0) == 0;
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

    public boolean Ej() {
        return this.aIx == 1;
    }
}
