package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes3.dex */
public class NotLoginGuideActivityConfig extends IntentConfig {
    public static String FROM_ACCOUNT = "from_account";
    public static String FROM_PAGE = "from_page";

    public NotLoginGuideActivityConfig(Context context, String str) {
        super(context);
        getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        getIntent().putExtra(FROM_PAGE, str);
    }

    public NotLoginGuideActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().setFlags(268468224);
        getIntent().putExtra(FROM_PAGE, str);
    }
}
