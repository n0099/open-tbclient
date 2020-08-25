package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class FrsArActivityConfig extends IntentConfig {
    public static final String AR_ID = "ar_id";
    public static final String AR_TYPE = "ar_type";
    public static final String NAME = "name";
    public static final String TITLE_SHARE = "share_title";

    public FrsArActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("ar_id", str2);
        intent.putExtra("ar_type", str3);
        intent.putExtra(TITLE_SHARE, str4);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
    }
}
