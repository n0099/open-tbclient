package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class GuardClubMemberListActivityConfig extends IntentConfig {
    public static final String ANCHOR_ID = "anchor_id";
    public static final String FEED_ID = "feed_id";
    public static final String IS_LIVE_OWNER = "is_live_owner";
    public static final String LIVE_ID = "live_id";
    public static final String ROOM_ID = "room_id";

    public GuardClubMemberListActivityConfig(Context context, long j, long j2, boolean z, String str) {
        super(context);
        getIntent().putExtra("anchor_id", j);
        getIntent().putExtra("live_id", j2);
        getIntent().putExtra("is_live_owner", z);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str);
    }

    public void setRoomId(long j) {
        getIntent().putExtra("room_id", j);
    }

    public void setFeedId(String str) {
        getIntent().putExtra("feed_id", str);
    }
}
