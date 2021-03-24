package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class SignAllForumAdvertActivityConfig extends IntentConfig {
    public static final String AD_PIC = "ad_pic";
    public static final String AD_URL = "ad_url";
    public static final String HAS_PRIVILEGE = "has_privilege";

    public SignAllForumAdvertActivityConfig(Context context) {
        super(context);
    }

    public SignAllForumAdvertActivityConfig(Context context, String str, String str2, Boolean bool) {
        super(context);
        getIntent().putExtra(AD_PIC, str);
        getIntent().putExtra(AD_URL, str2);
        getIntent().putExtra(HAS_PRIVILEGE, bool);
    }
}
