package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class at {
    public String aQd;
    public String aQf;
    public int aQg;
    public String aQh;
    public int aQi;
    public String aQj;
    public long ala_id;
    public long anchor_live;
    public int change_sex;
    public String channel_count;
    public long charm_count;
    public String create_time;
    public String description;
    public long enter_live;
    public JSONObject extInfoJson;
    public JSONObject extraUserInfo;
    public long fans_count;
    public long follow_count;
    public String great_anchor_desc_grade;
    public String great_anchor_desc_role;
    public String great_anchor_icon;
    public int has_tieba_username;
    public int isBjh;
    public int is_block;
    public int is_live_admin;
    public int is_login;
    public int is_official;
    public double lat;
    public int level_exp;
    public int level_id;
    public String live_count;
    public String live_id;
    public List<AlaLiveMarkData> live_mark_info_new;
    public int live_status;
    public double lng;
    public String location;
    public String loginType;
    public String media_end_time;
    public int next_exp;
    public String pass_name;
    public int petal_num;
    public String portrait;
    public String portrait_origion;
    public int push_switch;
    public int record_count;
    public long send_count;
    public int sex;
    public long stream_id;
    public String third_app_id;
    public String type;
    public String update_time;
    public String user_id;
    public String user_name;
    public String user_nickname;
    public int user_status;
    public int verify_info_status;
    public int verify_status;
    public int verify_type;
    public int verify_video_status;
    public String aQe = "";
    public int gender = 2;

    public String getNameShow() {
        return TextUtils.isEmpty(this.user_nickname) ? this.user_name : this.user_nickname;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ala_id = jSONObject.optLong("ala_id");
            if (TextUtils.isEmpty(jSONObject.optString("user_id"))) {
                this.user_id = ExtraParamsManager.getDecryptUserId(jSONObject.optString("user_uk"));
            } else {
                this.user_id = jSONObject.optString("user_id");
            }
            this.aQd = ExtraParamsManager.getDecryptUserId(jSONObject.optString("pa_uid"));
            this.loginType = jSONObject.optString(Constants.KEY_LOGIN_TYPE);
            this.type = jSONObject.optString("type");
            this.aQe = jSONObject.optString("meta_key");
            this.verify_info_status = jSONObject.optInt("verify_info_status");
            this.verify_video_status = jSONObject.optInt("verify_video_status");
            this.verify_type = jSONObject.optInt("verify_type");
            this.user_name = jSONObject.optString("user_name");
            this.user_nickname = jSONObject.optString("user_nickname");
            this.pass_name = jSONObject.optString("pass_name");
            this.sex = jSONObject.optInt("sex");
            this.gender = jSONObject.optInt("gender");
            this.description = jSONObject.optString("description");
            this.portrait = jSONObject.optString("bd_portrait");
            if (StringUtils.isNull(this.portrait)) {
                this.portrait = jSONObject.optString("portrait");
            }
            this.aQf = jSONObject.optString("bg_img");
            this.aQh = jSONObject.optString("app_from");
            this.level_id = jSONObject.optInt("level_id");
            this.level_exp = jSONObject.optInt("level_exp");
            this.next_exp = jSONObject.optInt("next_exp");
            this.is_login = jSONObject.optInt(ImageViewerConfig.IS_LOGIN);
            this.fans_count = jSONObject.optLong("fans_count");
            this.follow_count = jSONObject.optLong("follow_count");
            this.charm_count = jSONObject.optLong("charm_count");
            this.channel_count = jSONObject.optString("channel_count");
            this.live_count = jSONObject.optString("live_count");
            this.user_status = jSONObject.optInt("user_status");
            this.live_status = jSONObject.optInt("live_status");
            this.live_id = jSONObject.optString("live_id");
            this.create_time = jSONObject.optString("create_time");
            this.update_time = jSONObject.optString("update_time");
            this.media_end_time = jSONObject.optString("media_end_time");
            this.change_sex = jSONObject.optInt("change_sex");
            this.is_official = jSONObject.optInt("is_official");
            this.portrait_origion = jSONObject.optString("portrait_origion");
            this.send_count = jSONObject.optLong("send_count");
            this.record_count = jSONObject.optInt("record_count");
            this.push_switch = jSONObject.optInt("push_switch");
            this.location = jSONObject.optString("location");
            this.lng = jSONObject.optDouble("lng");
            this.lat = jSONObject.optDouble("lat");
            this.anchor_live = jSONObject.optLong("anchor_live");
            this.enter_live = jSONObject.optLong("enter_live");
            this.is_live_admin = jSONObject.optInt("is_live_admin");
            this.is_block = jSONObject.optInt("is_block");
            this.aQg = jSONObject.optInt("is_chat_block");
            this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.third_app_id = jSONObject.optString("third_app_id");
            this.stream_id = jSONObject.optLong(BdStatsConstant.StatsKey.STREAM_ID);
            this.has_tieba_username = jSONObject.optInt("has_tieba_username");
            this.verify_status = jSONObject.optInt("verify_status");
            this.great_anchor_icon = jSONObject.optString("great_anchor_icon");
            this.great_anchor_desc_grade = jSONObject.optString("great_anchor_desc_grade");
            this.great_anchor_desc_role = jSONObject.optString("great_anchor_desc_role");
            this.petal_num = jSONObject.optInt("petal_num");
            this.aQj = jSONObject.optString("bd_personal_page");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_mark_info_new");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.live_mark_info_new = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                    alaLiveMarkData.parserJson(optJSONObject);
                    this.live_mark_info_new.add(alaLiveMarkData);
                }
            }
            this.aQi = jSONObject.optInt("live_mark_total");
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                this.extraUserInfo = jSONObject.optJSONObject(TbConfig.getSubappType() + "_info");
            }
            this.extInfoJson = jSONObject.optJSONObject("ext_info");
        }
    }
}
