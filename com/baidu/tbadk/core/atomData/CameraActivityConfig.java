package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class CameraActivityConfig extends IntentConfig {
    public static final String CONTENT_TYPE_GENERAL = "general";
    public static final String CONTENT_TYPE_ID_CARD_BACK = "IDCardBack";
    public static final String CONTENT_TYPE_ID_CARD_FRONT = "IDCardFront";
    public static final String KEY_CONTENT_TYPE = "contentType";
    public static final String KEY_OUTPUT_FILE_PATH = "outputFilePath";

    public CameraActivityConfig(Context context, String str, String str2, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("outputFilePath", str);
        intent.putExtra("contentType", str2);
        intent.putExtra("request_code", i2);
    }
}
