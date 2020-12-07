package com.baidu.live.tbadk.core.data;

import com.baidu.live.tbadk.log.LogConfig;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaBroadcastGiftToastData extends BaseData {
    public static final int BROAD_TYPE_CHELLENGE_MVP = 7;
    public static final int BROAD_TYPE_NOBLE_OPEN = 6;
    public static final int BROAD_TYPE_REDPACKET = 3;
    public static final int BROAD_TYPE_TURNTABLE_GIFT = 4;
    public static final int BROAD_TYPE_TURNTABLE_SUCCESS = 5;
    public static final int GIFT_BROADCAST = 1;
    public static final int GIFT_DEFAULT = 0;
    public static final int GUARD_CLUB_UPGRADE = 2;
    public static final int HOUR_RANK_CONFIRM = 2;
    public static final int HOUR_RANK_LEFT_ALARM = 1;
    public String endBgColor;
    public int enterTime;
    public String feed_id;
    public long gift_id;
    public String gift_name;
    public String gift_url;
    public String guideButtonFontColor;
    public String guideButtonGroundColor;
    public String guideButtonText;
    public boolean isJump;
    public String keywords;
    public String leftIcon;
    public int leftIconHeight;
    public int leftIconModel;
    public int leftIconWidth;
    public long live_id;
    public int maxRollTime;
    public long msg_id;
    public JSONObject originJsonObject;
    public String otherParams;
    public int quitTime;
    public String receiver;
    public String rightIcon;
    public int rightIconHeight;
    public int rightIconWidth;
    public String sender;
    public String sender_portrait;
    public boolean showPortrait;
    public String startBgColor;
    public int stop1Time;
    public int stop2Time;
    public String subjectName;
    public String[] textArray;
    public String[] textColorArray;
    public int localBroadcastType = 0;
    public int broad_type = 1;
    public int is_jiaoyou = 0;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.originJsonObject = jSONObject;
            this.live_id = jSONObject.optLong("live_id", 0L);
            this.sender = jSONObject.optString("sender");
            this.sender_portrait = jSONObject.optString("sender_portrait");
            this.receiver = jSONObject.optString(SocialConstants.PARAM_RECEIVER);
            this.gift_id = jSONObject.optLong(LogConfig.LOG_GIFT_ID, 0L);
            this.gift_name = jSONObject.optString("gift_name");
            this.msg_id = jSONObject.optLong("msg_id", 0L);
            this.gift_url = jSONObject.optString("gift_url");
            this.broad_type = jSONObject.optInt("broad_type", 1);
            this.is_jiaoyou = jSONObject.optInt("is_jiaoyou");
            if ((this.broad_type == 2 || this.broad_type == 4 || this.broad_type == 5) && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
                this.subjectName = optJSONObject.optString("subject_name");
                this.keywords = optJSONObject.optString("keywords");
            }
            this.isJump = jSONObject.optInt("is_jump") == 1;
            this.showPortrait = jSONObject.optInt("show_portrait", 0) == 1;
            this.leftIcon = jSONObject.optString("left_icon");
            this.leftIconWidth = jSONObject.optInt("left_icon_width");
            this.leftIconHeight = jSONObject.optInt("left_icon_height");
            this.leftIconModel = jSONObject.optInt("left_icon_model");
            this.rightIcon = jSONObject.optString("right_icon");
            this.rightIconWidth = jSONObject.optInt("right_icon_width");
            this.rightIconHeight = jSONObject.optInt("right_icon_height");
            this.startBgColor = jSONObject.optString("start_bg_color");
            this.endBgColor = jSONObject.optString("end_bg_color");
            JSONArray optJSONArray = jSONObject.optJSONArray("text_array");
            if (optJSONArray != null) {
                this.textArray = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.textArray[i] = optJSONArray.optString(i);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("text_color_array");
            if (optJSONArray2 != null) {
                this.textColorArray = new String[optJSONArray2.length()];
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.textColorArray[i2] = optJSONArray2.optString(i2);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("show_time_conf");
            if (optJSONObject2 != null) {
                this.enterTime = optJSONObject2.optInt("enter_time");
                this.stop1Time = optJSONObject2.optInt("stop_1_time");
                this.maxRollTime = optJSONObject2.optInt("max_roll_time");
                this.stop2Time = optJSONObject2.optInt("stop_2_time");
                this.quitTime = optJSONObject2.optInt("quit_time");
            }
            if (this.enterTime <= 0) {
                this.enterTime = 1;
            }
            if (this.stop1Time <= 0) {
                this.stop1Time = 1;
            }
            if (this.maxRollTime <= 0) {
                this.maxRollTime = 5;
            }
            if (this.stop2Time <= 0) {
                this.stop2Time = 1;
            }
            if (this.quitTime <= 0) {
                this.quitTime = 1;
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("guide_button");
            if (optJSONObject3 != null) {
                this.guideButtonText = optJSONObject3.optString("button_text");
                this.guideButtonGroundColor = optJSONObject3.optString("button_ground_color");
                this.guideButtonFontColor = optJSONObject3.optString("button_font_color");
            }
        }
    }

    public JSONObject toJsonObject() {
        return this.originJsonObject;
    }
}
