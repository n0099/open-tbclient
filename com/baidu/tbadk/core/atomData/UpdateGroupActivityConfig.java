package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class UpdateGroupActivityConfig extends c {
    public static final String EDIT_TYPE = "edit_type";
    public static final String GROUP_TEXT = "group_text";

    public UpdateGroupActivityConfig(Context context, int i, int i2, int i3, String str) {
        super(context);
        getIntent().putExtra("group_id", i2);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(GROUP_TEXT, str);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
