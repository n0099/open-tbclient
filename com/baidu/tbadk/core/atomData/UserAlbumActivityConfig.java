package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class UserAlbumActivityConfig extends IntentConfig {
    public UserAlbumActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
