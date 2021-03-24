package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class FaceGroupMakeActivityConfig extends IntentConfig {
    public static final String TYPE_MAKE_FOR_BAIZHU = "isCreateForBazhu";

    public FaceGroupMakeActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public FaceGroupMakeActivityConfig(Context context, boolean z, int i) {
        super(context);
        setRequestCode(i);
        getIntent().putExtra(TYPE_MAKE_FOR_BAIZHU, z);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
