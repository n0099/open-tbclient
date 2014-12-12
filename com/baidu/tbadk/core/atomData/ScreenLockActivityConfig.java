package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class ScreenLockActivityConfig extends a {
    private static final String CHAT_CONTENT = "chat_content";
    private static final String CHAT_NAME = "chat_name";

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
