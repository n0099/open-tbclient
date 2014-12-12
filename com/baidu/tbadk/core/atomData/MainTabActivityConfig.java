package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class MainTabActivityConfig extends a {
    public static final String IS_NEW_USER = "is_new_user";

    public MainTabActivityConfig(Context context) {
        super(context);
    }

    public MainTabActivityConfig createNormalCfg(int i) {
        return createNewUserCfg(i, false);
    }

    public MainTabActivityConfig createNewUserCfg(int i, boolean z) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (i >= 0) {
            intent.putExtra("locate_type", i);
        }
        intent.putExtra("is_new_user", z);
        intent.putExtra("close_dialog", true);
        return this;
    }

    public MainTabActivityConfig createRefreshCfg(int i, boolean z) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        if (i == 200 || i == 12 || i == 11) {
            intent.putExtra(FrsActivityConfig.KEY_REFRESH, false);
        } else {
            intent.putExtra(FrsActivityConfig.KEY_REFRESH, true);
        }
        if (i >= 0) {
            intent.putExtra("locate_type", i);
        }
        if (z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("close_dialog", true);
        return this;
    }
}
