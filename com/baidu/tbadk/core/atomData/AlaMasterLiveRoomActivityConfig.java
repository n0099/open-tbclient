package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AlaMasterLiveRoomActivityConfig extends IntentConfig {
    public static final String CREATE_MASTER_LIVE_TYPE = "create_master_live_type";
    public static final int CREATE_MASTER_LIVE_TYPE_FROM_CRASH_REOPEN = 2;
    public static final int CREATE_MASTER_LIVE_TYPE_NORMAL = 1;
    public static final String LIVE_FORUM_ID = "live_forum_id";
    public static final String LIVE_FORUM_NAME = "live_forum_name";
    public static final String LIVE_INFO = "live_info_core";
    public static final String LIVE_IS_CREATE_FROM_GAME_FORUM = "live_is_create_from_game_forum";
    public static final String USER_ID = "user_id";

    public AlaMasterLiveRoomActivityConfig(Context context, String str, String str2, String str3, boolean z) {
        super(context);
        getIntent().putExtra("live_forum_name", str);
        getIntent().putExtra("live_forum_id", str2);
        getIntent().putExtra("user_id", str3);
        getIntent().putExtra(CREATE_MASTER_LIVE_TYPE, 1);
        getIntent().putExtra(LIVE_IS_CREATE_FROM_GAME_FORUM, z);
    }

    public AlaMasterLiveRoomActivityConfig(Context context, Serializable serializable) {
        super(context);
        getIntent().putExtra("live_info_core", serializable);
        getIntent().putExtra(CREATE_MASTER_LIVE_TYPE, 2);
    }
}
