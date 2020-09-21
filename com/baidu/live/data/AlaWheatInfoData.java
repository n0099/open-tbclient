package com.baidu.live.data;

import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaWheatInfoData implements Serializable, Cloneable {
    public String charmCount;
    public String customRoomId;
    public int fansCount;
    public long imUK;
    public boolean isHost;
    public boolean isSelected;
    public int level;
    public float locationCenterX;
    public float locationCenterY;
    public List<AlaLiveMarkInfoData> mLiveMarkInfo;
    public String mikeStatus;
    public String phoneOrder;
    public String phoneType;
    public String portrait;
    public int realWheatPosition;
    public String roomId;
    public int sex;
    public String startTime;
    public String subappType;
    public String token;
    public String uk;
    public int userIdentity;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        int i = 0;
        this.roomId = jSONObject.optString("room_id", "");
        this.phoneType = jSONObject.optString("phone_type", "");
        this.phoneOrder = jSONObject.optString("phone_order", "");
        this.subappType = jSONObject.optString("subapp_type", "");
        this.userName = jSONObject.optString("user_nickname", "");
        this.portrait = jSONObject.optString("portrait", "");
        this.sex = jSONObject.optInt("sex", 0);
        this.fansCount = jSONObject.optInt("fans_count", 0);
        this.level = jSONObject.optInt("level", 0);
        this.userIdentity = jSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        this.charmCount = jSONObject.optString("charm_count", "");
        this.startTime = jSONObject.optString("start_time", "");
        this.uk = jSONObject.optString("uk", "");
        this.mikeStatus = jSONObject.optString("mike_status", "");
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

    public boolean isOpenMike() {
        return "0".equals(this.mikeStatus);
    }

    public boolean isFemale() {
        return this.sex == 2;
    }

    public Object clone() {
        try {
            return (AlaWheatInfoData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        System.out.println("equals method invoked!");
        if (obj == this) {
            return true;
        }
        if (obj instanceof AlaWheatInfoData) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) obj;
            return (this.uk != null && this.uk.equals(alaWheatInfoData.uk)) || (this.imUK != 0 && this.imUK == alaWheatInfoData.imUK);
        }
        return false;
    }
}
