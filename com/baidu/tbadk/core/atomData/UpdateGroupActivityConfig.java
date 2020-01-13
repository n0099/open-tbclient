package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes6.dex */
public class UpdateGroupActivityConfig extends IntentConfig {
    public static final String EDIT_TYPE = "edit_type";
    public static final String GROUP_TEXT = "group_text";

    public UpdateGroupActivityConfig(Context context, int i, long j, int i2, String str) {
        super(context);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("edit_type", i2);
        getIntent().putExtra(GROUP_TEXT, str);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
