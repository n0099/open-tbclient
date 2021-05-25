package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class MainTabActivityConfig extends IntentConfig {
    public static boolean ENTER_FORUM_DELEGATE_AVAILABLE = true;
    public static boolean ENTER_FORUM_TAB_AVAIBLE = true;
    public static final String EXIT_APP = "exit_app";
    public static boolean IMMESSAGE_CENTER_DELEGATE_AVAIBLE = true;
    public static boolean IS_BACK_CLOSE_ALL_ACTIVITY = false;
    public static boolean IS_INDICATOR_BOTTOM = true;
    public static final String IS_NEW_USER = "is_new_user";
    public static final String MAIN_TAB = "main_tab";
    public static boolean MEMBER_CENTER_TAB_AVAILABLE = true;
    public static final String NEED_CLOSE_MENU = "need_close_menu";
    public static boolean NEW_CATEGORY_TAB_AVAIBLE = true;
    public static boolean PERSON_TAB_AVAIBLE = true;
    public static final String PUSH_DES_PAGE = "des_page";
    public static final String PUSH_FOLLOW_UP_ACTION = "follow_up_action";
    public static final String TARGET_SCHEME = "target_scheme";
    public static final String VIDEOTHREAD_ON_SQUARE_ID = "videothread_on_square_id";

    public MainTabActivityConfig(Context context) {
        super(context);
    }

    public static void toExitApp(Context context) {
        MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(context);
        mainTabActivityConfig.getIntent().putExtra(EXIT_APP, true);
        mainTabActivityConfig.start();
    }

    public MainTabActivityConfig buildVideoThreadId(String str) {
        getIntent().putExtra(VIDEOTHREAD_ON_SQUARE_ID, str);
        return this;
    }

    public MainTabActivityConfig createNewUserCfg(int i2, boolean z, boolean z2) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        if (i2 >= 0) {
            intent.putExtra("locate_type", i2);
        }
        intent.putExtra("is_new_user", z);
        intent.putExtra("close_dialog", true);
        intent.putExtra(NEED_CLOSE_MENU, z2);
        return this;
    }

    public MainTabActivityConfig createNormalCfg(int i2) {
        return createNewUserCfg(i2, false, false);
    }

    public MainTabActivityConfig createRefreshCfg(int i2, boolean z) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        if (i2 != 200 && i2 != 12) {
            intent.putExtra(FrsActivityConfig.KEY_REFRESH, true);
        } else {
            intent.putExtra(FrsActivityConfig.KEY_REFRESH, false);
        }
        if (i2 >= 0) {
            intent.putExtra("locate_type", i2);
        }
        if (z) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("close_dialog", true);
        return this;
    }

    public void setPushDesPage(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(PUSH_DES_PAGE, str);
        }
    }

    public void setPushFollowUpAction(int i2) {
        if (getIntent() != null) {
            getIntent().putExtra(PUSH_FOLLOW_UP_ACTION, i2);
        }
    }

    public void setSubTab(int i2, String str) {
        if (getIntent() != null) {
            if (str == null) {
                getIntent().putExtra("sub_locate_type", i2);
            } else {
                getIntent().putExtra("sub_locate_type", str);
            }
        }
    }

    public void setSubTabName(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("sub_tab_name", str);
        }
    }

    public void setTargetScheme(String str) {
        getIntent().putExtra(TARGET_SCHEME, str);
    }

    public MainTabActivityConfig createNormalCfg(int i2, boolean z) {
        return createNewUserCfg(i2, false, z);
    }

    public MainTabActivityConfig createNewUserCfg(int i2, boolean z) {
        return createNewUserCfg(i2, z, false);
    }
}
