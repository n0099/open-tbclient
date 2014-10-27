package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class BackupLiveRoomIntroActivityConfig extends a {
    public BackupLiveRoomIntroActivityConfig(Context context, int i, int i2, String str) {
        super(context);
        getIntent().putExtra("group_id", i);
        getIntent().putExtra(a.PUBLISHER_ID, i2);
        getIntent().putExtra(a.PUBLISHER_NAME, str);
    }
}
