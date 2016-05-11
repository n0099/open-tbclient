package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class CreateBarActivityConfig extends IntentConfig {
    public static final String BAR_NAME_ISVALID = "isvalid";
    public static final String BAR_NAME_STRING = "barname";
    public static boolean IS_SUPPORT_CREATE_BAR = false;

    public CreateBarActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("barname", str);
        getIntent().putExtra("isvalid", z);
    }
}
