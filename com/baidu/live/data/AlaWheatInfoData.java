package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaWheatInfoData implements Serializable, Cloneable {
    public String bg_img;
    public String bigPortrait;
    public String charmCount;
    public boolean clearSelectFlag;
    public String customRoomId;
    public int fansCount;
    public String hatLevelIcon;
    public String hatLowIcon;
    public String hat_level_icon;
    public String hat_low_icon;
    public long imUK;
    public boolean isHost;
    public boolean isSelect;
    public boolean isSelected;
    public int level;
    public float locationCenterX;
    public float locationCenterY;
    public List<AlaLiveMarkInfoData> mLiveMarkInfo;
    public String mikeStatus;
    public int other_publish;
    public String phoneOrder;
    public String phoneType;
    public int phone_order;
    public String portrait;
    public int[] pre_together;
    public int publish;
    public int realWheatPosition;
    public String roomId;
    public int select;
    public int sex;
    public String startTime;
    public int status;
    public String subappType;
    public int sum_charm_count;
    public int[] together;
    public String token;
    public String uk;
    public int userIdentity;
    public String userName;

    public void parseJson(JSONObject jSONObject) {
        this.roomId = jSONObject.optString("room_id", "");
        this.phoneType = jSONObject.optString("phone_type", "");
        this.phoneOrder = jSONObject.optString("phone_order", "");
        this.subappType = jSONObject.optString("subapp_type", "");
        this.userName = jSONObject.optString("user_nickname", "");
        this.portrait = jSONObject.optString("portrait", "");
        this.bigPortrait = jSONObject.optString("big_portrait", "");
        this.sex = jSONObject.optInt("sex", 0);
        this.fansCount = jSONObject.optInt("fans_count", 0);
        this.level = jSONObject.optInt(MapBundleKey.MapObjKey.OBJ_LEVEL, 0);
        this.userIdentity = jSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        this.charmCount = jSONObject.optString("charm_count", "");
        this.startTime = jSONObject.optString("start_time", "");
        this.uk = jSONObject.optString("uk", "");
        this.mikeStatus = jSONObject.optString("mike_status", "");
        this.hatLevelIcon = jSONObject.optString("hat_level_icon", "");
        this.hatLowIcon = jSONObject.optString("hat_low_icon", "");
        this.select = jSONObject.optInt("select", 0);
        this.publish = jSONObject.optInt("publish", 0);
        this.other_publish = jSONObject.optInt("other_publish", 0);
        this.sum_charm_count = jSONObject.optInt("sum_charm_count", 0);
        this.bg_img = jSONObject.optString("bg_img", "");
        this.hat_level_icon = jSONObject.optString("hat_level_icon", "");
        this.hat_low_icon = jSONObject.optString("hat_low_icon", "");
        this.phone_order = jSONObject.optInt("phone_order", 0);
        this.status = jSONObject.optInt("status", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("together");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.together = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    this.together[i] = ((Integer) optJSONArray.opt(i)).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("pre_together");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.pre_together = new int[optJSONArray2.length()];
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    this.pre_together[i2] = ((Integer) optJSONArray2.opt(i2)).intValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("live_mark_info");
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            this.mLiveMarkInfo = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                try {
                    AlaLiveMarkInfoData alaLiveMarkInfoData = new AlaLiveMarkInfoData();
                    alaLiveMarkInfoData.parseJson((JSONObject) optJSONArray3.opt(i3));
                    this.mLiveMarkInfo.add(alaLiveMarkInfoData);
                } catch (Exception e3) {
                    e3.printStackTrace();
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

    public boolean isNullData() {
        return TextUtils.isEmpty(this.uk);
    }

    public boolean isApplyRedTeam() {
        return this.phone_order < 5;
    }
}
