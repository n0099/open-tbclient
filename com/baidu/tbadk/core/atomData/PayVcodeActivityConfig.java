package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class PayVcodeActivityConfig extends IntentConfig {
    public static final String VCODE_MD5 = "vcodeMd5";
    public static final String VCODE_RESULT = "vcode_result";
    public static final String VCODE_URL = "vcodeUrl";

    public PayVcodeActivityConfig(Context context, String str, String str2, int i2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        getIntent().putExtra(VCODE_MD5, str);
        getIntent().putExtra(VCODE_URL, str2);
    }
}
