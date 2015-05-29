package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.c;
/* loaded from: classes.dex */
public class MainTabActivityConfig extends c {
    public static final String IS_NEW_USER = "is_new_user";
    public static boolean IS_SUPPORT_LEFT_BAR = true;
    public static boolean IS_BACK_CLOSE_ALL_ACTIVITY = false;
    public static boolean IS_INDICATOR_BOTTOM = true;
    public static boolean ENTER_FORUM_DELEGATE_AVAILABLE = true;
    public static boolean ADDRESS_LIST_DELEGATE_AVAILABLE = false;
    public static boolean DISCOVER_DELEGATE_AVAILABLE = true;
    public static boolean IMMESSAGE_CENTER_DELEGATE_AVAIBLE = true;
    public static boolean RECOMMEND_FRS_DELEGATE_AVAIBLE = true;

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
