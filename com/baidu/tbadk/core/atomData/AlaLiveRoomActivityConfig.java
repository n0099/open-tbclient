package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Parcelable;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AlaLiveRoomActivityConfig extends IntentConfig {
    public static final String FREM_TYPE_LIVE_FRS_STAGE_LIVE = "frs_live_stage_live";
    public static final String FROM_TYPE_ALTER_PLAY = "alter_play";
    public static final String FROM_TYPE_BROADCAST_GIFT_TOAST = "broadcast_gift_toast";
    public static final String FROM_TYPE_END_VIEW = "end_view";
    public static final String FROM_TYPE_FRS_AUTO_PLAY = "frs_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_AUTO_PLAY = "frs_live_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_PLAY = "frs_live_play";
    public static final String FROM_TYPE_FRS_PLAY = "frs_play";
    public static final String FROM_TYPE_FRS_SHARE_LIVE = "frs_share_live";
    public static final String FROM_TYPE_HOME_CONCERN_TAB = "home_concern_tab";
    public static final String FROM_TYPE_HOME_LIVE_AUTO_PLAY = "home_live_auto_play";
    public static final String FROM_TYPE_HOME_LIVE_PLAY = "home_live_play";
    public static final String FROM_TYPE_HOME_LIVE_TAB_MAIN = "home_live_tab_main";
    public static final String FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN = "home_live_tab_my_concern";
    public static final String FROM_TYPE_HOME_REC_AUTO_PLAY = "home_rec_auto_play";
    public static final String FROM_TYPE_HOME_REC_PLAY = "home_rec_play";
    public static final String FROM_TYPE_LIVE_ACTIVE_VIEW = "active_view_jump_live_room";
    public static final String FROM_TYPE_LIVE_BOTTOM_PANEL_FANS = "live_bottom_panel_fans";
    public static final String FROM_TYPE_LIVE_BOTTOM_PANEL_FOLLOWED = "live_bottom_panel_followed";
    public static final String FROM_TYPE_LIVE_CONCERN_TAB_TOP_LIVE = "ala_concern_tab_top_live";
    public static final String FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP = "frs_followed_live_tip";
    public static final String FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP = "frs_hot_live_tip";
    public static final String FROM_TYPE_LIVE_FRS_INSERT_LIVE = "frs_five_floor_recommend";
    public static final String FROM_TYPE_LIVE_LIVE_ROOM_LIVE_TAB = "live_room_live_tab";
    public static final String FROM_TYPE_LIVE_PB_POST_RECOMMEND = "pb_recommend_live";
    public static final String FROM_TYPE_LIVE_PK_SWITCH = "live_pk_switch";
    public static final String FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB = "recent_history_living_tab";
    public static final String FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB = "recent_history_whole_tab";
    public static final String FROM_TYPE_LIVE_ROOM_CLOSE_DIALOG = "live_room_close_dialog";
    public static final String FROM_TYPE_LIVE_ROOM_RANK_LIST = "live_room_rank_list";
    public static final String FROM_TYPE_LIVE_SQUARE_ATTENTION_LIVE = "ala_square_attention_live";
    public static final String FROM_TYPE_MIS_GLOBAL_BROADCAST = "live_mis_global_broadcast";
    public static final String FROM_TYPE_MIS_SINGLE_BROADCAST = "live_mis_single_broadcast";
    public static final String FROM_TYPE_OUTSIDE = "safari_play";
    public static final String FROM_TYPE_PB_AUTO_PLAY = "pb_auto_play";
    public static final String FROM_TYPE_PB_PLAY = "pb_play";
    public static final String FROM_TYPE_PERSON_ATTENTION = "person_attention";
    public static final String FROM_TYPE_PERSON_AUTO_PLAY = "person_auto_play";
    public static final String FROM_TYPE_PERSON_PLAY = "person_play";
    public static final String FROM_TYPE_SCAN_HISTORY = "scan_history";
    public static final String FROM_TYPE_SEARCH = "search";
    public static final String FROM_TYPE_SHARE_PLAY = "share_play";
    public static final String FROM_TYPE_SPECIAL_CONCERN_TAB = "frs_live_tab_concern_tab";
    public static final String FROM_TYPE_SPECIAL_RECOMMEND_TAB = "frs_live_tab_recommend_tab";
    public static final String FROM_TYPE_SPECIAL_SUB_TAB = "frs_live_tab_sub_tab";
    public static final String FROM_TYPE_SPECIAL_TAB_TOP_LIVE = "frs_live_tab_headview";
    public static final String FROM_TYPE_SQUARE_CATOGORY = "square_category";
    public static final String FROM_TYPE_SQUARE_DYNAMIC = "square_dynamic";
    public static final String FROM_TYPE_SQUARE_LIVE = "square_live";
    public static final String FROM_TYPE_SQUARE_LIVE_BANNER = "square_live_banner";
    public static final String FROM_TYPE_SQUARE_RECOMMEND = "square_recommend";
    public static final String FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD = "square_recommend_top_card";
    @Deprecated
    public static final String FROM_TYPE_SQUARE_SHOW_LIVE = "square_show_field";
    public static final String FROM_TYPE_SQUARE_SUB_LIVE = "square_sub_live";
    public static final String FROM_TYPE_TAIL_LIGHT = "tail_light_play";
    public static final String FROM_TYPE_VIDEO_AUTO_PLAY = "video_auto_play";
    public static final String FROM_TYPE_VIDEO_PLAY = "video_play";
    public static final String LIVE_COMMON_BROADCAST_QUEUE = "live_common_broadcast_queue";
    public static final String LIVE_ENTRY_LIVE_URL = "live_entry_live_url";
    public static final String LIVE_ENTRY_NAME = "live_entry_name";
    public static final String LIVE_FORBID_VERTICAL_CHANGE_LIVEROOM = "live_forbid_vertical_change_liveroom";
    public static final String LIVE_FORUM_NAME = "live_forum_name";
    public static final String LIVE_FROM_FORUM_ID = "live_from_forum_id";
    public static final String LIVE_FROM_TYPE = "live_from_type";
    public static final String LIVE_INFO = "live_info_core";
    public static final String LIVE_IS_HOST = "live_is_host";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";

    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, String str, String str2, boolean z, String str3) {
        super(context);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra("live_forum_name", str3);
    }

    public AlaLiveRoomActivityConfig setIsForbidVerticalChangeLiveRoom(boolean z) {
        getIntent().putExtra(LIVE_FORBID_VERTICAL_CHANGE_LIVEROOM, z);
        return this;
    }

    public AlaLiveRoomActivityConfig setCommonBroadcastQueue(ArrayList<Parcelable> arrayList) {
        getIntent().putParcelableArrayListExtra(LIVE_COMMON_BROADCAST_QUEUE, arrayList);
        return this;
    }

    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, AlaLiveInfoListCoreData alaLiveInfoListCoreData, String str, String str2, boolean z, String str3, String str4) {
        super(context);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra(LIVE_ENTRY_NAME, str3);
        getIntent().putExtra(LIVE_FROM_FORUM_ID, str4);
    }

    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, AlaLiveInfoListCoreData alaLiveInfoListCoreData, String str, String str2, boolean z, String str3, String str4, String str5) {
        super(context);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra(LIVE_ENTRY_NAME, str3);
        getIntent().putExtra(LIVE_FROM_FORUM_ID, str4);
        getIntent().putExtra("live_forum_name", str5);
    }

    public AlaLiveRoomActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra(LIVE_ENTRY_LIVE_URL, str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra(LIVE_FROM_TYPE, str3);
    }
}
