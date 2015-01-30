package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class NotLoginGuideActivityConfig extends a {
    public static String FROM_PAGE = GuildActivityConfig.FROM_PAGE;
    public static String FROM_ACCOUNT = "from_account";
    public static String FROM_LOGO = "form_logo";

    public NotLoginGuideActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra(FROM_PAGE, str);
    }
}
