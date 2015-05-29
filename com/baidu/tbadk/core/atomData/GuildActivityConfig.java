package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class GuildActivityConfig extends c {
    public static final String FROM_ABOUT_PAGE = "from_about_page";
    public static final String FROM_LOGO_PAGE = "from_logo_page";
    public static final String FROM_PAGE = "from_page";

    public GuildActivityConfig(Context context) {
        super(context);
    }

    public GuildActivityConfig createNormalCfg(String str) {
        getIntent().putExtra(FROM_PAGE, str);
        return this;
    }
}
