package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MainTabActivityConfig extends IntentConfig {
    public static final String IS_NEW_USER = "is_new_user";
    public static final String NEED_CLOSE_MENU = "need_close_menu";
    public static boolean IS_SUPPORT_LEFT_BAR = true;
    public static boolean IS_BACK_CLOSE_ALL_ACTIVITY = false;
    public static boolean IS_INDICATOR_BOTTOM = true;
    public static boolean ENTER_FORUM_DELEGATE_AVAILABLE = true;
    public static boolean DISCOVER_DELEGATE_AVAILABLE = true;
    public static boolean IMMESSAGE_CENTER_DELEGATE_AVAIBLE = true;
    public static boolean RECOMMEND_FRS_DELEGATE_AVAIBLE = true;
    public static boolean PERSON_TAB_AVAIBLE = true;
    public static boolean HOME_PAGE_DELEGATE_AVAIBLE = true;
    public static boolean TOGETHER_HI_TAB_AVAIBLE = true;

    public MainTabActivityConfig(Context context) {
        super(context);
    }

    public MainTabActivityConfig createNormalCfg(int i) {
        return createNewUserCfg(i, false, false);
    }

    public MainTabActivityConfig createNormalCfg(int i, boolean z) {
        return createNewUserCfg(i, false, z);
    }

    public MainTabActivityConfig createNewUserCfg(int i, boolean z, boolean z2) {
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
        intent.putExtra(NEED_CLOSE_MENU, z2);
        return this;
    }

    public MainTabActivityConfig createNewUserCfg(int i, boolean z) {
        return createNewUserCfg(i, z, false);
    }

    public MainTabActivityConfig createRefreshCfg(int i, boolean z) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        if (i == 200 || i == 12) {
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
