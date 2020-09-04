package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class NotLoginGuideActivityConfig extends IntentConfig {
    public static String FROM_PAGE = GuildActivityConfig.FROM_PAGE;
    public static String FROM_ACCOUNT = "from_account";

    public NotLoginGuideActivityConfig(Context context, String str) {
        super(context);
        getIntent().setFlags(67108864);
        getIntent().putExtra(FROM_PAGE, str);
    }

    public NotLoginGuideActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().setFlags(268468224);
        getIntent().putExtra(FROM_PAGE, str);
    }
}
