package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LiveRoomSettingActivityConfig extends IntentConfig {
    public LiveRoomSettingActivityConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("group_id", i);
    }
}
