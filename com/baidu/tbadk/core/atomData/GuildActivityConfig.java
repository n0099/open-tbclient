package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class GuildActivityConfig extends IntentConfig {
    public static final String CUSTOM_GUIDE_SHOWED = "custom_guide_showed";
    public static final String FROM_ABOUT_PAGE = "from_about_page";
    public static final String FROM_LOGO_PAGE = "from_logo_page";
    public static final String FROM_PAGE = "from_page";
    public static final String IS_CUSTOM = "show_custom";

    public GuildActivityConfig(Context context) {
        super(context);
    }

    public GuildActivityConfig createNormalCfg(String str, boolean z) {
        Intent intent = getIntent();
        intent.putExtra(FROM_PAGE, str);
        intent.putExtra(IS_CUSTOM, z);
        return this;
    }
}
