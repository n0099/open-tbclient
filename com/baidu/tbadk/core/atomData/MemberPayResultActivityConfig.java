package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MemberPayResultActivityConfig extends IntentConfig {
    public static final String PAY_CONTENT = "pay_content";

    public MemberPayResultActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(PAY_CONTENT, str);
    }
}
