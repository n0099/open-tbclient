package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class ScanQRActivityConfig extends IntentConfig {
    public static final String SCAN_RESULT_STRING = "result_String";

    public ScanQRActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("request_code", i);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
