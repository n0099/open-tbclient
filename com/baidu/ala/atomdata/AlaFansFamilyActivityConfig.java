package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes6.dex */
public class AlaFansFamilyActivityConfig extends IntentConfig {
    public static final String AUTHOR_LIVE_USER_ID = "author_live_user_id";
    public static final String FROM_LIVE_ROOM = "from_live_room";
    public static final String FROM_PERSON_CENTER = "from_person_center";
    public static final String FROM_TYPE = "from_type";
    public static final String IS_SHOW_FULL_SCREEN = "is_show_full_screen";

    public AlaFansFamilyActivityConfig(Context context, String str, boolean z, String str2) {
        super(context);
        getIntent().putExtra("author_live_user_id", str);
        getIntent().putExtra(IS_SHOW_FULL_SCREEN, z);
        getIntent().putExtra("from_type", str2);
    }
}
