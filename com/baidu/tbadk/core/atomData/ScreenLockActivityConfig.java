package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ScreenLockActivityConfig extends IntentConfig {
    public static final String CHAT_CONTENT = "chat_content";
    public static final String CHAT_NAME = "chat_name";

    public ScreenLockActivityConfig(Context context) {
        super(context);
    }

    public ScreenLockActivityConfig(Context context, String str, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(CHAT_NAME, str);
        intent.putExtra(CHAT_CONTENT, str2);
    }
}
