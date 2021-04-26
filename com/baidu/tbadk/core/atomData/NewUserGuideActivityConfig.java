package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.c.e.p.j;
/* loaded from: classes3.dex */
public class NewUserGuideActivityConfig extends IntentConfig {
    public static final String HAS_LIEK_BAR = "has_like_bar";
    public static final String IS_NEW_USER = "is_new_user";

    public NewUserGuideActivityConfig(Context context, boolean z, boolean z2) {
        super(context);
        getIntent().putExtra("is_new_user", z);
        getIntent().putExtra("has_like_bar", z2);
    }

    public static boolean canResponse() {
        return j.z() && MessageManager.getInstance().findTask(2012116) != null;
    }
}
