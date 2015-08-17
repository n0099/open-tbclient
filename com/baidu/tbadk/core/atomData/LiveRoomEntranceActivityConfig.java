package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LiveRoomEntranceActivityConfig extends IntentConfig {
    public static String FROM_FRS = "from_frs";
    public static String FROM_HOT_LIVE = "from_hot_live";

    public LiveRoomEntranceActivityConfig(Context context, int i, String str, String str2) {
        super(context);
        getIntent().putExtra("forum_id", i);
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra("from", str2);
    }
}
