package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class QRCodeLoginConfirmActivityConfig extends IntentConfig {
    public static final String QRCODE_RESULT = "qrcode_result";

    public QRCodeLoginConfirmActivityConfig(Context context, String str) {
        super(context);
        if (getIntent() != null) {
            getIntent().putExtra(QRCODE_RESULT, str);
        }
    }
}
