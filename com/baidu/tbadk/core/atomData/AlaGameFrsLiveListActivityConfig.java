package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AlaGameFrsLiveListActivityConfig extends IntentConfig {
    public static final String LIVE_FORUM_GAME_LABEL = "live_forum_game_label";
    public static final String LIVE_FORUM_ID = "live_forum_id";
    public static final String LIVE_FORUM_NAME = "live_forum_name";

    public AlaGameFrsLiveListActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("live_forum_id", str);
        getIntent().putExtra(LIVE_FORUM_GAME_LABEL, str3);
        getIntent().putExtra("live_forum_name", str2);
    }
}
