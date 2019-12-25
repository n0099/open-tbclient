package com.baidu.live.tbadk.core.atom;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes2.dex */
public class GuardClubRankActivityConfig extends IntentConfig implements GuardClubActivityConfig {
    public GuardClubRankActivityConfig(Context context, long j, long j2, boolean z, String str) {
        super(context);
        getIntent().putExtra(GuardClubActivityConfig.ANCHOR_ID, j);
        getIntent().putExtra(GuardClubActivityConfig.LIVE_ID, j2);
        getIntent().putExtra(GuardClubActivityConfig.IS_LIVE_OWNER, z);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str);
    }

    public void setRoomId(long j) {
        getIntent().putExtra(GuardClubActivityConfig.ROOM_ID, j);
    }

    public void setFeedId(String str) {
        getIntent().putExtra(GuardClubActivityConfig.FEED_ID, str);
    }
}
