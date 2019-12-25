package com.baidu.ala.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaUserInfoData extends OrmObject {
    public static final int IS_LIVING = 1;
    public long ala_id;
    public long anchor_live;
    public int app_from = -1;
    public String card_pic;
    public int certify_status;
    public int change_sex;
    public String channel_count;
    public String charm_count;
    public String create_time;
    public int dan_id;
    public String dan_name;
    public long dan_score;
    public String description;
    public long enter_live;
    public long fans_count;
    public long follow_count;
    public String great_anchor_desc_grade;
    public String great_anchor_desc_role;
    public String great_anchor_icon;
    public int has_tieba_username;
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
    public AlaMarkCountInfoData mark_count;
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
    public String update_time;
    public String user_id;
    public String user_name;
    public String user_nickname;
    public int user_status;
    public int verify_info_status;
    public int verify_status;
    public int verify_type;
    public int verify_video_status;

    public String getNameShow() {
        return TextUtils.isEmpty(this.user_nickname) ? this.user_name : this.user_nickname;
    }
}
