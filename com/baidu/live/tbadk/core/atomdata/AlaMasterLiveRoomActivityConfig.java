package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import java.io.Serializable;
/* loaded from: classes11.dex */
public class AlaMasterLiveRoomActivityConfig extends IntentConfig {
    public static final String CREATE_MASTER_LIVE_TYPE = "create_master_live_type";
    public static final int CREATE_MASTER_LIVE_TYPE_FROM_CRASH_REOPEN = 2;
    public static final int CREATE_MASTER_LIVE_TYPE_NORMAL = 1;
    public static final String LIVE_FORUM_ID = "live_forum_id";
    public static final String LIVE_FORUM_NAME = "live_forum_name";
    public static final String LIVE_INFO = "live_info_core";
    public static final String LIVE_START_PARAMS = "live_start_params";
    public static final String SPECIAL_FORIM_TYPE = "special_forum_type";
    public static final String STOP_IM_WHEN_CLOSE = "stop_im_when_close";
    public static final String USER_ID = "user_id";

    public AlaMasterLiveRoomActivityConfig(Context context, String str, String str2, String str3, String str4, String str5) {
        super(context);
        getIntent().putExtra("live_forum_name", str);
        getIntent().putExtra("live_forum_id", str2);
        getIntent().putExtra("user_id", str3);
        getIntent().putExtra("create_master_live_type", 1);
        getIntent().putExtra("special_forum_type", str4);
        getIntent().putExtra(LIVE_START_PARAMS, str5);
    }

    public AlaMasterLiveRoomActivityConfig(Context context, Serializable serializable) {
        super(context);
        getIntent().putExtra("live_info_core", serializable.toString());
        getIntent().putExtra("create_master_live_type", 2);
    }

    public AlaMasterLiveRoomActivityConfig setNeedStopImWhenClose(boolean z) {
        getIntent().putExtra("stop_im_when_close", z);
        return this;
    }
}
