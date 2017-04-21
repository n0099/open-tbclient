package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AlaLiveRoomActivityConfig extends IntentConfig {
    public static final String FROM_TYPE_ALTER_PLAY = "alter_play";
    public static final String FROM_TYPE_FRS_AUTO_PLAY = "frs_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_AUTO_PLAY = "frs_live_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_PLAY = "frs_live_play";
    public static final String FROM_TYPE_FRS_PLAY = "frs_play";
    public static final String FROM_TYPE_HOME_LIVE_AUTO_PLAY = "home_live_auto_play";
    public static final String FROM_TYPE_HOME_LIVE_PLAY = "home_live_play";
    public static final String FROM_TYPE_HOME_REC_AUTO_PLAY = "home_rec_auto_play";
    public static final String FROM_TYPE_HOME_REC_PLAY = "home_rec_play";
    public static final String FROM_TYPE_PB_AUTO_PLAY = "pb_auto_play";
    public static final String FROM_TYPE_PB_PLAY = "pb_play";
    public static final String FROM_TYPE_PERSON_AUTO_PLAY = "person_auto_play";
    public static final String FROM_TYPE_PERSON_PLAY = "person_play";
    public static final String FROM_TYPE_SHARE_PLAY = "share_play";
    public static final String FROM_TYPE_TAIL_LIGHT = "tail_light_play";
    public static final String FROM_TYPE_VIDEO_AUTO_PLAY = "video_auto_play";
    public static final String FROM_TYPE_VIDEO_PLAY = "video_play";
    public static final String LIVE_ENTRY_LIVE_URL = "live_entry_live_url";
    public static final String LIVE_FORUM_ID = "live_forum_id";
    public static final String LIVE_FORUM_NAME = "live_forum_name";
    public static final String LIVE_FROM_TYPE = "live_from_type";
    public static final String LIVE_ID = "live_id";
    public static final String LIVE_INFO = "live_info_core";
    public static final String LIVE_INFO_LIST = "live_info_core_list";
    public static final String LIVE_IS_CREATE_LIVE_ROOM = "create_live_room";
    public static final String LIVE_IS_FROM_GAME_FORUM = "live_is_open_from_game_forum";
    public static final String LIVE_IS_HOST = "live_is_host";
    public static final String LIVE_IS_REOPEN_FROM_CRASH = "live_is_reopen_from_crash";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";

    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra(LIVE_INFO, alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
    }

    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, AlaLiveInfoListCoreData alaLiveInfoListCoreData, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra(LIVE_INFO, alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra(LIVE_INFO_LIST, alaLiveInfoListCoreData);
    }

    public AlaLiveRoomActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra(LIVE_ENTRY_LIVE_URL, str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra(LIVE_FROM_TYPE, str3);
    }

    public AlaLiveRoomActivityConfig(Context context, String str, String str2, String str3, boolean z, boolean z2) {
        super(context);
        getIntent().putExtra(LIVE_FORUM_NAME, str);
        getIntent().putExtra(LIVE_FORUM_ID, str2);
        getIntent().putExtra(LIVE_IS_CREATE_LIVE_ROOM, true);
        getIntent().putExtra("user_id", str3);
        getIntent().putExtra(LIVE_IS_FROM_GAME_FORUM, z2);
    }
}
