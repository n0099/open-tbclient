package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class LiveRoomReplayActivityConfig extends a {
    public LiveRoomReplayActivityConfig(Context context, String str, String str2, int i, int i2, String str3) {
        super(context);
        getIntent().putExtra("group_name", str);
        getIntent().putExtra(a.REPLAY_URL, str2);
        getIntent().putExtra("group_id", i);
        getIntent().putExtra(a.PUBLISHER_ID, i2);
        getIntent().putExtra(a.PUBLISHER_NAME, str3);
    }
}
