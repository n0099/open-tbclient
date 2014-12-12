package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class CreateBarActivityConfig extends a {
    public static final String BAR_NAME_ISVALID = "isvalid";
    public static final String BAR_NAME_STRING = "barname";

    public CreateBarActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra(BAR_NAME_STRING, str);
        getIntent().putExtra(BAR_NAME_ISVALID, z);
    }
}
