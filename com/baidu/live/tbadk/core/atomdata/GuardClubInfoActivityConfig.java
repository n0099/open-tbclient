package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes11.dex */
public class GuardClubInfoActivityConfig extends IntentConfig {
    public static final String ANCHOR_ID = "anchor_id";
    public static final String ANCHOR_NAME = "anchor_name";
    public static final String ANCHOR_PORTRAIT = "anchor_portrait";
    public static final String FEED_ID = "feed_id";
    public static final String FROM_LOC_INFO = "from_loc_info";
    public static final String IS_CLUB_MEMBER = "is_club_member";
    public static final String IS_FULLSCREEN = "is_fullscreen";
    public static final String IS_HIDE_RANK = "is_hide_rank";
    public static final String IS_LIVE_OWNER = "is_live_owner";
    public static final String IS_TRANSLUCENT = "is_translucent";
    public static final String LIVE_ID = "live_id";
    public static final String ROOM_ID = "room_id";

    public GuardClubInfoActivityConfig(Context context) {
        super(context);
    }

    public GuardClubInfoActivityConfig(Context context, long j, long j2, boolean z, String str, boolean z2) {
        this(context, j, j2, z, str, z2, null);
    }

    public GuardClubInfoActivityConfig(Context context, long j, long j2, boolean z, String str, boolean z2, String str2) {
        super(context);
        getIntent().putExtra("anchor_id", j);
        getIntent().putExtra("live_id", j2);
        getIntent().putExtra("is_live_owner", z);
        getIntent().putExtra(IntentConfig.OTHER_PARAMS, str);
        getIntent().putExtra(IS_FULLSCREEN, z2);
        getIntent().putExtra(FROM_LOC_INFO, str2);
    }

    public void setRoomId(long j) {
        getIntent().putExtra("room_id", j);
    }

    public void setFeedId(String str) {
        getIntent().putExtra("feed_id", str);
    }

    public void setIsClubMember(boolean z) {
        getIntent().putExtra(IS_CLUB_MEMBER, z);
    }

    public void setHideRank(boolean z) {
        getIntent().putExtra(IS_HIDE_RANK, z);
    }

    public void setIsTranslucent(boolean z) {
        getIntent().putExtra("is_translucent", z);
    }

    public void setAnchorInfo(String str, String str2) {
        getIntent().putExtra(ANCHOR_NAME, str);
        getIntent().putExtra(ANCHOR_PORTRAIT, str2);
    }
}
