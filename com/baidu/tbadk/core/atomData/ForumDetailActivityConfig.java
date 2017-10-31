package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ForumDetailActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FROM_TYPE = "from_type";

    /* loaded from: classes.dex */
    public enum FromType {
        BAR,
        FRS,
        FRS_SIDE,
        BAR_DIR,
        BAR_RANK,
        BAR_SQUARE,
        GAME_FRS_GOOD,
        FRS_GAME_INFO,
        FRS_GAME_STRATEGY,
        FRS_GAME_LIVE
    }

    public ForumDetailActivityConfig(Context context, String str, FromType fromType) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra(FROM_TYPE, fromType.toString());
    }
}
