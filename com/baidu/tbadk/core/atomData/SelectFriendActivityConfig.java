package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class SelectFriendActivityConfig extends a {
    public static final int KEY_FROME_WEB_GAME = 0;
    public static final String KEY_FROME_WHERE = "key_from_where";

    public SelectFriendActivityConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }

    public SelectFriendActivityConfig(Context context, int i, int i2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra("key_from_where", i2);
    }
}
