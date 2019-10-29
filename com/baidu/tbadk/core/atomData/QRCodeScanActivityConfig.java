package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class QRCodeScanActivityConfig extends IntentConfig {
    public static final String IS_AIAPP = "is_aiapp";
    public static final String RESULT_SCAN_CODE = "result_scan_code";

    public QRCodeScanActivityConfig(Context context) {
        super(context);
    }

    public QRCodeScanActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(IS_AIAPP, z);
        setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
