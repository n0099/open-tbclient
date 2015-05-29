package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class LiveLabelActivityConfig extends c {
    public static final String CURRENT_LABEL_ID = "current_label_id";
    public static final String FROM = "from";
    public static final String FROM_CREATE_LIVE = "from_create_live";
    public static final String FROM_CREATE_LIVE_MORE = "from_create_live_more";
    public static final String FROM_LIVE_SETTING = "from_live_setting";

    public LiveLabelActivityConfig(Context context, int i, int i2, String str) {
        super(context);
        setRequestCode(i);
        getIntent().putExtra(CURRENT_LABEL_ID, i2);
        getIntent().putExtra("from", str);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
