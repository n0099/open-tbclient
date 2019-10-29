package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class AtListActivityConfig extends IntentConfig {
    public static final String IS_FOR_CHAT = "is_for_chat";

    public AtListActivityConfig(Context context, int i, boolean z) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("is_need_multiple", z);
        if (i == 12011) {
            getIntent().putExtra("keyboard", false);
        }
    }

    public void setIsForChat(boolean z) {
        getIntent().putExtra(IS_FOR_CHAT, z);
    }
}
