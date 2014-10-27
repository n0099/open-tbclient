package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class LiveRoomEntranceActivityConfig extends a {
    public LiveRoomEntranceActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra("forum_id", i);
        getIntent().putExtra("forum_name", str);
    }
}
