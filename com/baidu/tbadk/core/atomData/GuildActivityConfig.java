package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class GuildActivityConfig extends IntentConfig {
    public static final String FROM_ABOUT_PAGE = "from_about_page";
    public static final String FROM_LOGO_PAGE = "from_logo_page";
    public static final String FROM_PAGE = "from_page";
    public static final String GUIDE_TYPE = "guide_type";
    public static final int GUIDE_TYPE_CUSTOM = 2;
    public static final int GUIDE_TYPE_VERSION = 1;

    public GuildActivityConfig(Context context) {
        super(context);
    }

    public GuildActivityConfig createNormalCfg(String str, boolean z) {
        return z ? createNormalCfg(str, 2) : createNormalCfg(str, 1);
    }

    public GuildActivityConfig createNormalCfg(String str, int i) {
        Intent intent = getIntent();
        intent.putExtra(FROM_PAGE, str);
        intent.putExtra(GUIDE_TYPE, i);
        return this;
    }
}
