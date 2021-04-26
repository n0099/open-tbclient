package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class SelectFriendActivityConfig extends IntentConfig {
    public static final int KEY_FROME_WEB_GAME = 0;
    public static final String KEY_FROME_WHERE = "key_from_where";
    public static final int KEY_FROM_WEB_DISCOVER = 1;

    public SelectFriendActivityConfig(Context context, int i2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
    }

    public SelectFriendActivityConfig(Context context, int i2, int i3) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        getIntent().putExtra("key_from_where", i3);
    }
}
