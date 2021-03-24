package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class BlackMembersListActivityConfig extends IntentConfig {
    public static final String KEY_IS_FROM_PHOTO_LIVE = "is_from_photo_live";
    public static final int MUTE_TYPE_FOR_PHOTO_LIVE = 1;

    public BlackMembersListActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("group_id", str);
    }

    public BlackMembersListActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(KEY_IS_FROM_PHOTO_LIVE, z);
    }
}
