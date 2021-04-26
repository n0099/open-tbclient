package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class UpdateGroupActivityConfig extends IntentConfig {
    public static final String EDIT_TYPE = "edit_type";
    public static final String GROUP_TEXT = "group_text";

    public UpdateGroupActivityConfig(Context context, int i2, long j, int i3, String str) {
        super(context);
        getIntent().putExtra("group_id", j);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(GROUP_TEXT, str);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
