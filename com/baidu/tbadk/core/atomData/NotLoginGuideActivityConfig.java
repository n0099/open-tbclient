package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class NotLoginGuideActivityConfig extends IntentConfig {
    public static String FROM_PAGE = "from_page";
    public static String FROM_ACCOUNT = "from_account";
    public static String FROM_LOGO = "form_logo";

    public NotLoginGuideActivityConfig(Context context, String str) {
        super(context);
        getIntent().setFlags(67108864);
        getIntent().putExtra(FROM_PAGE, str);
    }
}
