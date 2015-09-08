package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PhotoLiveListActivityConfig extends IntentConfig {
    public static final String CAN_SHOW_DELETE_BUTTON = "can_show_delete_button";

    public PhotoLiveListActivityConfig(Context context, String str, boolean z, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("forum_id", str);
        intent.putExtra(CAN_SHOW_DELETE_BUTTON, z);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
