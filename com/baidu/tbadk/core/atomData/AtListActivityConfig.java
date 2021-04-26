package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class AtListActivityConfig extends IntentConfig {
    public static final String IS_FOR_BJH = "is_for_bjh";
    public static final String IS_FOR_CHAT = "is_for_chat";

    public AtListActivityConfig(Context context, int i2, boolean z) {
        super(context);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(IntentConfig.IS_NEED_MULTIPLE, z);
        if (i2 == 12011) {
            getIntent().putExtra(IntentConfig.SHOW_KEYBOARD, false);
        }
    }

    public void setIsForBjh(boolean z) {
        getIntent().putExtra(IS_FOR_BJH, z);
    }

    public void setIsForChat(boolean z) {
        getIntent().putExtra(IS_FOR_CHAT, z);
    }
}
