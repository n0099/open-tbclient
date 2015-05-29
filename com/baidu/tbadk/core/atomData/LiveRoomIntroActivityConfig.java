package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class LiveRoomIntroActivityConfig extends c {
    public LiveRoomIntroActivityConfig(Context context, int i, int i2, String str) {
        super(context);
        getIntent().putExtra("group_id", i);
        getIntent().putExtra(c.PUBLISHER_ID, i2);
        getIntent().putExtra(c.PUBLISHER_NAME, str);
    }
}
