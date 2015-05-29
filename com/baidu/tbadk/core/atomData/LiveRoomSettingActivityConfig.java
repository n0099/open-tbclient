package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class LiveRoomSettingActivityConfig extends c {
    public LiveRoomSettingActivityConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("group_id", i);
    }
}
