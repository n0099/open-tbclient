package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ThreadPrivacySelectActivityConfig extends IntentConfig {
    public static final String FORUM_COUNT = "forum_count";
    public static final String MASK_TYPE = "mask_type";

    public ThreadPrivacySelectActivityConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(25029);
    }
}
