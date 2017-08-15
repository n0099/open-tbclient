package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class NewUserGuideActivityConfig extends IntentConfig {
    public static final String HAS_LIEK_BAR = "has_like_bar";
    public static final String IS_NEW_USER = "is_new_user";

    public NewUserGuideActivityConfig(Context context, boolean z, boolean z2) {
        super(context);
        getIntent().putExtra("is_new_user", z);
        getIntent().putExtra(HAS_LIEK_BAR, z2);
    }

    public static boolean canResponse() {
        return i.hr() && MessageManager.getInstance().findTask(CmdConfigCustom.NEW_USER_GUIDE_PAGE) != null;
    }
}
