package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LowFlowsActivityConfig extends IntentConfig {
    public static final String FROM_COMMON_DATA = "1";
    public static final String FROM_CUSTOM_DATA = "2";
    public static final String LF_BANNER_TEXT = "banner_text";
    public static final String LF_USER = "lf_user";
    public static final String LF_USER_INFO = "lf_user_info";
    public static final String LF_USER_TASKID = "lf_user_taskid";
    public static final String TAB_CODE = "tab_code";

    public LowFlowsActivityConfig(Context context, String str, String str2) {
        this(context, str, str2, "");
    }

    public LowFlowsActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra(TAB_CODE, str);
        getIntent().putExtra(LF_USER, str2);
        getIntent().putExtra(LF_USER_TASKID, str3);
    }
}
