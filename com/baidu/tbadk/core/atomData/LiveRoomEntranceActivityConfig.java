package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class LiveRoomEntranceActivityConfig extends c {
    public static String FROM_FRS = PbActivityConfig.KEY_FROM_FRS;
    public static String FROM_HOT_LIVE = "from_hot_live";

    public LiveRoomEntranceActivityConfig(Context context, int i, String str, String str2) {
        super(context);
        getIntent().putExtra("forum_id", i);
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra("from", str2);
    }
}
